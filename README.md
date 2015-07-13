JLaTeXMath Multiplatform
========================

This project is a fork of the original JLaTeXMath (http://forge.scilab.org/index.php/p/jlatexmath/), refactored to be used through different platforms, such as desktop, android and web (using GWT). </br></br>
[![Build Status](https://travis-ci.org/himamis/jlatexmath-multiplatform.svg?branch=master)](https://travis-ci.org/himamis/jlatexmath-multiplatform)

##Include in your project
###Using gradle
####Desktop
```groovy
dependencies {
    compile project(':jlatexmath-desktop) 
}
```
####Android
```groovy
dependencies {
    compile project(':jlatexmath-android) // for android API 7 and up
}
```
####GWT Web application
```groovy
dependencies {
    compile project(':jlatexmath-gwt'),
        project(':jlatexmath-share'),
        files(project(':jlatexmath-gwt').sourceSets.main.allSource.srcDirs),
        files(project(':jlatexmath-share').sourceSets.main.java.srcDirs)
}
```
{AppName}.gwt.xml
```xml
<module>
    ...
    <inherits name='org.scilab.forge.JLaTeXMathGWT'/>
    ...
</module>
```
####Web application
Grab the folder from `jlatexmath-gwt/dist`. For examples please see `jlatexmath-gwt/war`
##Usage

Before using the API, set the platform dependent factory instance.

**Android**
```java
	FactoryProvider.INSTANCE = new FactoryProviderAndroid(getAssets());
```

**Desktop**
```java
	FactoryProvider.INSTANCE = new FactoryProviderDesktop();
```

**GWT Web application**
```java
	FactoryProvider.INSTANCE = new FactoryProviderGWT();
```
</br>
For details of the original API please see http://forge.scilab.org/index.php/p/jlatexmath/.
</br></br>

**Web application**
```
    jlmlib.drawLatex(options)
```

For parameters, please see `jlatexmath-gwt/war/index.html`

Screenshots
-----------
![Alt text](/../others/screenshots/example1.PNG?raw=true "Example 1")

![Alt text](/../others/screenshots/example2.PNG?raw=true "Example 2")

![Alt text](/../others/screenshots/example3.png?raw=true "Example 3")
