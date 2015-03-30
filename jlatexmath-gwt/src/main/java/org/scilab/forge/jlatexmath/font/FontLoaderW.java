package org.scilab.forge.jlatexmath.font;

import java.util.HashMap;

import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.font.opentype.FontStatusListener;
import org.scilab.forge.jlatexmath.font.opentype.Opentype;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

public class FontLoaderW implements FontLoader {

	private Opentype webFontLoader;
	private FontStatusListener listener;

	private static final HashMap<String, FontW> fonts = new HashMap<String, FontW>();

	public FontLoaderW() {
		webFontLoader = Opentype.INSTANCE;
		listener = FontStatusListener.INSTANCE;
	}

	@Override
	public Font loadFont(Object fontInt, String name)
			throws ResourceParseException {
		String fontName = extractFileName(name);
		String pathName = getPrefix(fontInt) + name;
		FontW font = null;
		if ((font = fonts.get(pathName)) == null) {
			font = new FontW(fontName, Font.PLAIN, Math.round(PIXELS_PER_POINT));
			listener.addFont(fontName, font);
			fonts.put(pathName, font);
			webFontLoader.loadFont(pathName, fontName);
		}
		return font;
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

	private String getPrefix(Object fontInt) {
		String prefix = "";
		if (CyrillicRegistration.class.equals(fontInt)) {
			prefix = "cyrillic/";
		} else if (GreekRegistration.class.equals(fontInt)) {
			prefix = "greek/";
		}
		return "font/" + prefix;
	}
}
