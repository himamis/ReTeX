package com.himamis.retex.renderer.web.font;

public interface FontLoaderWrapper {
	
	AsyncLoadedFont createNativeFont(String pathName, String name, int style, int size);

}
