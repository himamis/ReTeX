package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.Font;

import com.google.gwt.canvas.dom.client.Context2d;

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
		// size ?
		ctx.setFont(getCssFontString());
		ctx.fillText(c.charAt(0) + "", x, y);
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
