package org.scilab.forge.jlatexmath.platform.graphics;

public interface Image {
	
	public static final int TYPE_INT_RGB = 1;
    public static final int TYPE_INT_ARGB = 2;
	
	public int getWidth();
	
	public int getHeight();
	
	public Graphics2DInterface createGraphics2D();

}
