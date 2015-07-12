package org.scilab.forge.jlatexmath.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class GraphicsFactoryDesktop extends GraphicsFactory {

	@Override
	public BasicStroke createBasicStroke(float width, int cap, int join,
			float miterLimit) {
		return new BasicStrokeD(width, cap, join, miterLimit);
	}

	@Override
	public Color createColor(int red, int green, int blue) {
		return new ColorD(red, green, blue);
	}

	@Override
	public Image createImage(int width, int height, int type) {
		return new ImageD(width, height, type);
	}

	public Image getImage(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			return null;
		}
		return new ImageD(img);
	}

	@Override
	public Transform createTransform() {
		return new TransformD();
	}

}
