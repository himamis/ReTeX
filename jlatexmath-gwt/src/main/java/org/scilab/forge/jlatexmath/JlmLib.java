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
		initString.append(string);
	}

	public int[] drawLatex(final Context2d ctx, final String latex,
			final float size, final int style, final int x, final int y,
			final String fgColorString, final String bgColorString,
			final JavaScriptObject callback) {
		
		// init jlm with the given string
		if (initString.length() > 0) {
			new TeXFormula(initString.toString());
			initString.setLength(0);
		}
		
		// create icon and graphics objects
		TeXIcon icon = createIcon(latex, size, style);
		Graphics2DW g2 = new Graphics2DW(ctx);
		
		// fill the background color
		if (bgColorString != null && !bgColorString.equals("")) {
			final Color bgColor = ColorUtil.decode(bgColorString);
			g2.setColor(bgColor);
			g2.fillRect(x, y, x + icon.getIconWidth(), y + icon.getIconHeight());
		}
		
		// set the callback
		g2.setDrawingFinishedCallback(new DrawingFinishedCallback() {
			@Override
			public void onDrawingFinished() {
				callJavascriptCallback(callback);
			}
		});
		
		// paint the icon
		final Color fgColor = ColorUtil.decode(fgColorString);
		icon.paintIcon(new HasForegroundColor() {
			@Override
			public Color getForegroundColor() {
				return fgColor;
			}
		}, g2, x, y);
		
		// return {width, height}
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
