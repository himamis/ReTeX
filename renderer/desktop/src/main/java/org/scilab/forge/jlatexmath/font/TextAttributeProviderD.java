package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.TextAttribute;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;

public class TextAttributeProviderD implements TextAttributeProvider {

	public TextAttribute getTextAttribute(String name) {
		try { // to avoid problems with Java 1.5
            return new TextAttributeD((java.awt.font.TextAttribute) TextAttribute.class.getField(name).get(TextAttribute.class));
        } catch (Exception e) { 
        	return null;
        }
	}

	public Integer getTextAttributeValue(String name) {
		try {
			return (Integer) (TextAttribute.class.getField(name).get(TextAttribute.class));
		} catch (Exception e) {
			return null;
		}
	}
	
}
