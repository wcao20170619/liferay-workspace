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

package com.liferay.sync.encryptor;

import com.liferay.sync.encryptor.internal.util.Base64;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Dennis Ju
 */
public class SyncEncryptor {

	public static String decrypt(String value) throws Exception {
		return decrypt(value, 2);
	}

	public static String decrypt(String value, int passwordVersion)
		throws Exception {

		if (value == null) {
			return "";
		}

		SecretKey secretKey = new SecretKeySpec(
			_getPassword(passwordVersion), _ALGORITHM);

		Cipher cipher = Cipher.getInstance(_ALGORITHM);

		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		for (int i = 0; i < _ITERATIONS; i++) {
			byte[] decodedBytes = Base64.decode(value);

			byte[] decryptedBytes = cipher.doFinal(decodedBytes);

			value = new String(decryptedBytes, _UTF8_CHARSET);
		}

		return value;
	}

	public static String encrypt(String value) throws Exception {
		return encrypt(value, 2);
	}

	public static String encrypt(String value, int passwordVersion)
		throws Exception {

		if (value == null) {
			return "";
		}

		SecretKey secretKey = new SecretKeySpec(
			_getPassword(passwordVersion), _ALGORITHM);

		Cipher cipher = Cipher.getInstance(_ALGORITHM);

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		for (int i = 0; i < _ITERATIONS; i++) {
			byte[] encryptedBytes = cipher.doFinal(
				value.getBytes(_UTF8_CHARSET));

			value = Base64.encode(encryptedBytes);
		}

		return value;
	}

	private static byte[] _getPassword(int version) {
		if (version == 1) {
			return _PASSWORD_V1;
		}

		return _PASSWORD_V2;
	}

	private static final String _ALGORITHM = "AES";

	private static final int _ITERATIONS = 8;

	private static final byte[] _PASSWORD_V1 = {
		(byte)0x56, (byte)0x78, (byte)0x7e, (byte)0x36, (byte)0x50, (byte)0x64,
		(byte)0x7a, (byte)0x2e, (byte)0x2b, (byte)0x68, (byte)0x25, (byte)0x58,
		(byte)0x45, (byte)0x39, (byte)0x4a, (byte)0x6f
	};

	private static final byte[] _PASSWORD_V2 = {
		(byte)0x65, (byte)0x3a, (byte)0x61, (byte)0x59, (byte)0x6a, (byte)0x3a,
		(byte)0x27, (byte)0x35, (byte)0x41, (byte)0x2c, (byte)0x4f, (byte)0x75,
		(byte)0x60, (byte)0x78, (byte)0x78, (byte)0x7e
	};

	private static final Charset _UTF8_CHARSET = Charset.forName("UTF-8");

}