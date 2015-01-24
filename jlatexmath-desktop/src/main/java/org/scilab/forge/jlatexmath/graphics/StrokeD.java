package org.scilab.forge.jlatexmath.graphics;

import java.awt.Shape;

import org.scilab.forge.jlatexmath.platform.graphics.Stroke;

public class StrokeD implements Stroke, java.awt.Stroke {

	private java.awt.Stroke impl;

	public StrokeD(java.awt.Stroke impl) {
		this.impl = impl;
	}

	public Shape createStrokedShape(Shape p) {
		return impl.createStrokedShape(p);
	}

	public Object getNativeObject() {
		return impl;
	}
}
