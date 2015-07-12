/* FramedBox.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://forge.scilab.org/jlatexmath
 * 
 * Copyright (C) 2009 DENIZET Calixte
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

import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.BasicStroke;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;
import com.himamis.retex.renderer.share.platform.graphics.Stroke;

/**
 * A box representing a rotated box.
 */
public class ShadowBox extends FramedBox {

	private float shadowRule;

	private Rectangle2D rectangle;

	public ShadowBox(FramedBox fbox, float shadowRule) {
		super(fbox.box, fbox.thickness, fbox.space);
		this.shadowRule = shadowRule;
		depth += shadowRule;
		width += shadowRule;

		rectangle = geom.createRectangle2D(0, 0, 0, 0);
	}

	public void draw(Graphics2DInterface g2, float x, float y) {
		float th = thickness / 2;
		box.draw(g2, x + space + thickness, y);
		Stroke st = g2.getStroke();
		g2.setStroke(graphics.createBasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		rectangle.setRectangle(x + th, y - height + th, width - shadowRule - thickness, height + depth
				- shadowRule - thickness);
		g2.draw(rectangle);
		float penth = (float) Math.abs(1 / g2.getTransform().getScaleX());
		g2.setStroke(graphics.createBasicStroke(penth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		rectangle.setRectangle(x + shadowRule - penth, y + depth - shadowRule - penth, width - shadowRule,
				shadowRule);
		g2.fill(rectangle);
		rectangle.setRectangle(x + width - shadowRule - penth, y - height + th + shadowRule, shadowRule,
				depth + height - 2 * shadowRule - th);
		g2.fill(rectangle);
		// drawDebug(g2, x, y);
		g2.setStroke(st);
	}

	public int getLastFontId() {
		return box.getLastFontId();
	}
}
