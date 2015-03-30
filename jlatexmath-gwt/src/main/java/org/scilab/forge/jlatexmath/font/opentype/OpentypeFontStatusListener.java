package org.scilab.forge.jlatexmath.font.opentype;

import com.google.gwt.core.client.JavaScriptObject;

public interface OpentypeFontStatusListener {

	/**
	 * Called when the font is successfully loaded. Returns a Font object and
	 * the family name of the font.
	 * 
	 * @param font
	 *            Font object
	 * @param familyName
	 *            name of the font
	 */
	public void onFontLoaded(JavaScriptObject font, String familyName);

	/**
	 * Called when the loading of the font fails.
	 * 
	 * @param error
	 */
	public void onFontError(JavaScriptObject error, String familyName);
}
