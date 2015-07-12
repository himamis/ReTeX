package com.himamis.retex.renderer.web;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.himamis.retex.renderer.share.ColorUtil;
import com.himamis.retex.renderer.share.TeXConstants;
import com.himamis.retex.renderer.share.TeXFormula;
import com.himamis.retex.renderer.share.TeXIcon;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.HasForegroundColor;
import com.himamis.retex.renderer.share.platform.graphics.Insets;
import com.himamis.retex.renderer.web.graphics.Graphics2DW;

public class JlmLib {

	private StringBuilder initString;

	public JlmLib() {
		initString = new StringBuilder();
	}

	public void initWith(String string) {
		initString.append(string);
	}

	public JavaScriptObject drawLatex(final Context2d ctx, final String latex,
			final float size, final int type, final int x, final int y,
			final int topInset, final int leftInset, final int bottomInset,
			final int rightInset, final String fgColorString,
			final String bgColorString, final JavaScriptObject callback) {

		// init jlm with the given string
		if (initString.length() > 0) {
			new TeXFormula(initString.toString());
			initString.setLength(0);
		}
		// create icon and graphics objects
		TeXIcon icon = createIcon(latex, size, type, new Insets(topInset, leftInset, bottomInset, rightInset));
		Graphics2DW g2 = new Graphics2DW(ctx);

		// fill the background color
		if (bgColorString != null && !bgColorString.equals("")) {
			final Color bgColor = ColorUtil.decode(bgColorString);
			g2.setColor(bgColor);
			g2.fillRect(x, y, icon.getIconWidth(), icon.getIconHeight());
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
		g2.maybeNotifyDrawingFinishedCallback();

		// return {width, height}
		return createReturnValue(icon);
	}

	private static native void callJavascriptCallback(JavaScriptObject cb) /*-{
		if (cb != null) {
			cb();
		}
	}-*/;

	private static TeXIcon createIcon(final String latex, final float size,
			final int type, Insets insets) {
		TeXFormula formula = new TeXFormula(latex);
		TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setType(type)
				.setSize(size).build();
		icon.setInsets(insets);
		return icon;
	}
	
	private static JavaScriptObject createReturnValue(TeXIcon icon) {
		JSONObject object = new JSONObject();
		object.put("width", new JSONNumber(icon.getIconWidth()));
		object.put("height", new JSONNumber(icon.getIconHeight()));
		object.put("baseline", new JSONNumber(icon.getBaseLine()));
		return object.getJavaScriptObject();
	}

}
