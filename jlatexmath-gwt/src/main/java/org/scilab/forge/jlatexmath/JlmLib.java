package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.graphics.Graphics2DW;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.HasForegroundColor;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public class JlmLib {

	private StringBuilder initString;

	public JlmLib() {
		initString = new StringBuilder();
	}

	public void initWith(String string) {
		initString.append(initString);
	}

	public int[] drawLatex(final Context2d ctx, final String latex,
			final float size, final int style, final int x, final int y,
			final String fgColorString, final JavaScriptObject callback) {
		if (initString.length() > 0) {
			new TeXFormula(initString.toString());
			initString.setLength(0);
		}
		TeXIcon icon = createIcon(latex, size, style);
		Graphics2DW g2 = new Graphics2DW(ctx);
		g2.setDrawingFinishedCallback(new DrawingFinishedCallback() {
			@Override
			public void onDrawingFinished() {
				callJavascriptCallback(callback);
			}
		});
		final Color fgColor = ColorUtil.decode(fgColorString);
		icon.paintIcon(new HasForegroundColor() {
			@Override
			public Color getForegroundColor() {
				return fgColor;
			}
		}, g2, x, y);
		return new int[] { icon.getIconWidth(), icon.getIconHeight() };
	}

	private static native void callJavascriptCallback(JavaScriptObject cb) /*-{
		if (cb != null) {
			cb();
		}
	}-*/;

	private static TeXIcon createIcon(final String latex, final float size,
			final int style) {
		TeXFormula formula = new TeXFormula(latex);
		TeXIcon icon = formula.new TeXIconBuilder().setStyle(style)
				.setSize(size).build();
		return icon;
	}

}
