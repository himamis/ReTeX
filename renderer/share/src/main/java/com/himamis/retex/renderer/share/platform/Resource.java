package com.himamis.retex.renderer.share.platform;

import com.himamis.retex.renderer.share.exception.ResourceParseException;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoader;

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
