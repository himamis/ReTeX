package org.scilab.forge.jlatexmath.graphics;

import java.awt.geom.AffineTransform;

import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class TransformD extends AffineTransform implements Transform {

	private static final long serialVersionUID = 1L;
	
	public TransformD() {
		
	}

	public TransformD(AffineTransform transform) {
		super(transform);
	}

	public Transform createClone() {
		return new TransformD(this);
	}

	public Object getNativeObject() {
		return this;
	}

}
