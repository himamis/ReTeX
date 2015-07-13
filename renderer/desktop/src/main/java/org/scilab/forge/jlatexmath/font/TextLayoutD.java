package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.geom.Rectangle2DD;
import org.scilab.forge.jlatexmath.graphics.Graphics2DD;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;

public class TextLayoutD implements TextLayout {
	
	private java.awt.font.TextLayout layout;
	
	public TextLayoutD(String string, java.awt.Font font,
			java.awt.font.FontRenderContext fontRenderContext) {
		layout = new java.awt.font.TextLayout(string, font, fontRenderContext);
	}

	public Rectangle2D getBounds() {
		return new Rectangle2DD(layout.getBounds());
	}

	public void draw(Graphics2DInterface graphics, int x, int y) {
		Graphics2DD g2 = (Graphics2DD) graphics;
		layout.draw(g2.getImpl(), x, y);
		
	}

}
