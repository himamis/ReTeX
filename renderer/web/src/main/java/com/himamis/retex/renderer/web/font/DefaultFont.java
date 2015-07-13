package com.himamis.retex.renderer.web.font;

import com.google.gwt.canvas.dom.client.Context2d;
import com.himamis.retex.renderer.share.platform.font.Font;

public class DefaultFont extends FontW implements FontWrapper {

	public DefaultFont(String name, int style, int size) {
		super(name, style, size);
	}
	
	@Override
	public void addFontLoadedCallback(FontLoadCallback callback) {
		callback.onFontLoaded(this);
		
	}
	
	@Override
	public Font deriveFont(int type) {
		return new DefaultFont(name, type, size);
	}
	
	@Override
	public void drawGlyph(String c, int x, int y, int size, Context2d ctx) {
		FontW derived = new DefaultFont(name, style, size);
		ctx.setFont(derived.getCssFontString());
		ctx.fillText(c, x, y);
	}
	
	@Override
	public FontWrapper getFontWrapper() {
		return this;
	}
	
	@Override
	public boolean isLoaded() {
		return true;
	}

}
