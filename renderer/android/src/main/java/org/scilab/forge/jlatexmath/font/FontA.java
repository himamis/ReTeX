package org.scilab.forge.jlatexmath.font;

import java.util.Map;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

import android.graphics.Typeface;

public class FontA implements Font {
	
	private Typeface mTypeface;
	private int mSize;
	
	public FontA(Typeface typeface, int size) {
		mTypeface = typeface;
		mSize = size;
	}
	
	public FontA(String name, int style, int size) {
		mTypeface = Typeface.create(name, getTypefaceStyle(style));
		mSize = size;
	}

	public Typeface getTypeface() {
		return mTypeface;
	}
	
	public int getSize() {
		return mSize;
	}

	public Font deriveFont(Map<TextAttribute, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public Font deriveFont(int type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static int getTypefaceStyle(int fontStyle) {
		int typefaceStyle = Typeface.NORMAL;

		if (fontStyle == BOLD) {
			typefaceStyle = Typeface.BOLD;
		} else if (fontStyle == ITALIC) {
			typefaceStyle = Typeface.ITALIC;
		} else if (fontStyle == (BOLD | ITALIC)) {
			typefaceStyle = Typeface.BOLD_ITALIC;
		}

		return typefaceStyle;
	}
}
