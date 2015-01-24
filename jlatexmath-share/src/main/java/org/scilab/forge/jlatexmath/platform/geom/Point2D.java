package org.scilab.forge.jlatexmath.platform.geom;

public interface Point2D {

	public interface Float extends Point2D {
		
	}
	
	public double getX();
	
	public double getY();
	
	public void setX(double x);
	
	public void setY(double y);
}
