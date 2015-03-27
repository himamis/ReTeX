package org.scilab.forge.jlatexmath.resources.css;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface CssResources extends ClientBundle {

	public static final CssResources INSTANCE = GWT.create(CssResources.class);

	@Source("font-face-declarations.css")
	public CssResource fontFaceDeclarations();

}
