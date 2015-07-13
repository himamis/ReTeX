package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;

import android.graphics.Paint;

public class FontRenderContextA implements FontRenderContext {
	
	private Paint mPaint;
	
	public FontRenderContextA(Paint paint) {
		mPaint = paint;
	}

	public Paint getPaint() {
		return mPaint;
	}

}
