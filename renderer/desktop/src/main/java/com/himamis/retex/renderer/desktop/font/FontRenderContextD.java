package com.himamis.retex.renderer.desktop.font;

import java.awt.font.FontRenderContext;

public class FontRenderContextD implements
		com.himamis.retex.renderer.share.platform.font.FontRenderContext {

	public FontRenderContext impl;

	public FontRenderContextD(java.awt.font.FontRenderContext impl) {
		this.impl = impl;
	}
}
