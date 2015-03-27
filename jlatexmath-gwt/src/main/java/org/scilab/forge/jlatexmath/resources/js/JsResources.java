package org.scilab.forge.jlatexmath.resources.js;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface JsResources extends ClientBundle {

	public static final JsResources INSTANCE = GWT.create(JsResources.class);

	@Source("web-font-loader.js")
	public TextResource webFontLoaderJS();

}
