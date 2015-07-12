package org.scilab.forge.jlatexmath.platform.geom;

public abstract class GeomFactory {

	public abstract Line2D createLine2D(double x1, double y1, double x2, double y2);
	
	public abstract Rectangle2D createRectangle2D(double x, double y, double w, double h);
	
	public abstract RoundRectangle2D createRoundRectangle2D(double x, double y, double w, double h, double arcw, double arch);
	
	public abstract Point2D createPoint2D(double x, double y);
}
