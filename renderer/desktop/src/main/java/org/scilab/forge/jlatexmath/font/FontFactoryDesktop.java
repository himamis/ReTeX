package org.scilab.forge.jlatexmath.font;

import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.font.FontLoader;
import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.share.platform.font.TextAttributeProvider;
import com.himamis.retex.renderer.share.platform.font.TextLayout;

public class FontFactoryDesktop extends FontFactory {

	@Override
	public Font createFont(String name, int style, int size) {
		return new FontD(name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font,
			FontRenderContext fontRenderContext) {
		return new TextLayoutD(string, ((FontD) font).impl,
				((FontRenderContextD) fontRenderContext).impl);
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
