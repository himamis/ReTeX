package com.himamis.retex.renderer.web.resources.js;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface JsResources extends ClientBundle {

	public static final JsResources INSTANCE = GWT.create(JsResources.class);

	@Source("opentype.min.js")
	public TextResource opentypeJs();
	
	@Source("base64.min.js")
	public TextResource base64Js();

}
