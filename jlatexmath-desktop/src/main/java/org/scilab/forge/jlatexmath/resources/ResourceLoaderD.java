package org.scilab.forge.jlatexmath.resources;

import java.io.InputStream;

import org.scilab.forge.jlatexmath.FactoryProviderDesktop;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

public class ResourceLoaderD implements ResourceLoader {

	public InputStream loadResource(Object base, String path) throws ResourceParseException {
		if (base != null) {
			return ((Class<?>) base).getResourceAsStream(path);
		} else {
			return FactoryProviderDesktop.class.getResourceAsStream(path);
		}
	}

}
