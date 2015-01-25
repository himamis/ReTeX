package org.scilab.forge.jlatexmath.resources;

import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;

public class ResourceLoaderFactoryDesktop implements ResourceLoaderFactory {

	public ResourceLoader createResourceLoader() {
		return new ResourceLoaderD();
	}

}
