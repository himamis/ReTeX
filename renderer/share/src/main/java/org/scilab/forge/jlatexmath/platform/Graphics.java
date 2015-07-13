package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class Graphics {

	private final GraphicsFactory graphicsFactory;

	public Graphics() {
		graphicsFactory = FactoryProvider.INSTANCE.getGraphicsFactory();
	}

	public Color createColor(int r, int g, int b) {
		return graphicsFactory.createColor(r, g, b);
	}

	public Color createColor(float r, float g, float b) {
		int red = Math.round(r * 255);
		int green = Math.round(g * 255);
		int blue = Math.round(b * 255);
		return createColor(red, green, blue);
	}

	public BasicStroke createBasicStroke(float width, int cap, int join, float miterLimit) {
		return graphicsFactory.createBasicStroke(width, cap, join, miterLimit);
	}

	public BasicStroke createBasicStroke(float width, int cap, int join) {
		return createBasicStroke(width, cap, join, 10.0f);
	}

	public Image createImage(int width, int height, int type) {
		return graphicsFactory.createImage(width, height, type);
	}

	public Image createImage(int width, int height) {
		return createImage(width, height, Image.TYPE_INT_RGB);
	}

	public Transform createTransform() {
		return graphicsFactory.createTransform();
	}

	public Image loadImage(String path) {
		return graphicsFactory.getImage(path);
	}
}
