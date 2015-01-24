package org.jlatexmath.android;

import org.jlatexmath.android.font.FontFactoryAndroid;
import org.jlatexmath.android.geom.GeomFactoryAndroid;
import org.jlatexmath.android.graphics.GraphicsFactoryAndroid;
import org.jlatexmath.android.parser.ParserFactoryAndroid;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;

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
		return new ParserFactoryAndroid(mAssetManager);
	}

}
