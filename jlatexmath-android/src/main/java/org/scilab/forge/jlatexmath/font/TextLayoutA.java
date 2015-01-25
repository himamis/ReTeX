package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.geom.Rectangle2DA;
import org.scilab.forge.jlatexmath.graphics.Graphics2DA;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;

public class TextLayoutA implements TextLayout {
	
	private Paint mPaint;
	private String mString;
	
	private FontA mFont;
	
	public TextLayoutA(String string, FontA font, FontRenderContextA fontRenderContext) {
		mString = string;
		mFont = font;
		mPaint = fontRenderContext.getPaint();
	}

	public Rectangle2D getBounds() {
		updatePaint();
		Rect bounds = new Rect();
		
		mPaint.getTextBounds(mString, 0, mString.length(), bounds);
		
		return new Rectangle2DA(bounds);
	}

	public void draw(Graphics2DInterface graphics, int x, int y) {
		updatePaint();
		
		Graphics2DA g2d = (Graphics2DA) graphics;
		g2d.drawString(mString, x, y, mPaint);
	}

	private void updatePaint() {
		mPaint.setTypeface((Typeface) mFont.getNativeObject());
		mPaint.setTextSize(mFont.getSize());
		mPaint.setStyle(Style.FILL);
	}
}
