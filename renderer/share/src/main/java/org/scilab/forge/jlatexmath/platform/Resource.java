package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

public class Resource {

	private final ResourceLoader resourceLoader;

	public Resource() {
		resourceLoader = FactoryProvider.INSTANCE.createResourceLoaderFactory().createResourceLoader();
	}

	public Object loadResource(String path) throws ResourceParseException {
		return resourceLoader.loadResource(null, path);
	}

	public Object loadResource(Object base, String path) {
		return resourceLoader.loadResource(base, path);
	}
}
