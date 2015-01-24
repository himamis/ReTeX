package org.scilab.forge.jlatexmath.platform.parser;

import org.scilab.forge.jlatexmath.Glue;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;

/**
 * Parses the glue settings (different types and rules) from an XML-file.
 */
public interface GlueSettingsParser {
	
	public static final String RESOURCE_NAME = "GlueSettings.xml";
	
	public Glue[] getGlueTypes();

	public int[][][] createGlueTable() throws ResourceParseException;
}
