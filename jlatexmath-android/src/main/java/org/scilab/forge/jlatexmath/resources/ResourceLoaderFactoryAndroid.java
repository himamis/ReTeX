package org.scilab.forge.jlatexmath.resources;

import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;

import android.content.res.AssetManager;

public class ResourceLoaderFactoryAndroid implements ResourceLoaderFactory {
	
	private AssetManager mAssetManager;
	
	public ResourceLoaderFactoryAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	public ResourceLoader createResourceLoader() {
		return new ResourceLoaderA(mAssetManager);
	}

}
