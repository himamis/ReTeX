package org.scilab.forge.jlatexmath.font;

import com.himamis.retex.renderer.share.platform.font.TextAttribute;

public class TextAttributeD implements TextAttribute {

	private java.awt.font.TextAttribute textAttribute;

	public TextAttributeD(java.awt.font.TextAttribute textAttribute) {
		this.textAttribute = textAttribute;
	}

	public java.awt.font.TextAttribute getTextAttribute() {
		return textAttribute;
	}

}
