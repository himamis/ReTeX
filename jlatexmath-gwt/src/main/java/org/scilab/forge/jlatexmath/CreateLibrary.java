package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.font.opentype.Opentype;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;

import com.google.gwt.core.client.EntryPoint;

public class CreateLibrary implements EntryPoint {

	private JlmLib library;
	private Opentype opentype;

	@Override
	public void onModuleLoad() {
		FactoryProvider.INSTANCE = new FactoryProviderGWT();
		library = new JlmLib();
		opentype = Opentype.INSTANCE;
		exportLibrary(library, opentype);
	}

	private static native void exportLibrary(JlmLib library, Opentype opentype) /*-{
		$wnd.jlmlib = {};
		$wnd.jlmlib.initWith = $entry(function(str) {
			library.@org.scilab.forge.jlatexmath.JlmLib::initWith(Ljava/lang/String;)(str);
		});
		$wnd.jlmlib.drawLatex = $entry(function(ctx, latex, size, style, x, y,
				fgColor, bgColor, cb) {
			return library.@org.scilab.forge.jlatexmath.JlmLib::drawLatex(Lcom/google/gwt/canvas/dom/client/Context2d;Ljava/lang/String;FIIILjava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(ctx, latex, size, style, x, y, fgColor, bgColor, cb);
		});
		$wnd.jlmlib.setFontBaseUrl = $entry(function(url) {
			opentype.@org.scilab.forge.jlatexmath.font.opentype.Opentype::setFontBaseUrl(Ljava/lang/String;)(url);
		});
	}-*/;

}
