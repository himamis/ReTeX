package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;

public class FontLoaderW implements FontLoader {

	private static final WebFontResources FONT_DECLARATIONS = GWT
			.create(WebFontResources.class);
	private boolean resourcesInjected = false;

	@Override
	public Font loadFont(Object fontInt, String name) throws ResourceParseException {
		ensureResourcesInjected();
		// keep reference to all the fonts loaded
		// WebFont - ensure that this class is listening to the onfontactive events
		// WebFont - start loading of custom font-family
		// return object with font name
		
		// onfontactive event - set the fontactive boolean in font object to true
		// TODO Auto-generated method stub
		FontW font = new FontW("serif", Font.PLAIN, Math.round(PIXELS_PER_POINT));
		font.setLoaded(true);
		return font;
	}

	private void ensureResourcesInjected() {
		if (!resourcesInjected) {
			injectResources();
			resourcesInjected = true;
		}
	}

	private void injectResources() {
		FONT_DECLARATIONS.fontFaceDeclarations().ensureInjected();
		ScriptInjector
				.fromString(FONT_DECLARATIONS.webFontLoaderJS().getText())
				.inject();
	}
}
