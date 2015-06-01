package org.scilab.forge.jlatexmath.font;

public interface FontLoaderWrapper {
	
	AsyncLoadedFont createNativeFont(String pathName, String name, int style, int size);

}
