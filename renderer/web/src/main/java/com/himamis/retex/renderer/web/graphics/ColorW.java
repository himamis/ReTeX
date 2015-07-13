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
package com.himamis.retex.renderer.web.graphics;

import com.google.gwt.canvas.dom.client.CssColor;
import com.himamis.retex.renderer.share.platform.graphics.Color;

public class ColorW implements Color {

	private CssColor cssColor;

	public ColorW(int r, int g, int b) {
		cssColor = CssColor.make(r, g, b);
	}

	public ColorW(String cssColorString) {
		cssColor = CssColor.make(cssColorString);
	}

	public ColorW(CssColor cssColor) {
		this.cssColor = cssColor;
	}

	public CssColor getCssColor() {
		return cssColor;
	}

	@Override
	@Deprecated
	public int getColor() {
		return 0; // unused
	}

}
