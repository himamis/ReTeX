package com.himamis.retex.renderer.desktop.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.himamis.retex.renderer.share.platform.graphics.BasicStroke;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.graphics.Image;
import com.himamis.retex.renderer.share.platform.graphics.Transform;

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
