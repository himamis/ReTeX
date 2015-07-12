package org.scilab.forge.jlatexmath.resources;

import com.himamis.retex.renderer.share.platform.resources.ResourceLoader;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;

public class ResourceLoaderFactoryGWT implements ResourceLoaderFactory {

	@Override
	public ResourceLoader createResourceLoader() {
		return new ResourceLoaderW();
	}

}
