package org.scilab.forge.jlatexmath.platform.font;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;

public interface FontLoader {
	
	public static final float PIXELS_PER_POINT = 1f;

	public Font loadFont(String name) throws ResourceParseException;
}
