package org.scilab.forge.jlatexmath.font.opentype;

import java.util.HashMap;

import org.scilab.forge.jlatexmath.font.FontW;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

public class FontStatusListener implements OpentypeFontStatusListener {

	public static final FontStatusListener INSTANCE = new FontStatusListener();

	static {
		Opentype.INSTANCE.addListener(INSTANCE);
	}

	private HashMap<String, FontW> fonts;

	private FontStatusListener() {
		fonts = new HashMap<String, FontW>();
	}

	public void addFont(String familyName, FontW font) {
		fonts.put(familyName, font);
	}

	@Override
	public void onFontLoaded(JavaScriptObject font, String familyName) {
		GWT.log("Font " + familyName + " is active.") ;
		FontW fontW = fonts.get(familyName);
		OpentypeFont otFont = new OpentypeFont(font);
		fontW.setImplementation(otFont);
		fonts.remove(familyName);
		fontW.fireFontLoadedEvent();
	}

	@Override
	public void onFontError(JavaScriptObject error, String familyName) {
		GWT.log("Font " + familyName + " is inactive.");
		GWT.log("Reason: " + error);
		fonts.remove(familyName);
		throw new IllegalStateException("Font " + familyName + " could not be loaded. Reason " + error);
	}

}
