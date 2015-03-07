package org.scilab.forge.jlatexmath.geom;

import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;

import android.graphics.RectF;

public class RoundRectangle2DA implements RoundRectangle2D {

	private RectF rect;
	private double arcw;
	private double arch;

	public RoundRectangle2DA(double x, double y, double w, double h, double arcw, double arch) {
		rect = new RectF();
		setRectangle(x, y, w, h);
		this.arcw = arcw;
		this.arch = arch;
	}

	public void setRectangle(double x, double y, double w, double h) {
		float left = (float) x;
		float top = (float) y;
		float right = left + (float) w;
		float bottom = top + (float) h;
		rect.set(left, top, right, bottom);
	}

	public double getArcW() {
		return arcw;
	}

	public double getArcH() {
		return arch;
	}

	public double getX() {
		return rect.left;
	}

	public double getY() {
		return rect.top;
	}

	public double getWidth() {
		return rect.right - rect.left;
	}

	public double getHeight() {
		return rect.bottom - rect.top;
	}

	public Object getNativeObject() {
		return rect;
	}

	public void setRoundRectangle(double x, double y, double w, double h, double arcw, double arch) {
		setRectangle(x, y, w, h);
		this.arcw = arcw;
		this.arch = arch;
	}

}
