package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.platform.FactoryProvider;

import com.google.gwt.core.client.EntryPoint;

public class CreateLibrary implements EntryPoint {

	private JlmLib library;

	@Override
	public void onModuleLoad() {
		FactoryProvider.INSTANCE = new FactoryProviderGWT();
		library = new JlmLib();
		exportLibrary(library);
	}

	private static native void exportLibrary(JlmLib library) /*-{
		$wnd.jlmlib = {};
		$wnd.jlmlib.initWith = $entry(function(str) {
			library.@org.scilab.forge.jlatexmath.JlmLib::initWith(Ljava/lang/String;)(str);
		});
		$wnd.jlmlib.drawLatex = $entry(function(ctx, latex, size, style, x, y,
				fgColor, cb) {
			library.@org.scilab.forge.jlatexmath.JlmLib::drawLatex(Lcom/google/gwt/canvas/dom/client/Context2d;Ljava/lang/String;FIIILjava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(ctx, latex, size, style, x, y, fgColor, cb);
		});
	}-*/;

}
