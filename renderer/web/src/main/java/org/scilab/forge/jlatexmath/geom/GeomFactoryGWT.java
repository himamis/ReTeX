package org.scilab.forge.jlatexmath.geom;

import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.geom.Line2D;
import com.himamis.retex.renderer.share.platform.geom.Point2D;
import com.himamis.retex.renderer.share.platform.geom.Rectangle2D;
import com.himamis.retex.renderer.share.platform.geom.RoundRectangle2D;

public class GeomFactoryGWT extends GeomFactory {

	@Override
	public Line2D createLine2D(double x1, double y1, double x2, double y2) {
		return new Line2DW(x1, x2, y1, y2);
	}

	@Override
	public Rectangle2D createRectangle2D(double x, double y, double w, double h) {
		return new Rectangle2DW(x, y, w, h);
	}

	@Override
	public RoundRectangle2D createRoundRectangle2D(double x, double y, double w, double h, double arcw,
			double arch) {
		return new RoundRectangle2DW(x, y, w, h, arcw, arch);
	}

	@Override
	public Point2D createPoint2D(double x, double y) {
		return new Point2DW(x, y);
	}

}
