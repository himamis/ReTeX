package org.scilab.forge.jlatexmath.geom;

import java.awt.geom.Point2D;

public class Point2DD extends Point2D.Float implements org.scilab.forge.jlatexmath.platform.geom.Point2D {

	public Point2DD(double x, double y) {
		setLocation(x, y);
	}
	
	public void setX(double x) {
		this.x = (float) x;
	}

	public void setY(double y) {
		this.y = (float) y;
	}

}
