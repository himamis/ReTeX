package org.scilab.forge.jlatexmath.font;

import java.util.Map;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public class FontW implements Font {

	private String name;
	private int style;
	private int size;

	public FontW(String name, int style, int size) {
		this.name = name;
		this.style = style;
		this.size = size;
	}

	@Override
	public Font deriveFont(Map<TextAttribute, Object> map) {
		return this;
	}

	@Override
	public Font deriveFont(int type) {
		return new FontW(name, type, size);
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

}
