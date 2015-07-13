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
package com.himamis.retex.renderer.share;

import java.util.HashMap;
import java.util.Map;

import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;

public abstract class ColorUtil {

	private static final GraphicsFactory GRAPHICS_FACTORY = FactoryProvider.INSTANCE.getGraphicsFactory();

	public static final Color RED = GRAPHICS_FACTORY.createColor(255, 0, 0);
	public static final Color BLACK = GRAPHICS_FACTORY.createColor(0, 0, 0);
	public static final Color WHITE = GRAPHICS_FACTORY.createColor(255, 255, 255);
	public static final Color BLUE = GRAPHICS_FACTORY.createColor(0, 0, 255);
	public static final Color GREEN = GRAPHICS_FACTORY.createColor(0, 255, 0);
	public static final Color CYAN = GRAPHICS_FACTORY.createColor(0, 255, 255);
	public static final Color MAGENTA = GRAPHICS_FACTORY.createColor(255, 0, 255);
	public static final Color YELLOW = GRAPHICS_FACTORY.createColor(255, 255, 0);
	
	public static final Map<String, Color> COLOR_CONSTANTS = new HashMap<String, Color>();
	
	static {
		COLOR_CONSTANTS.put("RED", RED);
		COLOR_CONSTANTS.put("BLACK", BLACK);
		COLOR_CONSTANTS.put("WHITE", WHITE);
		COLOR_CONSTANTS.put("BLUE", BLUE);
		COLOR_CONSTANTS.put("GREEN", GREEN);
		COLOR_CONSTANTS.put("CYAN", CYAN);
		COLOR_CONSTANTS.put("MAGENTA", MAGENTA);
		COLOR_CONSTANTS.put("YELLOW", YELLOW);
	}

	public static Color decode(String string) throws NumberFormatException {
		Integer intval = Integer.decode(string);
		int i = intval.intValue();
		return GRAPHICS_FACTORY.createColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
	}

	public static StringBuilder sb = new StringBuilder("#");

	public static String encode(Color color) {
		int colorInt = color.getColor();
		int r = (colorInt & 0xFF000000) >> 24;
		int g = (colorInt & 0x00FF0000) >> 16;
		int b = (colorInt & 0x0000FF00) >> 8;
		sb.setLength(1);
		sb.append('#').append(pad(Integer.toHexString(r))).append(pad(Integer.toHexString(g)))
				.append(pad(Integer.toHexString(b)));
		return sb.toString();
	}

	private static String pad(String hex) {
		if (hex.length() == 0) {
			return "00";
		} else if (hex.length() == 1) {
			return "0" + hex;
		}
		return hex;
	}

}
