package org.scilab.forge.jlatexmath.font;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

public interface WebFontResources extends ClientBundle {

	@Source("font-face-declarations.css")
	public CssResource fontFaceDeclarations();

	@Source("web-font-loader.js")
	public TextResource webFontLoaderJS();
}
