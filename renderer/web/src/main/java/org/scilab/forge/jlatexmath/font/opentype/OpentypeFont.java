package org.scilab.forge.jlatexmath.font.opentype;

import java.util.ArrayList;
import java.util.List;

import org.scilab.forge.jlatexmath.font.FontW;
import org.scilab.forge.jlatexmath.font.FontWrapper;

import com.google.gwt.core.shared.GWT;
import com.himamis.retex.renderer.share.platform.font.Font;

public class OpentypeFont extends FontW implements OpentypeFontStatusListener {

	private Opentype opentype = Opentype.INSTANCE;
	private List<FontLoadCallback> fontLoadCallbacks;

	public OpentypeFont(String name, int style, int size) {
		super(name, style, size);
		fontLoadCallbacks = new ArrayList<FontLoadCallback>();
	}

	@Override
	public Font deriveFont(int type) {
		return new OpentypeFont(name, type, size);
	}

	@Override
	public boolean isLoaded() {
		return opentype.fontIsLoaded(name);
	}

	@Override
	public void addFontLoadedCallback(FontLoadCallback callback) {
		if (opentype.fontIsLoaded(name)) {
			callback.onFontLoaded(this);
		} else {
			fontLoadCallbacks.add(callback);
			opentype.addListener(this);
		}
	}

	@Override
	public FontWrapper getFontWrapper() {
		return opentype.getFont(name);
	}

	@Override
	public void onFontLoaded(OpentypeFontWrapper font, String familyName) {
		if (!familyName.equals(name)) {
			// not interested
			return;
		}
		GWT.log("Font " + name + " loaded");
		opentype.removeListener(this);
		for (FontLoadCallback fontLoadCallback : fontLoadCallbacks) {
			fontLoadCallback.onFontLoaded(this);
		}
		fontLoadCallbacks.clear();
		fontLoadCallbacks = null;
	}

	@Override
	public void onFontError(Object error, String familyName) {
		if (!familyName.equals(name)) {
			// not interested
			return;
		}
		GWT.log("Font " + name + " error");
		GWT.log(error.toString());
		opentype.removeListener(this);
		for (FontLoadCallback fontLoadCallback : fontLoadCallbacks) {
			fontLoadCallback.onFontError(this);
		}
		fontLoadCallbacks.clear();
		fontLoadCallbacks = null;
	}

}
