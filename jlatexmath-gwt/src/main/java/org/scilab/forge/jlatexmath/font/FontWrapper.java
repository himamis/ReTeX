package org.scilab.forge.jlatexmath.font;

import com.google.gwt.canvas.dom.client.Context2d;

public interface FontWrapper {
	
	/**
	 * Draws the first character of the string.
	 * @param c String of which the first character will be drawn
	 * @param x x coordinate of the character
	 * @param y y coordinate of the character
	 * @param size size of the character
	 * @param ctx ctx used for drawing
	 */
	void drawGlyph(String c, int x, int y, int size, Context2d ctx);

}
