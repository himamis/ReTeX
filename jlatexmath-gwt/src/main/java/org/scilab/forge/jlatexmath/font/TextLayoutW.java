package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.geom.Rectangle2DW;
import org.scilab.forge.jlatexmath.graphics.FontRenderContextW;
import org.scilab.forge.jlatexmath.graphics.Graphics2DW;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;

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
