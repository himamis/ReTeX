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

package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Stroke;

/**
 * A box representing a rotated box.
 */
public class FramedBox extends Box {

	private static final GeomFactory GEOM_FACTORY = FactoryProvider.INSTANCE
			.getGeomFactory();
	private static final GraphicsFactory GRAPHICS_FACTORY = FactoryProvider.INSTANCE
			.getGraphicsFactory();

	protected Box box;
	protected float thickness;
	protected float space;
	private Color line;
	private Color bg;

	public FramedBox(Box box, float thickness, float space) {
		this.box = box;
		this.width = box.width + 2 * thickness + 2 * space;
		this.height = box.height + thickness + space;
		this.depth = box.depth + thickness + space;
		this.shift = box.shift;
		this.thickness = thickness;
		this.space = space;
	}

	public FramedBox(Box box, float thickness, float space, Color line, Color bg) {
		this(box, thickness, space);
		this.line = line;
		this.bg = bg;
	}

	public void draw(Graphics2DInterface g2, float x, float y) {
		Stroke st = g2.getStroke();
		g2.setStroke(GRAPHICS_FACTORY.createBasicStroke(thickness,
				BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f));
		float th = thickness / 2;
		if (bg != null) {
			Color prev = g2.getColor();
			g2.setColor(bg);
			g2.fill(GEOM_FACTORY.createRectangle2D(x + th, y - height + th,
					width - thickness, height + depth - thickness));
			g2.setColor(prev);
		}
		if (line != null) {
			Color prev = g2.getColor();
			g2.setColor(line);
			g2.draw(GEOM_FACTORY.createRectangle2D(x + th, y - height + th,
					width - thickness, height + depth - thickness));
			g2.setColor(prev);
		} else {
			g2.draw(GEOM_FACTORY.createRectangle2D(x + th, y - height + th,
					width - thickness, height + depth - thickness));
		}
		// drawDebug(g2, x, y);
		g2.setStroke(st);
		box.draw(g2, x + space + thickness, y);
	}

	public int getLastFontId() {
		return box.getLastFontId();
	}
}
