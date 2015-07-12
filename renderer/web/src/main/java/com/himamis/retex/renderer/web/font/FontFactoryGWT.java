package com.himamis.retex.renderer.web.font;

import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.font.FontLoader;
import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.share.platform.font.TextAttributeProvider;
import com.himamis.retex.renderer.share.platform.font.TextLayout;
import com.himamis.retex.renderer.web.font.opentype.Opentype;

public class FontFactoryGWT extends FontFactory {
	
	private FontLoaderWrapper fontLoaderWrapper = Opentype.INSTANCE;

	@Override
	public Font createFont(String name, int style, int size) {
		return new DefaultFont(name, style, size);
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
