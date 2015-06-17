package org.scilab.forge.jlatexmath.geom;

import java.awt.geom.RoundRectangle2D;

public class RoundRectangle2DD extends RoundRectangle2D.Float implements org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D {

	private static final long serialVersionUID = 1L;

	public RoundRectangle2DD(double x, double y,
			double w, double h, double arcw, double arch) {
		setRoundRect(x, y, w, h, arcw, arch);
	}

	public double getArcW() {
		return getArcWidth();
	}

	public double getArcH() {
		return getArcHeight();
	}

	public Object getNativeObject() {
		return this;
	}

	public void setRoundRectangle(double x, double y, double w, double h, double arcw, double arch) {
		setRoundRect(x, y, w, h, arcw, arch);
	}
}
