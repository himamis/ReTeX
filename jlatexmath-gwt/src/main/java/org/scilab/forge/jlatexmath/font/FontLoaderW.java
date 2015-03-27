package org.scilab.forge.jlatexmath.font;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.font.WebFontLoader.FontStatusListener;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

public class FontLoaderW implements FontLoader, FontStatusListener {

	private static final Logger logger = Logger.getLogger("FontLoader");

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
		logger.log(Level.INFO, "Font " + familyName + " is loading.");
	}

	@Override
	public void onFontActive(String familyName, String fvd) {
		logger.log(Level.INFO, "Font " + familyName + " is active.");
	}

	@Override
	public void onFontInactive(String familyName, String fvd) {
		logger.log(Level.SEVERE, "Font " + familyName + " is inactive.");
	}

}
