package com.himamis.retex.renderer.web.font;

import com.himamis.retex.renderer.share.platform.font.Font;
import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.share.platform.font.TextLayout;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;
import com.himamis.retex.renderer.web.geom.Rectangle2DW;
import com.himamis.retex.renderer.web.graphics.FontRenderContextW;
import com.himamis.retex.renderer.web.graphics.Graphics2DW;

public class TextLayoutW implements TextLayout {

	private String string;
	private FontW font;
	private FontRenderContextW fontRenderContext;

	public TextLayoutW(String string, Font font,
			FontRenderContext fontRenderContext) {
		this.string = string;
		this.font = (FontW) font;
		this.fontRenderContext = ((FontRenderContextW) fontRenderContext);
	}

	@Override
	public Rectangle2D getBounds() {
		// improve this part with opentype.js
		double width = fontRenderContext.measureTextWith(string, font);
		double height = font.getSize();
		return new Rectangle2DW(0, 0, width, height);
	}

	@Override
	public void draw(Graphics2DInterface graphics, int x, int y) {
		Graphics2DW g2d = (Graphics2DW) graphics;
		g2d.setFont(font);
		g2d.drawText(string, x, y);
	}

}
