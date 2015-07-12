package org.scilab.forge.jlatexmath.resources;

import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;

public class ResourceLoaderFactoryGWT implements ResourceLoaderFactory {

	@Override
	public ResourceLoader createResourceLoader() {
		return new ResourceLoaderW();
	}

}
