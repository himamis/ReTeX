/* OvalBox.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://forge.scilab.org/jlatexmath
 * 
 * Copyright (C) 2011 DENIZET Calixte
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
 * 
 */

package com.himamis.retex.renderer.share;

import com.himamis.retex.renderer.share.platform.geom.RoundRectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.BasicStroke;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;
import com.himamis.retex.renderer.share.platform.graphics.Stroke;

/**
 * A box representing a rotated box.
 */
public class OvalBox extends FramedBox {

	private RoundRectangle2D roundRectangle;

	public OvalBox(FramedBox fbox) {
		super(fbox.box, fbox.thickness, fbox.space);

		roundRectangle = geom.createRoundRectangle2D(0, 0, 0, 0, 0, 0);
	}

	public void draw(Graphics2DInterface g2, float x, float y) {
		box.draw(g2, x + space + thickness, y);
		Stroke st = g2.getStroke();
		g2.setStroke(graphics.createBasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		float th = thickness / 2;
		float r = 0.5f * Math.min(width - thickness, height + depth - thickness);
		roundRectangle.setRoundRectangle(x + th, y - height + th, width - thickness, height + depth
				- thickness, r, r);
		g2.draw(roundRectangle);
		// drawDebug(g2, x, y);
		g2.setStroke(st);
	}

	public int getLastFontId() {
		return box.getLastFontId();
	}
}
