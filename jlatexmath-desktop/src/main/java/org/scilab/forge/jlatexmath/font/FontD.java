package org.scilab.forge.jlatexmath.font;

import java.util.HashMap;
import java.util.Map;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public class FontD implements Font {

	public java.awt.Font impl;

	public FontD(java.awt.Font impl) {
		this.impl = impl;
	}

	public FontD(String name, int style, int size) {
		impl = new java.awt.Font(name, style, size);
	}

	public Font deriveFont(int type) {
		return new FontD(impl.deriveFont(type));
	}

	public Font deriveFont(Map<TextAttribute, Object> map) {
		return new FontD(impl.deriveFont(convertMap(map)));
	}

	public Object getNativeObject() {
		return impl;
	}

	private static Map<java.awt.font.TextAttribute, Object> helper = new HashMap<java.awt.font.TextAttribute, Object>();

	private static Map<java.awt.font.TextAttribute, Object> convertMap(
			Map<TextAttribute, Object> map) {
		helper.clear();
		for (TextAttribute key : map.keySet()) {
			helper.put((java.awt.font.TextAttribute) key.getNativeObject(),
					map.get(key));
		}
		return helper;
	}
}
