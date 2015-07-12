package com.himamis.retex.renderer.desktop.graphics;

import java.awt.Color;

public class ColorD extends Color implements com.himamis.retex.renderer.share.platform.graphics.Color {

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

	public int getColor() {
		return getRGB();
	}
}
