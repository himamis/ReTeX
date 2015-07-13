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
package com.himamis.retex.renderer.web;

import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;
import com.himamis.retex.renderer.web.font.FontFactoryGWT;
import com.himamis.retex.renderer.web.geom.GeomFactoryGWT;
import com.himamis.retex.renderer.web.graphics.GraphicsFactoryGWT;
import com.himamis.retex.renderer.web.parser.ParserFactoryGWT;
import com.himamis.retex.renderer.web.resources.ResourceLoaderFactoryGWT;

public class FactoryProviderGWT extends FactoryProvider {

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryGWT();
	}

	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryGWT();
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryGWT();
	}

	@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryGWT();
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryGWT();
	}

}
