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
package com.himamis.retex.renderer.share.platform;

import com.himamis.retex.renderer.share.platform.graphics.BasicStroke;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.graphics.Image;
import com.himamis.retex.renderer.share.platform.graphics.Transform;

public class Graphics {

	private final GraphicsFactory graphicsFactory;

	public Graphics() {
		graphicsFactory = FactoryProvider.INSTANCE.getGraphicsFactory();
	}

	public Color createColor(int r, int g, int b) {
		return graphicsFactory.createColor(r, g, b);
	}

	public Color createColor(float r, float g, float b) {
		int red = Math.round(r * 255);
		int green = Math.round(g * 255);
		int blue = Math.round(b * 255);
		return createColor(red, green, blue);
	}

	public BasicStroke createBasicStroke(float width, int cap, int join, float miterLimit) {
		return graphicsFactory.createBasicStroke(width, cap, join, miterLimit);
	}

	public BasicStroke createBasicStroke(float width, int cap, int join) {
		return createBasicStroke(width, cap, join, 10.0f);
	}

	public Image createImage(int width, int height, int type) {
		return graphicsFactory.createImage(width, height, type);
	}

	public Image createImage(int width, int height) {
		return createImage(width, height, Image.TYPE_INT_RGB);
	}

	public Transform createTransform() {
		return graphicsFactory.createTransform();
	}

	public Image loadImage(String path) {
		return graphicsFactory.getImage(path);
	}
}
