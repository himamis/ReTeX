package com.himamis.retex.renderer.web.font;

import com.himamis.retex.renderer.share.platform.font.Font;

public interface AsyncLoadedFont extends Font {

	public static interface FontLoadCallback {
		void onFontLoaded(AsyncLoadedFont font);

		void onFontError(AsyncLoadedFont font);
	}

	/**
	 * @return true if the font is loaded
	 */
	boolean isLoaded();

	/**
	 * Callback to be used when the font is loaded.
	 * 
	 * @param callback
	 */
	void addFontLoadedCallback(FontLoadCallback callback);

	/**
	 * @return a non-null, valid FontWrapper only if the isLoaded method returns
	 *         true, or inside the onFontLoaded method in FontLoadCallback
	 *         interface
	 */
	FontWrapper getFontWrapper();
}
