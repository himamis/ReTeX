package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.font.opentype.Opentype;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;

public class FontFactoryGWT extends FontFactory {
	
	private FontLoaderWrapper fontLoaderWrapper = Opentype.INSTANCE;

	@Override
	public Font createFont(String name, int style, int size) {
		return fontLoaderWrapper.createNativeFont("", name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font, FontRenderContext fontRenderContext) {
		return new TextLayoutW(string, font, fontRenderContext);
	}

	@Override
	public TextAttributeProvider createTextAttributeProvider() {
		return new TextAttributeProviderW();
	}

	@Override
	public FontLoader createFontLoader() {
		return new FontLoaderW(fontLoaderWrapper);
	}

}
