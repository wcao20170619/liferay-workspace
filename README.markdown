# Liferay Portal

This branch contains only the private modules that are included in Liferay DXP.

## Building

1. Run the following command to checkout the public `master` branch and make the
appropriate source code replacements to create a DXP environment:

		ant -f build-working-dir.xml

2. If the command above fails, it's possible to skip the replacements and
checkout the `master` branch by running the following command:

		ant -f build-working-dir.xml checkout-portal

3. Once the environment is created, build the portal as usual:

		ant all