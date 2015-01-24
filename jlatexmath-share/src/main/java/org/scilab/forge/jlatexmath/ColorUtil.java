package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;

public abstract class ColorUtil {

	private static final GraphicsFactory GRAPHICS_FACTORY = FactoryProvider.INSTANCE
			.getGraphicsFactory();

	public static final Color RED = GRAPHICS_FACTORY.createColor(255, 0, 0);
	public static final Color BLACK = GRAPHICS_FACTORY.createColor(0, 0, 0);
	public static final Color WHITE = GRAPHICS_FACTORY.createColor(255, 255,
			255);
	public static final Color BLUE = GRAPHICS_FACTORY.createColor(0, 0, 255);
	public static final Color GREEN = GRAPHICS_FACTORY.createColor(0, 255, 0);
	public static final Color CYAN = GRAPHICS_FACTORY.createColor(0, 255, 255);
	public static final Color MAGENTA = GRAPHICS_FACTORY.createColor(255, 0,
			255);
	public static final Color YELLOW = GRAPHICS_FACTORY
			.createColor(255, 255, 0);

	public static Color decode(String string) throws NumberFormatException {
		Integer intval = Integer.decode(string);
		int i = intval.intValue();
		return GRAPHICS_FACTORY.createColor((i >> 16) & 0xFF, (i >> 8) & 0xFF,
				i & 0xFF);
	}

}
