package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;

import android.content.res.AssetManager;

public class FontFactoryAndroid extends FontFactory {
	
	private AssetManager mAssetManager;
	
	public FontFactoryAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	@Override
	public Font createFont(String name, int style, int size) {
		return new FontA(name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font,
			FontRenderContext fontRenderContext) {
		return new TextLayoutA(string, (FontA) font, (FontRenderContextA) fontRenderContext);
	}

	@Override
	public TextAttributeProvider createTextAttributeProvider() {
		return new TextAttributeProviderA();
	}

	@Override
	public FontLoader createFontLoader() {
		return new FontLoaderA(mAssetManager);
	}

}
