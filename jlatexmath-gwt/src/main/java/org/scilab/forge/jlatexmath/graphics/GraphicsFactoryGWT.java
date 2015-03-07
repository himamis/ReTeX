package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.BasicStroke;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class GraphicsFactoryGWT extends GraphicsFactory {

	@Override
	public BasicStroke createBasicStroke(float width, int cap, int join, float miterLimit) {
		return new BasicStrokeW(width, cap, join, miterLimit);
	}

	@Override
	public Color createColor(int red, int green, int blue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage(int width, int height, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transform createTransform() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
