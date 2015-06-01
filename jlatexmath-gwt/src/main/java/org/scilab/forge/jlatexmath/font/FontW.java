package org.scilab.forge.jlatexmath.font;

import java.util.Map;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public abstract class FontW implements AsyncLoadedFont {

	protected String name;
	protected int style;
	protected int size;

	public FontW(String name, int style, int size) {
		this.name = name;
		this.style = style;
		this.size = size;
	}

	@Override
	public Font deriveFont(Map<TextAttribute, Object> map) {
		return this;
	}

	public String getName() {
		return name;
	}

	public int getStyle() {
		return style;
	}

	public int getSize() {
		return size;
	}

	public String getCssFontString() {
		String font = "";
		font += getStyleString() + " ";
		font += size + "px ";
		font += name;
		return font;
	}

	private String getStyleString() {
		switch (style) {
		case PLAIN:
			return "normal";
		case ITALIC:
			return "italic";
		case BOLD:
			return "bold";
		default:
			return "normal";
		}
	}
}
