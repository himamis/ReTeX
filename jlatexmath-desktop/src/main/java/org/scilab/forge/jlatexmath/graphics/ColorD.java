package org.scilab.forge.jlatexmath.graphics;

import java.awt.Color;

public class ColorD extends Color implements org.scilab.forge.jlatexmath.platform.graphics.Color {

	private static final long serialVersionUID = 1L;
	
	public ColorD(Color color) {
		this(color.getRed(), color.getGreen(), color.getBlue());
	}

	public ColorD(int r, int g, int b) {
		super(r, g, b);
	}

	public Object getNativeObject() {
		return this;
	}

}
