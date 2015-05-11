package org.scilab.forge.jlatexmath.font.opentype;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public class OpentypeFont {

	private JavaScriptObject impl;

	public OpentypeFont(JavaScriptObject impl) {
		this.impl = impl;
	}

	/**
	 * Draws the first glyph from the string.
	 * @param c string
	 * @param x x
	 * @param y y
	 * @param size font size
	 * @param ctx context
	 */
	public native void drawGlyph(String c, int x, int y, int size, Context2d ctx) /*-{
		var that = this;
		var font = that.@org.scilab.forge.jlatexmath.font.opentype.OpentypeFont::impl;
		var glyph = font.charToGlyph(c);
		var path = glyph.getPath(x, y, size);
		path.fill = ctx.fillStyle
		path.draw(ctx);
	}-*/;
}