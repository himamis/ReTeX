package org.scilab.forge.jlatexmath.font;

import java.util.ArrayList;
import java.util.List;

import org.scilab.forge.jlatexmath.resources.css.CssResources;
import org.scilab.forge.jlatexmath.resources.js.JsResources;

import com.google.gwt.core.client.ScriptInjector;

public class WebFontLoader {

	private boolean resourcesInjected = false;

	/*
	 * Interface class for the typekit/webfontloader library.
	 * https://github.com/typekit/webfontloader
	 * https://developers.google.com/fonts/docs/webfont_loader
	 */

	public interface FontStatusListener {

		/*
		 * Interface definition description copied shamelessly from
		 * https://github.com/typekit/webfontloader#events.
		 */
		/**
		 * This event is triggered once for each font that's loaded.
		 * 
		 * @param familyName
		 *            font family name
		 * @param fvd
		 *            font variation description
		 */
		public void onFontLoading(String familyName, String fvd);

		/**
		 * This event is triggered once for each font that renders.
		 * 
		 * @param familyName
		 *            font family name
		 * @param fvd
		 *            font variation description
		 */
		public void onFontActive(String familyName, String fvd);

		/**
		 * This event is triggered if the font can't be loaded.
		 * 
		 * @param familyName
		 *            font family name
		 * @param fvd
		 *            font variation description
		 */
		public void onFontInactive(String familyName, String fvd);
	}

	private List<FontStatusListener> fontStatusListeners;

	public WebFontLoader() {
		ensureResourcesInjected();
		fontStatusListeners = new ArrayList<WebFontLoader.FontStatusListener>();
	}

	private void ensureResourcesInjected() {
		if (!resourcesInjected) {
			injectResources();
			resourcesInjected = true;
		}
	}

	private void injectResources() {
		CssResources.INSTANCE.fontFaceDeclarations().ensureInjected();
		ScriptInjector.fromString(
				JsResources.INSTANCE.webFontLoaderJS().getText()).inject();
	}

	private void fireFontLoadingEvent(String familyName, String fvd) {
		for (FontStatusListener listener : fontStatusListeners) {
			listener.onFontLoading(familyName, fvd);
		}
	}

	private void fireFontActiveEvent(String familyName, String fvd) {
		for (FontStatusListener listener : fontStatusListeners) {
			listener.onFontActive(familyName, fvd);
		}
	}

	private void fireFontInactiveEvent(String familyName, String fvd) {
		for (FontStatusListener listener : fontStatusListeners) {
			listener.onFontInactive(familyName, fvd);
		}
	}

	public void addFontStatusListener(FontStatusListener listener) {
		fontStatusListeners.add(listener);
	}

	public void removeFontStatusListener(FontStatusListener listener) {
		fontStatusListeners.remove(fontStatusListeners);
	}

	/**
	 * Loads the specified font asynchronously. Font status changes are fired to
	 * the registered listeners.
	 * 
	 * @param familyName
	 *            font family name
	 */
	public void loadFont(String familyName) {
		String extracedFilename = extractFileName(familyName);
		String sanitizedName = extracedFilename.replace('_', '-');
		loadFontNative(sanitizedName);
	}

	private String extractFileName(String filePathName) {
		if (filePathName == null)
			return null;

		int dotPos = filePathName.lastIndexOf('.');
		int slashPos = filePathName.lastIndexOf('\\');
		if (slashPos == -1)
			slashPos = filePathName.lastIndexOf('/');

		if (dotPos > slashPos) {
			return filePathName.substring(slashPos > 0 ? slashPos + 1 : 0,
					dotPos);
		}

		return filePathName.substring(slashPos > 0 ? slashPos + 1 : 0);
	}

	private native void loadFontNative(String familyName)/*-{
		var that = this;
		WebFont
				.load({
					custom : {
						families : [ familyName ]
					},
					loading : function() {
					},
					active : function() {
					},
					inactive : function() {
					},
					fontloading : function(name, fvd) {
						that.@org.scilab.forge.jlatexmath.font.WebFontLoader::fireFontLoadingEvent(Ljava/lang/String;Ljava/lang/String;)(name, fvd);
					},
					fontactive : function(name, fvd) {
						that.@org.scilab.forge.jlatexmath.font.WebFontLoader::fireFontActiveEvent(Ljava/lang/String;Ljava/lang/String;)(name, fvd);
					},
					fontinactive : function(name, fvd) {
						that.@org.scilab.forge.jlatexmath.font.WebFontLoader::fireFontInactiveEvent(Ljava/lang/String;Ljava/lang/String;)(name, fvd);
					}
				});
	}-*/;

}
