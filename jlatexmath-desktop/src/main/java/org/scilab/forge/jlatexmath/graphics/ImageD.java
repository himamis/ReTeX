package org.scilab.forge.jlatexmath.graphics;

import java.awt.image.BufferedImage;

import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

public class ImageD extends BufferedImage implements Image {
	
	public ImageD(BufferedImage image) {
		super(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);
	}

	public ImageD(int width, int height, int imageType) {
		super(width, height, imageType);
	}

	public Graphics2DInterface createGraphics2D() {
		return new Graphics2DD(createGraphics());
	}

}
