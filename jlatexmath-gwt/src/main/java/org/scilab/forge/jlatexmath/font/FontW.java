package org.scilab.forge.jlatexmath.font;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scilab.forge.jlatexmath.font.opentype.OpentypeFont;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public class FontW implements Font {
	
	public static interface FontLoadedListener {
		public void onFontLoaded(FontW font);
	}

	public List<FontLoadedListener> listeners;

	private String name;
	private int style;
	private int size;

	private OpentypeFont implementation;

	public FontW(String name, int style, int size) {
		this.name = name;
		this.style = style;
		this.size = size;
		listeners = new ArrayList<FontW.FontLoadedListener>();
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

	/**
	 * @return true if the font has been loaded to the browser
	 */
	public boolean isLoaded() {
		return implementation != null;
	}

	public void setImplementation(OpentypeFont impl) {
		implementation = impl;
	}

	public OpentypeFont getImplementation() {
		return implementation;
	}

	public boolean containsListener(FontLoadedListener listener) {
		return listeners.contains(listener);
	}

	public void addFontListener(FontLoadedListener listener) {
		listeners.add(listener);
	}

	public void removeFontListener(FontLoadedListener listener) {
		listeners.remove(listener);
	}

	public void fireFontLoadedEvent() {
		for (FontLoadedListener listener : listeners) {
			listener.onFontLoaded(this);
		}
	}
}
