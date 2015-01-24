package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.TextAttribute;

public class TextAttributeD implements TextAttribute {
	
	private java.awt.font.TextAttribute textAttribute;
	
	public TextAttributeD(java.awt.font.TextAttribute textAttribute) {
		this.textAttribute = textAttribute;
	}

	public Object getNativeObject() {
		return textAttribute;
	}

}
