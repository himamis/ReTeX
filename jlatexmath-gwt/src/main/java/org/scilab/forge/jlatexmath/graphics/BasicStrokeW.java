package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;

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

	@Override
	public Object getNativeObject() {
		// TODO remove this
		return null;
	}

}
