package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;

public class FontFactoryDesktop extends FontFactory {

	@Override
	public Font createFont(String name, int style, int size) {
		return new FontD(name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font,
			FontRenderContext fontRenderContext) {
		return new TextLayoutD(string, ((FontD) font).impl,
				(java.awt.font.FontRenderContext) fontRenderContext);
	}

	@Override
	public TextAttributeProvider createTextAttributeProvider() {
		return new TextAttributeProviderD();
	}

	@Override
	public FontLoader createFontLoader() {
		return new FontLoaderD();
	}
}
