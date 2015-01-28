package org.scilab.forge.jlatexmath.platform.geom;

import org.scilab.forge.jlatexmath.platform.NativeObject;

public interface RoundRectangle2D extends NativeObject {

	public interface Float extends RoundRectangle2D {

	}

	public double getArcW();

	public double getArcH();

	public void setRoundRectangle(double x, double y, double w, double h, double arcw, double arch);
}
