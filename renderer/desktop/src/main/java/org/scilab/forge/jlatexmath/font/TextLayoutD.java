package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.geom.Rectangle2DD;
import org.scilab.forge.jlatexmath.graphics.Graphics2DD;

import com.himamis.retex.renderer.share.platform.font.TextLayout;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;

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
