package org.jlatexmath.android.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.Color;

public class ColorA implements Color {
	
	private int mColor;

	public ColorA(int color) {
		mColor = color;
	}
	
	public ColorA(int red, int green, int blue) {
		mColor = android.graphics.Color.rgb(red, green, blue);
	}

	public Object getNativeObject() {
		return new Integer(mColor);
	}

	public int getColor() {
		return mColor;
	}
}
