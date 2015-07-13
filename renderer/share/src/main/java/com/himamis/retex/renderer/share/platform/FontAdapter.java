package com.himamis.retex.renderer.share.platform;

import com.himamis.retex.renderer.share.exception.ResourceParseException;
import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.font.FontLoader;
import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.share.platform.font.TextAttribute;
import com.himamis.retex.renderer.share.platform.font.TextAttributeProvider;
import com.himamis.retex.renderer.share.platform.font.TextLayout;

public class FontAdapter {

	private final FontFactory fontFactory;
	private final FontLoader fontLoader;
	private final TextAttributeProvider textAttributeProvider;

	public FontAdapter() {
		fontFactory = FactoryProvider.INSTANCE.getFontFactory();
		fontLoader = fontFactory.createFontLoader();
		textAttributeProvider = fontFactory.createTextAttributeProvider();
	}

	public Font loadFont(String name) throws ResourceParseException {
		return loadFont(null, name);
	}

	public Font loadFont(Object fontType, String name) throws ResourceParseException {
		return fontLoader.loadFont(fontType, name);
	}

	public Font createFont(String name, int style, int size) {
		return fontFactory.createFont(name, style, size);
	}

	public TextLayout createTextLayout(String string, Font font, FontRenderContext fontRenderContext) {
		return fontFactory.createTextLayout(string, font, fontRenderContext);
	}

	public TextAttribute getTextAttribute(String attribute) {
		return textAttributeProvider.getTextAttribute(attribute);
	}

	public Integer getTextAttributeValue(String attributeValue) {
		return textAttributeProvider.getTextAttributeValue(attributeValue);
	}

}
