package org.scilab.forge.jlatexmath.graphics;

import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import org.scilab.forge.jlatexmath.font.FontD;
import org.scilab.forge.jlatexmath.font.FontRenderContextD;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.geom.Line2D;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.RenderingHints;
import org.scilab.forge.jlatexmath.platform.graphics.Stroke;
import org.scilab.forge.jlatexmath.platform.graphics.Transform;

public class Graphics2DD implements Graphics2DInterface {

	private Graphics2D impl;

	public Graphics2DD(Graphics2D impl) {
		this.impl = impl;
	}

	public Graphics2D getImpl() {
		return impl;
	}

	public void setStroke(Stroke stroke) {
		impl.setStroke((java.awt.Stroke) stroke.getNativeObject());
	}

	public Stroke getStroke() {
		return new StrokeD(impl.getStroke());
	}

	public void setColor(Color color) {
		impl.setColor((java.awt.Color) color.getNativeObject());
	}

	public Color getColor() {
		return new ColorD(impl.getColor());
	}

	public Transform getTransform() {
		return new TransformD(impl.getTransform());
	}

	public Font getFont() {
		return new FontD(impl.getFont());
	}

	public void setFont(Font font) {
		impl.setFont(((FontD) font).impl);
	}

	public void fillRect(int x, int y, int width, int height) {
		impl.fillRect(x, y, width, height);
	}

	public void fill(Rectangle2D rectangle) {
		impl.fill((Shape) rectangle);
	}

	public void draw(Rectangle2D rectangle) {
		impl.draw((Shape) rectangle);
	}

	public void draw(RoundRectangle2D rectangle) {
		impl.draw((Shape) rectangle);
	}

	public void draw(Line2D line) {
		impl.draw((Shape) line);
	}

	public void drawChars(char[] data, int offset, int length, int x, int y) {
		impl.drawChars(data, offset, length, x, y);

	}

	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		impl.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		impl.fillArc(x, y, width, height, startAngle, arcAngle);
	}

	public void translate(double x, double y) {
		impl.translate(x, y);
	}

	public void scale(double x, double y) {
		impl.scale(x, y);
	}

	public void rotate(double theta, double x, double y) {
		impl.rotate(theta, x, y);
	}

	public void rotate(double theta) {
		impl.rotate(theta);
	}

	public void drawImage(Image image, int x, int y) {
		impl.drawImage((java.awt.Image) image, x, y, null);
	}

	public void drawImage(Image image, Transform transform) {
		impl.drawImage((java.awt.Image) image, (AffineTransform) transform,
				null);
	}

	public FontRenderContext getFontRenderContext() {
		return new FontRenderContextD(impl.getFontRenderContext());
	}

	public void dispose() {
		impl.dispose();
	}

	public void setRenderingHint(int key, int value) {
		impl.setRenderingHint(getNativeRenderingKey(key), getNativeRenderingValue(value));
	}

	public int getRenderingHint(int key) {
		Key nKey = getNativeRenderingKey(key);
		Object val = impl.getRenderingHint(nKey);
		return getRenderingValue(val);
	}

	private static Key getNativeRenderingKey(int key) {
		switch (key) {
		case RenderingHints.KEY_ANTIALIASING:
			return java.awt.RenderingHints.KEY_ANTIALIASING;
		case RenderingHints.KEY_RENDERING:
			return java.awt.RenderingHints.KEY_RENDERING;
		case RenderingHints.KEY_TEXT_ANTIALIASING:
			return java.awt.RenderingHints.KEY_TEXT_ANTIALIASING;
		default:
			return null;
		}
	}

	private static Object getNativeRenderingValue(int value) {
		switch (value) {
		case RenderingHints.VALUE_ANTIALIAS_ON:
			return java.awt.RenderingHints.VALUE_ANTIALIAS_ON;
		case RenderingHints.VALUE_RENDER_QUALITY:
			return java.awt.RenderingHints.VALUE_RENDER_QUALITY;
		case RenderingHints.VALUE_TEXT_ANTIALIAS_ON:
			return java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON;
		default:
			return null;
		}
	}

	private static int getRenderingValue(Object value) {
		if (value == java.awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC) {
			return RenderingHints.VALUE_INTERPOLATION_BICUBIC;
		} else if (value == java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR) {
			return RenderingHints.VALUE_INTERPOLATION_BILINEAR;
		} else if (value == java.awt.RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR) {
			return RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
		} else {
			return -1;
		}
	}

	private AffineTransform savedTransformation;
	
	public void saveTransformation() {
		savedTransformation = impl.getTransform();
	}

	public void restoreTransformation() {
		impl.setTransform(savedTransformation);
	}
}
