package com.himamis.retex.renderer.web.graphics;

import com.himamis.retex.renderer.share.platform.font.FontRenderContext;
import com.himamis.retex.renderer.web.font.FontW;

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
