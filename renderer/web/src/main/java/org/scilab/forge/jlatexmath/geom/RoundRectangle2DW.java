package org.scilab.forge.jlatexmath.geom;

import com.himamis.retex.renderer.share.platform.geom.RoundRectangle2D;

public class RoundRectangle2DW implements RoundRectangle2D {

	private double x;
	private double y;
	private double width;
	private double height;
	private double arcW;
	private double arcH;

	public RoundRectangle2DW(double x, double y, double width, double height, double arcw, double arch) {
		setRoundRectangle(x, y, width, height, arcw, arch);
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

	public double getArcW() {
		return arcW;
	}

	public void setArcW(double arcW) {
		this.arcW = arcW;
	}

	public double getArcH() {
		return arcH;
	}

	public void setArcH(double arcH) {
		this.arcH = arcH;
	}

	@Override
	public void setRoundRectangle(double x, double y, double width, double height, double arcW, double arcH) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.arcW = arcW;
		this.arcH = arcH;
	}

}
