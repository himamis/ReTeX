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
package com.himamis.retex.renderer.web.font;

import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.font.FontLoader;
import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.share.platform.font.TextAttributeProvider;
import com.himamis.retex.renderer.share.platform.font.TextLayout;
import com.himamis.retex.renderer.web.font.opentype.Opentype;

public class FontFactoryGWT extends FontFactory {
	
	private FontLoaderWrapper fontLoaderWrapper = Opentype.INSTANCE;

	@Override
	public Font createFont(String name, int style, int size) {
		return new DefaultFont(name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font, FontRenderContext fontRenderContext) {
		return new TextLayoutW(string, font, fontRenderContext);
	}

	@Override
	public TextAttributeProvider createTextAttributeProvider() {
		return new TextAttributeProviderW();
	}

	@Override
	public FontLoader createFontLoader() {
		return new FontLoaderW(fontLoaderWrapper);
	}

}
