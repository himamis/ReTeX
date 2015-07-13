package com.himamis.retex.renderer.share.platform.font;

import com.himamis.retex.renderer.share.exception.ResourceParseException;

public interface FontLoader {
	
	public static final float PIXELS_PER_POINT = 1f;

	public Font loadFont(Object fontInt, String name) throws ResourceParseException;
}
