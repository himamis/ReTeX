package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;

public class ImageA implements Image {
	
	private Bitmap mBitmap;
	
	public ImageA(int width, int height, int type) {
		mBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
	}

	public int getWidth() {
		return mBitmap.getWidth();
	}

	public int getHeight() {
		return mBitmap.getWidth();
	}

	public Graphics2DInterface createGraphics2D() {
		Canvas canvas = new Canvas(mBitmap);
		Graphics2DA g2 = new Graphics2DA(canvas);
		return g2;
	}

	public Bitmap getBitmap() {
		return mBitmap;
	}
}
