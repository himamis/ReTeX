package com.himamis.retex.renderer.android.font;

import java.util.Map;

import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.TextAttribute;

import android.graphics.Typeface;

public class FontA implements Font {
	
	private Typeface mTypeface;
	private int mSize;
	private String mName;
	
	public FontA(String name, Typeface typeface, int size) {
		mName = name;
		mTypeface = typeface;
		mSize = size;
	}
	
	public FontA(String name, int style, int size) {
		mTypeface = Typeface.create(name, getTypefaceStyle(style));
		mName = name;
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
