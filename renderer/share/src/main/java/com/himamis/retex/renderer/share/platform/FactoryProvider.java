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

import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;

public abstract class FactoryProvider {
	
	public static FactoryProvider INSTANCE;
	
	private GeomFactory geomFactory;
	private FontFactory fontFactory;
	private GraphicsFactory graphicsFactory;
	private ParserFactory parserFactory;
	private ResourceLoaderFactory resourceLoaderFactory;
	
	protected abstract GeomFactory createGeomFactory();
	
	protected abstract FontFactory createFontFactory();
	
	protected abstract GraphicsFactory createGraphicsFactory();
	
	protected abstract ParserFactory createParserFactory();
	
	protected abstract ResourceLoaderFactory createResourceLoaderFactory();
	
	protected FactoryProvider() { }

	public GeomFactory getGeomFactory() {
		if (geomFactory == null) {
			geomFactory = createGeomFactory();
		}
		return geomFactory;
	}

	public FontFactory getFontFactory() {
		if (fontFactory == null) {
			fontFactory = createFontFactory();
		}
		return fontFactory;
	}

	public GraphicsFactory getGraphicsFactory() {
		if (graphicsFactory == null) {
			graphicsFactory = createGraphicsFactory();
		}
		return graphicsFactory;
	}
	
	public ParserFactory getParserFactory() {
		if (parserFactory == null) {
			parserFactory = createParserFactory();
		}
		return parserFactory;
	}

	public ResourceLoaderFactory getResourceLoaderFactory() {
		if (resourceLoaderFactory == null) {
			resourceLoaderFactory = createResourceLoaderFactory();
		}
		return resourceLoaderFactory;
	}
}
