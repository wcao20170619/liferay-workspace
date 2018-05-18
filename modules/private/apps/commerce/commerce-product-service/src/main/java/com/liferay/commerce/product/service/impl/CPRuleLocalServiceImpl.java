/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.product.service.impl;

import com.liferay.commerce.product.catalog.rule.CPRuleType;
import com.liferay.commerce.product.catalog.rule.CPRuleTypeRegistry;
import com.liferay.commerce.product.exception.CPRuleTypeException;
import com.liferay.commerce.product.model.CPRule;
import com.liferay.commerce.product.service.base.CPRuleLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marco Leo
 * @author Alessio Antonio Rendina
 */
public class CPRuleLocalServiceImpl extends CPRuleLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CPRule addCPRule(
			String name, boolean active, String type,
			ServiceContext serviceContext)
		throws PortalException {

		// Commerce product rule

		User user = userLocalService.getUser(serviceContext.getUserId());
		long groupId = serviceContext.getScopeGroupId();

		validate(type);

		long cpRuleId = counterLocalService.increment();

		CPRule cpRule = cpRulePersistence.create(cpRuleId);

		cpRule.setGroupId(groupId);
		cpRule.setCompanyId(user.getCompanyId());
		cpRule.setUserId(user.getUserId());
		cpRule.setUserName(user.getFullName());
		cpRule.setName(name);
		cpRule.setActive(active);
		cpRule.setType(type);
		cpRule.setExpandoBridgeAttributes(serviceContext);

		cpRulePersistence.update(cpRule);

		// Resources

		resourceLocalService.addModelResources(cpRule, serviceContext);

		return cpRule;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public CPRule deleteCPRule(CPRule cpRule) throws PortalException {

		// Commerce product rule asset category rels

		cpRuleAssetCategoryRelLocalService.
			deleteCPRuleAssetCategoryRelsByCPRuleId(cpRule.getCPRuleId());

		// Commerce product rule user segment rels

		cpRuleUserSegmentRelLocalService.deleteCPRuleUserSegmentRelsByCPRuleId(
			cpRule.getCPRuleId());

		// Commerce product rule

		cpRulePersistence.remove(cpRule);

		// Resources

		resourceLocalService.deleteResource(
			cpRule, ResourceConstants.SCOPE_INDIVIDUAL);

		// Expando

		expandoRowLocalService.deleteRows(cpRule.getCPRuleId());

		return cpRule;
	}

	@Override
	public CPRule deleteCPRule(long cpRuleId) throws PortalException {
		CPRule cpRule = cpRulePersistence.findByPrimaryKey(cpRuleId);

		return cpRuleLocalService.deleteCPRule(cpRule);
	}

	@Override
	public void deleteCPRules(long groupId) throws PortalException {
		List<CPRule> cpRules = cpRulePersistence.findByGroupId(groupId);

		for (CPRule cpRule : cpRules) {
			cpRuleLocalService.deleteCPRule(cpRule.getCPRuleId());
		}
	}

	@Override
	public List<CPRule> getCPRules(
		long groupId, int start, int end,
		OrderByComparator<CPRule> orderByComparator) {

		return cpRulePersistence.findByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public int getCPRulesCount(long groupId) {
		return cpRulePersistence.countByGroupId(groupId);
	}

	@Override
	public BaseModelSearchResult<CPRule> searchCPRules(
			long companyId, long groupId, String keywords, int start, int end,
			Sort sort)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			companyId, groupId, keywords, start, end, sort);

		return cpRuleLocalService.searchCPRules(searchContext);
	}

	@Override
	public BaseModelSearchResult<CPRule> searchCPRules(
			SearchContext searchContext)
		throws PortalException {

		Indexer<CPRule> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			CPRule.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext, _SELECTED_FIELD_NAMES);

			List<CPRule> cpRules = getCPRules(hits);

			if (cpRules != null) {
				return new BaseModelSearchResult<>(cpRules, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CPRule updateCPRule(
			long cpRuleId, String name, boolean active, String type,
			ServiceContext serviceContext)
		throws PortalException {

		CPRule cpRule = cpRulePersistence.findByPrimaryKey(cpRuleId);

		validate(type);

		cpRule.setName(name);
		cpRule.setActive(active);
		cpRule.setType(type);
		cpRule.setExpandoBridgeAttributes(serviceContext);

		return cpRulePersistence.update(cpRule);
	}

	protected SearchContext buildSearchContext(
		long companyId, long groupId, String keywords, int start, int end,
		Sort sort) {

		SearchContext searchContext = new SearchContext();

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("keywords", keywords);

		Map<String, Serializable> attributes = new HashMap<>();

		attributes.put(Field.NAME, keywords);
		attributes.put("params", params);

		searchContext.setAttributes(attributes);

		searchContext.setCompanyId(companyId);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setGroupIds(new long[] {groupId});

		if (Validator.isNotNull(keywords)) {
			searchContext.setKeywords(keywords);
		}

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.setHighlightEnabled(false);
		queryConfig.setScoreEnabled(false);

		if (sort != null) {
			searchContext.setSorts(sort);
		}

		return searchContext;
	}

	protected List<CPRule> getCPRules(Hits hits) throws PortalException {
		List<Document> documents = hits.toList();

		List<CPRule> cpRules = new ArrayList<>(documents.size());

		for (Document document : documents) {
			long cpRuleId = GetterUtil.getLong(
				document.get(Field.ENTRY_CLASS_PK));

			CPRule cpRule = fetchCPRule(cpRuleId);

			if (cpRule == null) {
				cpRules = null;

				Indexer<CPRule> indexer = IndexerRegistryUtil.getIndexer(
					CPRule.class);

				long companyId = GetterUtil.getLong(
					document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (cpRules != null) {
				cpRules.add(cpRule);
			}
		}

		return cpRules;
	}

	protected void validate(String type) throws PortalException {
		CPRuleType cpRuleType = _cpRuleTypeRegistry.getCPRuleType(type);

		if (cpRuleType == null) {
			throw new CPRuleTypeException();
		}
	}

	private static final String[] _SELECTED_FIELD_NAMES =
		{Field.ENTRY_CLASS_PK, Field.COMPANY_ID, Field.GROUP_ID, Field.UID};

	@ServiceReference(type = CPRuleTypeRegistry.class)
	private CPRuleTypeRegistry _cpRuleTypeRegistry;

}