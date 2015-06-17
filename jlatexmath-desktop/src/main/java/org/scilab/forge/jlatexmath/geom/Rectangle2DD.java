package org.scilab.forge.jlatexmath.geom;

import java.awt.geom.Rectangle2D;

public class Rectangle2DD extends Rectangle2D.Float implements org.scilab.forge.jlatexmath.platform.geom.Rectangle2D {

	private static final long serialVersionUID = 1L;

	public Rectangle2DD(Rectangle2D rectangle) {
		setRect(rectangle);
	}
	
	public Rectangle2DD(double x, double y, double width, double height) {
		setRect(x, y, width, height);
	}
	
	public Object getNativeObject() {
		return this;
	}

	public void setRectangle(double x, double y, double width, double height) {
		setRect(x, y, width, height);
	}
}
