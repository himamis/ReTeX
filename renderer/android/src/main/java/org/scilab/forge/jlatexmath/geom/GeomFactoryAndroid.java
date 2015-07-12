package org.scilab.forge.jlatexmath.geom;

import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.geom.Line2D;
import org.scilab.forge.jlatexmath.platform.geom.Point2D;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;

public class GeomFactoryAndroid extends GeomFactory {

	@Override
	public Line2D createLine2D(double x1, double y1, double x2, double y2) {
		return new Line2DA(x1, y1, x2, y2);
	}

	@Override
	public Rectangle2D createRectangle2D(double x, double y, double w, double h) {
		return new Rectangle2DA(x, y, w, h);
	}

	@Override
	public RoundRectangle2D createRoundRectangle2D(double x, double y,
			double w, double h, double arcw, double arch) {
		return new RoundRectangle2DA(x, y, w, h, arcw, arch);
	}

	@Override
	public Point2D createPoint2D(double x, double y) {
		return new Point2DA(x, y);
	}

}
