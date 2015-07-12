package org.scilab.forge.jlatexmath.geom;

import org.scilab.forge.jlatexmath.platform.geom.Point2D;

public class Point2DW implements Point2D {

	private double x;
	private double y;

	public Point2DW(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

}
