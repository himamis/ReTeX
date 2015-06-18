JLaTeXMath Multiplatform
========================

This project is a fork of the original JLaTeXMath (http://forge.scilab.org/index.php/p/jlatexmath/), refactored to be used through different platforms, such as desktop, android and web (using GWT).

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
Compile the project with
```
$ ./gradlew :jlatexmath-gwt:compileGwt
```
and include the output from `jlatexmath-gwt/build/gwt/out/jlatexmath`
OR
Grab the folder from `jlatexmath-gwt\dist`

For examples please see `jlatexmath-gwt\war`
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

**GWT**
```java
	FactoryProvider.INSTANCE = new FactoryProviderGWT();
```

For details of the original API please see http://forge.scilab.org/index.php/p/jlatexmath/.


Screenshots
-----------
![Alt text](/../others/screenshots/example1.PNG?raw=true "Example 1")

![Alt text](/../others/screenshots/example2.PNG?raw=true "Example 2")

![Alt text](/../others/screenshots/example3.png?raw=true "Example 3")
