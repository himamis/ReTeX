package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.font.FontFactoryAndroid;
import org.scilab.forge.jlatexmath.geom.GeomFactoryAndroid;
import org.scilab.forge.jlatexmath.graphics.GraphicsFactoryAndroid;
import org.scilab.forge.jlatexmath.parser.ParserFactoryAndroid;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;
import org.scilab.forge.jlatexmath.resources.ResourceLoaderFactoryAndroid;

import android.content.res.AssetManager;

public class FactoryProviderAndroid extends FactoryProvider {
	
	private AssetManager mAssetManager;
	
	public FactoryProviderAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryAndroid();
	}

	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryAndroid(mAssetManager);
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryAndroid();
	}

	@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryAndroid();
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryAndroid(mAssetManager);
	}
}
