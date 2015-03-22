JLaTeXMath Multiplatform
========================

This project is a fork of the original JLaTeXMath (http://forge.scilab.org/index.php/p/jlatexmath/), refactored to be used through different platforms, such as desktop, android and web (using GWT).

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


Screenshots
-----------
![Alt text](/../others/screenshots/example1.PNG?raw=true "Example 1")

![Alt text](/../others/screenshots/example2.PNG?raw=true "Example 2")

![Alt text](/../others/screenshots/example3.png?raw=true "Example 3")
