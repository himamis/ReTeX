package org.scilab.forge.jlatexmath.geom;

import java.awt.geom.Line2D;

public class Line2DD extends Line2D.Float implements com.himamis.retex.renderer.share.platform.geom.Line2D {

	private static final long serialVersionUID = 1L;

	public Line2DD(double x1, double y1, double x2, double y2) {
		setLine(x1, y1, x2, y2);
	}

}
