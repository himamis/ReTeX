package org.scilab.forge.jlatexmath.platform.parser;

public interface Element extends Node {
	
	public NodeList getElementsByTagName(String name);
	
	public String getAttribute(String name);

	public String getTagName();

	public NodeList getChildNodes();
	
	public NamedNodeMap getAttributes();

	public boolean isNull();
}
