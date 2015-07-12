package com.himamis.retex.renderer.web.font.opentype;

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
	public void onFontLoaded(OpentypeFontWrapper font, String familyName);

	/**
	 * Called when the loading of the font fails.
	 * 
	 * @param error
	 */
	public void onFontError(Object error, String familyName);
}
