package org.scilab.forge.jlatexmath;

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
