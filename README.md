ReTeX
=====

This project is a fork of the original JLaTeXMath (http://forge.scilab.org/index.php/p/jlatexmath/), refactored to be used through different platforms, such as desktop, android and web (using GWT).

##Include in your project
###Using gradle
####Desktop
```groovy
dependencies {
    compile project(':renderer:desktop') 
}
```
####Android
```groovy
dependencies {
    compile project(':renderer:android') // for android API 7 and up
}
```
####GWT Web application
```groovy
dependencies {
    compile project(':renderer:web'),
        project(':renderer:share'),
        files(project(':renderer:web').sourceSets.main.allSource.srcDirs),
        files(project(':renderer:share').sourceSets.main.java.srcDirs)
}
```
{AppName}.gwt.xml
```xml
<module>
    ...
    <inherits name='com.himamis.retex.renderer.web.JLaTeXMathGWT'/>
    ...
</module>
```
####Web application
Grab the folder from `renderer/web/dist`. For examples please see `renderer/web/war`
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

For parameters, please see `renderer/web/war/index.html`

Screenshots
-----------
![Alt text](/../others/screenshots/example1.PNG?raw=true "Example 1")

![Alt text](/../others/screenshots/example2.PNG?raw=true "Example 2")

![Alt text](/../others/screenshots/example3.png?raw=true "Example 3")

FAQ
-----------
Regarding JLaTeXMath’s Classpath Exception and JavaScript: If you use the Google Web Toolkit (GWT) to compile JLaTeXMath to an “executable” (in JavaScript) you can then include/link this “executable” JavaScript library on a website or inside another program. In this case the rest of the website/program need not be licensed under the GPL.
