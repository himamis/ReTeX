package org.scilab.forge.jlatexmath.font;

import java.awt.font.FontRenderContext;

public class FontRenderContextD extends FontRenderContext implements
		org.scilab.forge.jlatexmath.platform.font.FontRenderContext {

	private java.awt.font.FontRenderContext impl;

	public FontRenderContextD(java.awt.font.FontRenderContext impl) {
		this.impl = impl;
	}
}
