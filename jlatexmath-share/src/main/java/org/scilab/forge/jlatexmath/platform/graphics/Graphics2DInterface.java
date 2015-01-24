package org.scilab.forge.jlatexmath.platform.graphics;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.geom.Line2D;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;

public interface Graphics2DInterface {

	public void setStroke(Stroke stroke);

	public Stroke getStroke();

	public void setColor(Color color);

	public Color getColor();

	public Transform getTransform();
	
	public void saveTransformation();
	public void restoreTransformation();

	public Font getFont();

	public void setFont(Font font);

	public void fillRect(int x, int y, int width, int height);

	public void fill(Rectangle2D rectangle);

	public void draw(Rectangle2D rectangle);
	
	public void draw(RoundRectangle2D rectangle);

	public void draw(Line2D line);

	public void drawChars(char[] data, int offset, int length, int x, int y);

	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle);
	
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle);

	public void translate(double x, double y);

	public void scale(double x, double y);

	public void rotate(double theta, double x, double y);
	
	public void rotate(double theta);

	public void drawImage(Image image, int x, int y);
	
	public void drawImage(Image image, Transform transform);

	public FontRenderContext getFontRenderContext();
	
	public void setRenderingHint(int key, int value);
	
	public int getRenderingHint(int key);

	public void dispose();
}
