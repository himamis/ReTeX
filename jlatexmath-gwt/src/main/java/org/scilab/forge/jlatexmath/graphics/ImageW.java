package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

import com.google.gwt.canvas.client.Canvas;

public class ImageW implements Image {

	private Canvas canvas;
	private int width;
	private int height;

	public ImageW(int width, int height, int type) {
		canvas = Canvas.createIfSupported();
		canvas.setWidth(width + "px");
		canvas.setHeight(height + "px");
		canvas.setCoordinateSpaceHeight(height);
		canvas.setCoordinateSpaceWidth(width);
		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public Graphics2DInterface createGraphics2D() {
		return new Graphics2DW(canvas);
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
