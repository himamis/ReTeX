package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

public class FontLoaderW implements FontLoader {

	@Override
	public Font loadFont(Object fontInt, String name) throws ResourceParseException {
		// ensure WebFont javascript is injected
		// ensure css with font-face declarations is inserted
		// keep reference to all the fonts loaded
		// WebFont - ensure that this class is listening to the onfontactive events
		// WebFont - start loading of custom font-family
		// return object with font name
		
		// onfontactive event - set the fontactive boolean in font object to true
		// TODO Auto-generated method stub
		return null;
	}

}
