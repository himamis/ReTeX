/**
 * This file is part of the ReTeX library - https://github.com/himamis/ReTeX
 *
 * Copyright (C) 2015 Balazs Bencze
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 *
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package com.himamis.retex.renderer.web.font.opentype;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.himamis.retex.renderer.web.font.FontWrapper;

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
		var font = that.@com.himamis.retex.renderer.web.font.opentype.OpentypeFontWrapper::impl;
		var path = font.getPath(c, x, y, size);

		path.fill = ctx.fillStyle;
		path.stroke = null;
		path.strokeWidth = 1;

		// reset the path before to ensure that the previous drawing doesn't interfere with this one
		ctx.beginPath();

		path.draw(ctx);

		// reset the path, so that the following calls to stroke() and fill() will not draw again the character
		ctx.beginPath();
	}-*/;
}