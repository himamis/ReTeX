package org.scilab.forge.jlatexmath.platform.resources;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;

public interface ResourceLoader {

	/**
	 * Loads a resource from the specified path. For specific return types
	 * please refer to the implementations of this interface.
	 * 
	 * @param path
	 *            the path to the resource
	 * @return resource
	 */
	public Object loadResource(Object base, String path) throws ResourceParseException;
}
