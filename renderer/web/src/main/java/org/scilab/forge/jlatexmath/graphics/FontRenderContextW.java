package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.font.FontW;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;

public class FontRenderContextW implements FontRenderContext {
	
	private Graphics2DW graphics;
	
	public FontRenderContextW(Graphics2DW graphics) {
		this.graphics = graphics;
	}

	public double measureTextWith(String text, FontW font) {
		FontW oldFont = graphics.getFont();
		
		graphics.setFont(font);
		double width = graphics.getContext().measureText(text).getWidth();
		
		graphics.setFont(oldFont);
		return width;
	}

}
