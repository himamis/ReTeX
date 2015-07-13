package com.himamis.retex.renderer.desktop.geom;

import java.awt.geom.Point2D;

public class Point2DD extends Point2D.Float implements com.himamis.retex.renderer.share.platform.geom.Point2D {

	private static final long serialVersionUID = 1L;

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
