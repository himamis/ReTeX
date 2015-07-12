package com.himamis.retex.renderer.web;

import com.google.gwt.core.client.EntryPoint;
import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.web.font.opentype.Opentype;

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
			library.@com.himamis.retex.renderer.web.JlmLib::initWith(Ljava/lang/String;)(str);
		});

		$wnd.jlmlib.SERIF = @com.himamis.retex.renderer.share.TeXFormula::SERIF;
		$wnd.jlmlib.SANSSERIF = @com.himamis.retex.renderer.share.TeXFormula::SANSSERIF;
		$wnd.jlmlib.BOLD = @com.himamis.retex.renderer.share.TeXFormula::BOLD;
		$wnd.jlmlib.ITALIC = @com.himamis.retex.renderer.share.TeXFormula::ITALIC;
		$wnd.jlmlib.ROMAN = @com.himamis.retex.renderer.share.TeXFormula::ROMAN;
		$wnd.jlmlib.TYPEWRITER = @com.himamis.retex.renderer.share.TeXFormula::TYPEWRITER;

		$wnd.jlmlib.drawLatex = $entry(function(opts) {
			//ctx, latex, size, style, x, y, fgColor, bgColor, cb
			if (!opts.context) {
				throw ("drawLatex(opts): opts.context must not be null");
			}
			if (!opts.latex) {
				throw ("drawLatex(opts): opts.latex must not be null");
			}
			var ctx = opts.context, 
			latex = opts.latex, 
			size = opts.size || 12, 
			type = opts.type || 0, 
			x = opts.x || 0, 
			y = opts.y || 0, 
			insets = opts.insets
					|| {
						top : 0,
						bottom : 0,
						left : 0,
						right : 0
					}, 
			topInset = insets.top || 0, 
			bottomInset = insets.bottom || 0, 
			leftInset = insets.left || 0, 
			rightInset = insets.right || 0, 
			fgColor = opts.foregroundColor || "#000000", 
			bgColor = opts.backgroundColor, // undefined === invisible
			cb = opts.callback;

			return library.@com.himamis.retex.renderer.web.JlmLib::drawLatex(Lcom/google/gwt/canvas/dom/client/Context2d;Ljava/lang/String;FIIIIIIILjava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(ctx, latex, size, type, x, y, topInset, leftInset, bottomInset, rightInset, fgColor, bgColor, cb);
		});
		
		$wnd.jlmlib.setFontBaseUrl = $entry(function(url) {
			opentype.@com.himamis.retex.renderer.web.font.opentype.Opentype::setFontBaseUrl(Ljava/lang/String;)(url);
		});
	}-*/;

}
