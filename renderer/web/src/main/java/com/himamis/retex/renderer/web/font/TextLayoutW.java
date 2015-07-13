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
package com.himamis.retex.renderer.web.font;

import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.share.platform.font.TextLayout;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;
import com.himamis.retex.renderer.web.geom.Rectangle2DW;
import com.himamis.retex.renderer.web.graphics.FontRenderContextW;
import com.himamis.retex.renderer.web.graphics.Graphics2DW;

public class TextLayoutW implements TextLayout {

	private String string;
	private FontW font;
	private FontRenderContextW fontRenderContext;

	public TextLayoutW(String string, Font font,
			FontRenderContext fontRenderContext) {
		this.string = string;
		this.font = (FontW) font;
		this.fontRenderContext = ((FontRenderContextW) fontRenderContext);
	}

	@Override
	public Rectangle2D getBounds() {
		// improve this part with opentype.js
		double width = fontRenderContext.measureTextWith(string, font);
		double height = font.getSize();
		return new Rectangle2DW(0, 0, width, height);
	}

	@Override
	public void draw(Graphics2DInterface graphics, int x, int y) {
		Graphics2DW g2d = (Graphics2DW) graphics;
		g2d.setFont(font);
		g2d.drawText(string, x, y);
	}

}
