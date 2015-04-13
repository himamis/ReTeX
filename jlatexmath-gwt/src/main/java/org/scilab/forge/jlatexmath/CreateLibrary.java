package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.graphics.Graphics2DW;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.HasForegroundColor;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.CanvasElement;

public class CreateLibrary implements EntryPoint {

	private static final String LIB_NAME = "jlmlib";

	@Override
	public void onModuleLoad() {
		FactoryProvider.INSTANCE = new FactoryProviderGWT();
		exportLibrary();
	}

	private native void exportLibrary() /*-{
		$wnd.jlmlib = {};
		$wnd.jlmlib.drawLatex = function(ctx, latex, size, style, x, y,
				fgColor) {
			var color = @org.scilab.forge.jlatexmath.ColorUtil::decode(Ljava/lang/String;)(fgColor);
			@org.scilab.forge.jlatexmath.CreateLibrary::drawLatex(Lcom/google/gwt/canvas/dom/client/Context2d;Ljava/lang/String;FIIILorg/scilab/forge/jlatexmath/platform/graphics/Color;)(ctx, latex, size, style, x, y, color);
		}
	}-*/;

	public static TeXIcon createIcon(final String latex, final float size,
			final int style) {
		TeXFormula formula = new TeXFormula(latex);
		TeXIcon icon = formula.new TeXIconBuilder().setStyle(style)
				.setSize(size).build();

		// icon.setInsets(new Insets(5, 5, 5, 5));
		return icon;
	}

	public static void drawLatex(final Context2d ctx, final String latex,
			final float size, final int style, final int x, final int y,
			final Color fgColor) {
		TeXIcon icon = createIcon(latex, size, style);
		Graphics2DInterface g2 = new Graphics2DW(ctx);
		icon.paintIcon(new HasForegroundColor() {
			@Override
			public Color getForegroundColor() {
				return fgColor;
			}
		}, g2, x, y);
	}
}
