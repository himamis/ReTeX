package org.scilab.forge.jlatexmath.font;

import java.util.HashMap;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.font.WebFontLoader.FontStatusListener;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

import com.google.gwt.core.client.GWT;

public class FontLoaderW implements FontLoader, FontStatusListener {

	private WebFontLoader webFontLoader;

	private HashMap<String, FontW> fonts;

	public FontLoaderW() {
		webFontLoader = new WebFontLoader();
		fonts = new HashMap<String, FontW>();
		webFontLoader.addFontStatusListener(this);
	}

	@Override
	public Font loadFont(Object fontInt, String name)
			throws ResourceParseException {
		FontW font = new FontW("serif", Font.PLAIN,
				Math.round(PIXELS_PER_POINT));
		fonts.put(name, font);

		webFontLoader.loadFont(name);
		return font;
	}

	@Override
	public void onFontLoading(String familyName, String fvd) {
		GWT.log("Font " + familyName + " is loading.");
	}

	@Override
	public void onFontActive(String familyName, String fvd) {
		GWT.log("Font " + familyName + " is active.");
		fonts.get(familyName).setLoaded(true);
	}

	@Override
	public void onFontInactive(String familyName, String fvd) {
		GWT.log("Font " + familyName + " is inactive.");
	}

}
