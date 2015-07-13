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
package com.himamis.retex.renderer.web.font.opentype;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.web.font.FontW;
import com.himamis.retex.renderer.web.font.FontWrapper;

public class OpentypeFont extends FontW implements OpentypeFontStatusListener {

	private Opentype opentype = Opentype.INSTANCE;
	private List<FontLoadCallback> fontLoadCallbacks;

	public OpentypeFont(String name, int style, int size) {
		super(name, style, size);
		fontLoadCallbacks = new ArrayList<FontLoadCallback>();
	}

	@Override
	public Font deriveFont(int type) {
		return new OpentypeFont(name, type, size);
	}

	@Override
	public boolean isLoaded() {
		return opentype.fontIsLoaded(name);
	}

	@Override
	public void addFontLoadedCallback(FontLoadCallback callback) {
		if (opentype.fontIsLoaded(name)) {
			callback.onFontLoaded(this);
		} else {
			fontLoadCallbacks.add(callback);
			opentype.addListener(this);
		}
	}

	@Override
	public FontWrapper getFontWrapper() {
		return opentype.getFont(name);
	}

	@Override
	public void onFontLoaded(OpentypeFontWrapper font, String familyName) {
		if (!familyName.equals(name)) {
			// not interested
			return;
		}
		GWT.log("Font " + name + " loaded");
		opentype.removeListener(this);
		for (FontLoadCallback fontLoadCallback : fontLoadCallbacks) {
			fontLoadCallback.onFontLoaded(this);
		}
		fontLoadCallbacks.clear();
		fontLoadCallbacks = null;
	}

	@Override
	public void onFontError(Object error, String familyName) {
		if (!familyName.equals(name)) {
			// not interested
			return;
		}
		GWT.log("Font " + name + " error");
		GWT.log(error.toString());
		opentype.removeListener(this);
		for (FontLoadCallback fontLoadCallback : fontLoadCallbacks) {
			fontLoadCallback.onFontError(this);
		}
		fontLoadCallbacks.clear();
		fontLoadCallbacks = null;
	}

}
