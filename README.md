JLaTeXMath Multiplatform
========================

This project is a fork of the original JLaTeXMath (http://forge.scilab.org/index.php/p/jlatexmath/), refactored to be used through different platforms, such as desktop, android and web (using GWT).

Warning
-------

This project is subject to development. APIs will change. Use at own risk.

Usage
-----

Before using the API, set the platform dependent factory instance.

**Android**
```java
	FactoryProvider.INSTANCE = new FactoryProviderAndroid(getAssets());
```

**Desktop**
```java
	FactoryProvider.INSTANCE = new FactoryProviderDesktop();
```

**GWT**

*Coming soon...*

For details of the original API please see http://forge.scilab.org/index.php/p/jlatexmath/.