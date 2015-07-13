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
package com.himamis.retex.renderer.desktop.font;

import com.himamis.retex.renderer.desktop.geom.Rectangle2DD;
import com.himamis.retex.renderer.desktop.graphics.Graphics2DD;
import com.himamis.retex.renderer.share.platform.font.TextLayout;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;

public class TextLayoutD implements TextLayout {
	
	private java.awt.font.TextLayout layout;
	
	public TextLayoutD(String string, java.awt.Font font,
			java.awt.font.FontRenderContext fontRenderContext) {
		layout = new java.awt.font.TextLayout(string, font, fontRenderContext);
	}

	public Rectangle2D getBounds() {
		return new Rectangle2DD(layout.getBounds());
	}

	public void draw(Graphics2DInterface graphics, int x, int y) {
		Graphics2DD g2 = (Graphics2DD) graphics;
		layout.draw(g2.getImpl(), x, y);
		
	}

}
