package com.himamis.retex.renderer.desktop.geom;

import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.geom.Line2D;
import com.himamis.retex.renderer.share.platform.geom.Point2D;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.geom.RoundRectangle2D;

public class GeomFactoryDesktop extends GeomFactory {

	@Override
	public Line2D createLine2D(double x1, double y1, double x2, double y2) {
		return new Line2DD(x1, y1, x2, y2);
	}

	@Override
	public Rectangle2D createRectangle2D(double x, double y, double width, double height) {
		return new Rectangle2DD(x, y, width, height);
	}

	@Override
	public RoundRectangle2D createRoundRectangle2D(double x, double y,
			double w, double h, double arcw, double arch) {
		return new RoundRectangle2DD(x, y, w, h, arcw, arch);
	}

	@Override
	public Point2D createPoint2D(double x, double y) {
		return new Point2DD(x, y);
	}


}
