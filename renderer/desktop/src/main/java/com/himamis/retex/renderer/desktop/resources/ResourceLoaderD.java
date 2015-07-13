package com.himamis.retex.renderer.desktop.resources;

import java.io.InputStream;

import com.himamis.retex.renderer.desktop.FactoryProviderDesktop;
import com.himamis.retex.renderer.share.exception.ResourceParseException;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoader;

public class ResourceLoaderD implements ResourceLoader {

	public InputStream loadResource(Object base, String path) throws ResourceParseException {
		if (base != null) {
			return ((Class<?>) base).getResourceAsStream(path);
		} else {
			return FactoryProviderDesktop.class.getResourceAsStream(path);
		}
	}

}