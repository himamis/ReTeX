package org.scilab.forge.jlatexmath.platform.font;

public interface TextAttributeProvider {
	
	public TextAttribute getTextAttribute(String name);
	
	public Integer getTextAttributeValue(String name);

}
