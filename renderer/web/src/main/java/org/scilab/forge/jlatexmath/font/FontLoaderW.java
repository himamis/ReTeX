package org.scilab.forge.jlatexmath.font;

import com.himamis.retex.renderer.share.cyrillic.CyrillicRegistration;
import com.himamis.retex.renderer.share.exception.ResourceParseException;
import com.himamis.retex.renderer.share.greek.GreekRegistration;
import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontLoader;

public class FontLoaderW implements FontLoader {

	private FontLoaderWrapper fontLoaderWrapper;

	public FontLoaderW(FontLoaderWrapper fontLoaderWrapper) {
		this.fontLoaderWrapper = fontLoaderWrapper;
	}

	@Override
	public Font loadFont(Object fontInt, String name)
			throws ResourceParseException {
		String fontName = extractFileName(name);
		String pathName = getPrefix(fontInt) + name;
		AsyncLoadedFont font = fontLoaderWrapper.createNativeFont(pathName,
				fontName, Font.PLAIN, Math.round(PIXELS_PER_POINT));
		return font;
	}

	private String extractFileName(String filePathName) {
		if (filePathName == null)
			return null;

		int dotPos = filePathName.lastIndexOf('.');
		int slashPos = filePathName.lastIndexOf('\\');
		if (slashPos == -1) {
			slashPos = filePathName.lastIndexOf('/');
		}
		slashPos = slashPos > -1 ? slashPos : 0;
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
