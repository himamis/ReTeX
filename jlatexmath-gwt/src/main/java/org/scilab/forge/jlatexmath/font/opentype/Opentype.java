package org.scilab.forge.jlatexmath.font.opentype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scilab.forge.jlatexmath.font.FontLoaderWrapper;
import org.scilab.forge.jlatexmath.font.FontW;
import org.scilab.forge.jlatexmath.resources.js.JsResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

public class Opentype implements FontLoaderWrapper {

	public static final Opentype INSTANCE = new Opentype();

	private static class FontContainer {
		public OpentypeFontWrapper font;
		public boolean fontIsLoading;

		public FontContainer(OpentypeFontWrapper font) {
			this.font = font;
			this.fontIsLoading = true;
		}
	}

	private List<OpentypeFontStatusListener> listeners;
	private Map<String, FontContainer> fonts;
	private String fontBaseUrl = GWT.getModuleBaseURL();

	private Opentype() {
		ScriptInjector.fromString(JsResources.INSTANCE.opentypeJs().getText())
				.setRemoveTag(false).inject();
		listeners = new ArrayList<OpentypeFontStatusListener>();
		fonts = new HashMap<String, FontContainer>();
	}

	public void addListener(OpentypeFontStatusListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeListener(OpentypeFontStatusListener listener) {
		listeners.remove(listener);
	}

	private void fireFontActiveEvent(String familyName) {
		OpentypeFontWrapper fontWrapper = fonts.get(familyName).font;
		for (OpentypeFontStatusListener listener : listeners) {
			listener.onFontLoaded(fontWrapper, familyName);
		}
	}

	private void fireFontInactiveEvent(JavaScriptObject error, String familyName) {
		for (OpentypeFontStatusListener listener : listeners) {
			listener.onFontError(error, familyName);
		}
	}

	private boolean fontEntryExists(String familyName) {
		return fonts.get(familyName) != null;
	}

	private void createFontEntry(String familyName) {
		FontContainer fontContainer = new FontContainer(null);
		fonts.put(familyName, fontContainer);
	}

	boolean fontIsLoading(String familyName) {
		FontContainer fontContainer = fonts.get(familyName);
		return fontContainer != null && fontContainer.fontIsLoading;
	}

	boolean fontIsLoaded(String familyName) {
		FontContainer fontContainer = fonts.get(familyName);
		return fontContainer != null && !fontContainer.fontIsLoading;
	}

	OpentypeFontWrapper getFont(String familyName) {
		return fonts.get(familyName).font;
	}

	private void setFontIsLoaded(String familyName, JavaScriptObject font) {
		FontContainer fontContainer = fonts.get(familyName);
		fontContainer.font = new OpentypeFontWrapper(font);
		fontContainer.fontIsLoading = false;
	}

	private void loadFont(String path, String familyName) {
		// font does not exist
		if (!fontEntryExists(familyName)) {
			createFontEntry(familyName);
			nativeLoadFont(fontBaseUrl + path, familyName);
		} else if (fontIsLoading(familyName)) {
			// do nothing, wait for the font to be loaded
		} else if (fontIsLoaded(familyName)) {
			fireFontActiveEvent(familyName);
		}
	}

	private native void nativeLoadFont(String path, String familyName) /*-{
		var that = this;
		opentype
				.load(
						path,
						function(err, font) {
							if (err) {
								that.@org.scilab.forge.jlatexmath.font.opentype.Opentype::fireFontInactiveEvent(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(err, familyName);
							} else {
								that.@org.scilab.forge.jlatexmath.font.opentype.Opentype::setFontIsLoaded(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(font.familyName, font);
								that.@org.scilab.forge.jlatexmath.font.opentype.Opentype::fireFontActiveEvent(Ljava/lang/String;)(font.familyName);
							}
						});
	}-*/;

	@Override
	public FontW createNativeFont(String pathName, String fontName, int style,
			int size) {
		loadFont(pathName, fontName);
		return new OpentypeFont(fontName, style, size);
	}

	/**
	 * Sets the base URL from where the fonts are loaded.
	 * 
	 * @param url
	 *            base URL
	 */
	public void setFontBaseUrl(String url) {
		fontBaseUrl = url;
	}
}
