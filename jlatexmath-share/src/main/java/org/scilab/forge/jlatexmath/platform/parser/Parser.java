package org.scilab.forge.jlatexmath.platform.parser;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;

/**
 * Interface for DOM parsers.
 */
public interface Parser {

	/**
	 * Parses the input. For the implementation of the input, please refer to
	 * the implementations of this interface.
	 * 
	 * @param input
	 * @return
	 */
	public Document parse(Object input) throws ResourceParseException;

	public void setIgnoringElementContentWhitespace(boolean whitespace);

	public void setIgnoringComments(boolean ignoreComments);
}
