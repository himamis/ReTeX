package org.scilab.forge.jlatexmath.geom;

import org.scilab.forge.jlatexmath.platform.geom.Line2D;

public class Line2DW implements Line2D {

	private double x1;
	private double x2;
	private double y1;
	private double y2;

	public Line2DW(double x1, double x2, double y1, double y2) {
		setLine(x1, y1, x2, y2);
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

}
