package com.himamis.retex.renderer.share.platform.font;

import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.graphics.Graphics2DInterface;

public interface TextLayout {
	
	public Rectangle2D getBounds();
	
	public void draw(Graphics2DInterface graphics, int x, int y);

}
