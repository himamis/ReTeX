package org.scilab.forge.jlatexmath.font.opentype;

import java.util.ArrayList;
import java.util.List;

import org.scilab.forge.jlatexmath.resources.js.JsResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

public class Opentype {

	public static final Opentype INSTANCE = new Opentype();

	private Opentype() {
		ScriptInjector.fromString(JsResources.INSTANCE.opentypeJs().getText())
				.setRemoveTag(false).inject();
	}

	private List<OpentypeFontStatusListener> listeners = new ArrayList<OpentypeFontStatusListener>();

	public void addListener(OpentypeFontStatusListener listener) {
		listeners.add(listener);
	}

	private void fireFontActiveEvent(JavaScriptObject font, String familyName) {
		for (OpentypeFontStatusListener listener : listeners) {
			listener.onFontLoaded(font, familyName);
		}
	}

	private void fireFontInactiveEvent(JavaScriptObject error, String familyName) {
		for (OpentypeFontStatusListener listener : listeners) {
			listener.onFontError(error, familyName);
		}
	}

	public void loadFont(String path, String familyName) {
		nativeLoadFont(GWT.getModuleBaseURL() + path, familyName);
	}

	private native void nativeLoadFont(String path, String familyName) /*-{
		var that = this;
		opentype
				.load(
						path,
						function(err, font) {
							if (err) {
								that.@org.scilab.forge.jlatexmath.font.opentype.Opentype::fireFontInactiveEvent(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(err, familyName);
							} else {
								that.@org.scilab.forge.jlatexmath.font.opentype.Opentype::fireFontActiveEvent(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(font, font.familyName);
							}
						});
	}-*/;
}
