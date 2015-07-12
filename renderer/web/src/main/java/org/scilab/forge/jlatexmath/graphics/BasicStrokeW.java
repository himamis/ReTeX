package org.scilab.forge.jlatexmath.graphics;

import com.google.gwt.canvas.dom.client.Context2d.LineCap;
import com.google.gwt.canvas.dom.client.Context2d.LineJoin;
import com.himamis.retex.renderer.share.platform.graphics.BasicStroke;

public class BasicStrokeW implements BasicStroke {

	private float width;
	private int cap;
	private int join;
	private float miterLimit;

	public BasicStrokeW(float width, int cap, int join, float miterLimit) {
		this.width = width;
		this.cap = cap;
		this.join = join;
		this.miterLimit = miterLimit;
	}

	public BasicStrokeW(float width, String cap, String join, float miterLimit) {
		this.width = width;
		this.cap = getLineCap(LineCap.valueOf(cap.toUpperCase()));
		this.join = getLineJoin(LineJoin.valueOf(join.toUpperCase()));
		this.miterLimit = miterLimit;
	}

	public float getWidth() {
		return width;
	}

	public int getCap() {
		return cap;
	}

	public int getJoin() {
		return join;
	}

	public float getMiterLimit() {
		return miterLimit;
	}

	public LineCap getJSLineCap() {
		switch (cap) {
		case CAP_BUTT:
			return LineCap.BUTT;
		case CAP_ROUND:
			return LineCap.ROUND;
		case CAP_SQUARE:
			return LineCap.SQUARE;
		default:
			return LineCap.BUTT;
		}
	}

	public LineJoin getJSLineJoin() {
		switch (join) {
		case JOIN_BEVEL:
			return LineJoin.BEVEL;
		case JOIN_MITER:
			return LineJoin.MITER;
		case JOIN_ROUND:
			return LineJoin.ROUND;
		default:
			return LineJoin.BEVEL;
		}
	}

	private static int getLineJoin(LineJoin lineJoin) {
		switch (lineJoin) {
		case BEVEL:
			return JOIN_BEVEL;
		case MITER:
			return JOIN_MITER;
		case ROUND:
			return JOIN_ROUND;
		default:
			return JOIN_BEVEL;
		}
	}

	private static int getLineCap(LineCap lineCap) {
		switch (lineCap) {
		case BUTT:
			return CAP_BUTT;
		case ROUND:
			return CAP_ROUND;
		case SQUARE:
			return CAP_SQUARE;
		default:
			return CAP_BUTT;
		}
	}
}
