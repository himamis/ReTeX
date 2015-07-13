package com.himamis.retex.renderer.web.graphics;

import com.himamis.retex.renderer.share.platform.graphics.BasicStroke;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.graphics.Image;
import com.himamis.retex.renderer.share.platform.graphics.Transform;

public class GraphicsFactoryGWT extends GraphicsFactory {

	@Override
	public BasicStroke createBasicStroke(float width, int cap, int join, float miterLimit) {
		return new BasicStrokeW(width, cap, join, miterLimit);
	}

	@Override
	public Color createColor(int red, int green, int blue) {
		return new ColorW(red, green, blue);
	}

	@Override
	public Image createImage(int width, int height, int type) {
		return new ImageW(width, height, type);
	}

	@Override
	public Image getImage(String path) {
		throw new UnsupportedOperationException("Cannot load image from a path");
	}

	@Override
	public Transform createTransform() {
		return new TransformW();
	}

}
