package com.himamis.retex.renderer.web.geom;

import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;

public class Rectangle2DW implements Rectangle2D {

	private double x;
	private double y;
	private double width;
	private double height;

	public Rectangle2DW(double x, double y, double width, double height) {
		setRectangle(x, y, width, height);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void setRectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
