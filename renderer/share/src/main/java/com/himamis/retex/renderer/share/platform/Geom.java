package com.himamis.retex.renderer.share.platform;

import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.geom.Line2D;
import com.himamis.retex.renderer.share.platform.geom.Point2D;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.geom.RoundRectangle2D;

public class Geom {

	private final GeomFactory geomFactory;

	public Geom() {
		geomFactory = FactoryProvider.INSTANCE.getGeomFactory();
	}

	public Rectangle2D createRectangle2D(double x, double y, double w, double h) {
		return geomFactory.createRectangle2D(x, y, w, h);
	}

	public Line2D createLine2D() {
		return geomFactory.createLine2D(0, 0, 0, 0);
	}

	public RoundRectangle2D createRoundRectangle2D(double x, double y, double w, double h, double arcw,
			double arch) {
		return geomFactory.createRoundRectangle2D(x, y, w, h, arcw, arch);
	}

	public Point2D createPoint2D(double x, double y) {
		return geomFactory.createPoint2D(x, y);
	}
}
