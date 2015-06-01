package org.scilab.forge.jlatexmath.font.opentype;

import org.scilab.forge.jlatexmath.font.FontWrapper;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public class OpentypeFontWrapper implements FontWrapper {

	private JavaScriptObject impl;

	public OpentypeFontWrapper(JavaScriptObject impl) {
		this.impl = impl;
	}
	
	@Override
	public void drawGlyph(String c, int x, int y, int size, Context2d ctx) {
		drawGlyphNative(c, x, y, size, ctx);
	}

	private native void drawGlyphNative(String c, int x, int y, int size, Context2d ctx) /*-{
		var that = this;
		var font = that.@org.scilab.forge.jlatexmath.font.opentype.OpentypeFontWrapper::impl;
		var glyph = font.charToGlyph(c);
		var path = glyph.getPath(x, y, size);
		path.fill = ctx.fillStyle
		path.draw(ctx);
	}-*/;
}