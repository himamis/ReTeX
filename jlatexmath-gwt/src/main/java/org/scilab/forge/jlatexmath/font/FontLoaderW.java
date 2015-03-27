package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;
import org.scilab.forge.jlatexmath.resources.css.CssResources;
import org.scilab.forge.jlatexmath.resources.js.JsResources;

import com.google.gwt.core.client.ScriptInjector;

public class FontLoaderW implements FontLoader {

	private boolean resourcesInjected = false;

	@Override
	public Font loadFont(Object fontInt, String name)
			throws ResourceParseException {
		ensureResourcesInjected();
		// keep reference to all the fonts loaded
		// WebFont - ensure that this class is listening to the onfontactive
		// events
		// WebFont - start loading of custom font-family
		// return object with font name

		// onfontactive event - set the fontactive boolean in font object to
		// true
		// TODO Auto-generated method stub
		FontW font = new FontW("serif", Font.PLAIN,
				Math.round(PIXELS_PER_POINT));
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
		CssResources.INSTANCE.fontFaceDeclarations().ensureInjected();
		ScriptInjector.fromString(
				JsResources.INSTANCE.webFontLoaderJS().getText()).inject();
	}
}
