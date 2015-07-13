package com.himamis.retex.renderer.share.platform.graphics;

public abstract class GraphicsFactory {
	
	public abstract BasicStroke createBasicStroke(float width, int cap, int join, float miterLimit);
	
	public abstract Color createColor(int red, int green, int blue);

	public abstract Image createImage(int width, int height, int type);
	
	public abstract Image getImage(String path);

	public abstract Transform createTransform();
	
}
