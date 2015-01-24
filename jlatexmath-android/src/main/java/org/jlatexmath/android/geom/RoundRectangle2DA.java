package org.jlatexmath.android.geom;

import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;

import android.graphics.RectF;

public class RoundRectangle2DA implements RoundRectangle2D {
	
	private RectF rect;
	private double arcw;
	private double arch;
	
	public RoundRectangle2DA(double x, double y,
			double w, double h, double arcw, double arch) {
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

	public Object getNativeObject() {
		return rect;
	}

}
