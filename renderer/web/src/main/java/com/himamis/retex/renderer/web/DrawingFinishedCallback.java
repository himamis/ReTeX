package com.himamis.retex.renderer.web;

/**
 * If registered with Graphics2DW object, it will be notified when all the
 * drawing has finished.
 */
public interface DrawingFinishedCallback {

	/**
	 * Called when the drawing has finished.
	 */
	void onDrawingFinished();

}
