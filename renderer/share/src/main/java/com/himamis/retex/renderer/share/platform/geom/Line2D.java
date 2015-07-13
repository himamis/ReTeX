package com.himamis.retex.renderer.share.platform.geom;

public interface Line2D {

	public interface Float extends Line2D {
		
	}
	
	public double getX1();
	
	public double getY1();
	
	public double getX2();
	
	public double getY2();

	public void setLine(double x1, double y1, double x2, double y2);
}
