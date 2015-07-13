package org.scilab.forge.jlatexmath.font;

import java.awt.font.FontRenderContext;

public class FontRenderContextD implements
		org.scilab.forge.jlatexmath.platform.font.FontRenderContext {

	public FontRenderContext impl;

	public FontRenderContextD(java.awt.font.FontRenderContext impl) {
		this.impl = impl;
	}
}
