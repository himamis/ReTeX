package org.scilab.forge.jlatexmath.resources;

import java.io.IOException;
import java.io.InputStream;

import org.scilab.forge.jlatexmath.BaseObjectHelper;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

import android.content.res.AssetManager;

public class ResourceLoaderA implements ResourceLoader {
	
	private AssetManager mAssetManager;
	
	public ResourceLoaderA(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	public InputStream loadResource(Object base, String path) throws ResourceParseException {
		try {
			return mAssetManager.open(BaseObjectHelper.getPath(base, path));
		} catch (IOException e) {
			throw new ResourceParseException("Could not load resource.", e);
		}
	}

}
