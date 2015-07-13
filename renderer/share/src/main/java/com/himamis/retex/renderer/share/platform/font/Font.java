package com.himamis.retex.renderer.share.platform.font;

import java.util.Map;

public interface Font {

	/**
	 * The plain style constant.
	 */
	public static final int PLAIN = 0;

	/**
	 * The bold style constant. This can be combined with the other style
	 * constants (except PLAIN) for mixed styles.
	 */
	public static final int BOLD = 1;

	/**
	 * The italicized style constant. This can be combined with the other style
	 * constants (except PLAIN) for mixed styles.
	 */
	public static final int ITALIC = 2;
	
	public Font deriveFont(Map<TextAttribute,Object> map);
	
	public Font deriveFont(int type);

}
