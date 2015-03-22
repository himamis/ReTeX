package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;

public class ImageW implements Image, LoadHandler {

	private Canvas canvas;
	private int width;
	private int height;

	private com.google.gwt.user.client.ui.Image temp;

	public ImageW(String path) {
		canvas = Canvas.createIfSupported();
		
		temp = new com.google.gwt.user.client.ui.Image();
		temp.setUrl(path);
		// TODO attach image to start loading
		temp.addLoadHandler(this);
	}

	public ImageW(int width, int height, int type) {
		canvas = Canvas.createIfSupported();
		canvas.setWidth(width + "px");
		canvas.setHeight(height + "px");
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

	@Override
	public void onLoad(LoadEvent event) {
		width = temp.getWidth();
		height = temp.getHeight();
		ImageElement element = ImageElement.as(temp.getElement());
		canvas.getContext2d().drawImage(element, 0.0d, 0.0d);
		temp = null;
		canvas.setWidth(width + "px");
		canvas.setHeight(height + "px");
	}

}
