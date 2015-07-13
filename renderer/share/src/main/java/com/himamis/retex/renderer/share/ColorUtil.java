package com.himamis.retex.renderer.share;

import java.util.HashMap;
import java.util.Map;

import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;

public abstract class ColorUtil {

	private static final GraphicsFactory GRAPHICS_FACTORY = FactoryProvider.INSTANCE.getGraphicsFactory();

	public static final Color RED = GRAPHICS_FACTORY.createColor(255, 0, 0);
	public static final Color BLACK = GRAPHICS_FACTORY.createColor(0, 0, 0);
	public static final Color WHITE = GRAPHICS_FACTORY.createColor(255, 255, 255);
	public static final Color BLUE = GRAPHICS_FACTORY.createColor(0, 0, 255);
	public static final Color GREEN = GRAPHICS_FACTORY.createColor(0, 255, 0);
	public static final Color CYAN = GRAPHICS_FACTORY.createColor(0, 255, 255);
	public static final Color MAGENTA = GRAPHICS_FACTORY.createColor(255, 0, 255);
	public static final Color YELLOW = GRAPHICS_FACTORY.createColor(255, 255, 0);
	
	public static final Map<String, Color> COLOR_CONSTANTS = new HashMap<String, Color>();
	
	static {
		COLOR_CONSTANTS.put("RED", RED);
		COLOR_CONSTANTS.put("BLACK", BLACK);
		COLOR_CONSTANTS.put("WHITE", WHITE);
		COLOR_CONSTANTS.put("BLUE", BLUE);
		COLOR_CONSTANTS.put("GREEN", GREEN);
		COLOR_CONSTANTS.put("CYAN", CYAN);
		COLOR_CONSTANTS.put("MAGENTA", MAGENTA);
		COLOR_CONSTANTS.put("YELLOW", YELLOW);
	}

	public static Color decode(String string) throws NumberFormatException {
		Integer intval = Integer.decode(string);
		int i = intval.intValue();
		return GRAPHICS_FACTORY.createColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
	}

	public static StringBuilder sb = new StringBuilder("#");

	public static String encode(Color color) {
		int colorInt = color.getColor();
		int r = (colorInt & 0xFF000000) >> 24;
		int g = (colorInt & 0x00FF0000) >> 16;
		int b = (colorInt & 0x0000FF00) >> 8;
		sb.setLength(1);
		sb.append('#').append(pad(Integer.toHexString(r))).append(pad(Integer.toHexString(g)))
				.append(pad(Integer.toHexString(b)));
		return sb.toString();
	}

	private static String pad(String hex) {
		if (hex.length() == 0) {
			return "00";
		} else if (hex.length() == 1) {
			return "0" + hex;
		}
		return hex;
	}

}
