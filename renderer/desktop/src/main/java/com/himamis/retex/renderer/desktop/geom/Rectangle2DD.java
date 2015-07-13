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
package com.himamis.retex.renderer.desktop.geom;

import java.awt.geom.Rectangle2D;

public class Rectangle2DD extends Rectangle2D.Float implements com.himamis.retex.renderer.share.platform.geom.Rectangle2D {

	private static final long serialVersionUID = 1L;

	public Rectangle2DD(Rectangle2D rectangle) {
		setRect(rectangle);
	}
	
	public Rectangle2DD(double x, double y, double width, double height) {
		setRect(x, y, width, height);
	}
	
	public Object getNativeObject() {
		return this;
	}

	public void setRectangle(double x, double y, double width, double height) {
		setRect(x, y, width, height);
	}
}
