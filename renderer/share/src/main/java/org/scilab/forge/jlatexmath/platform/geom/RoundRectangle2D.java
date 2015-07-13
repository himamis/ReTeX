package org.scilab.forge.jlatexmath.platform.geom;

public interface RoundRectangle2D {

	public interface Float extends RoundRectangle2D {

	}

	public double getArcW();

	public double getArcH();

	public double getX();

	public double getY();

	public double getWidth();

	public double getHeight();

	public void setRoundRectangle(double x, double y, double w, double h, double arcw, double arch);
}
