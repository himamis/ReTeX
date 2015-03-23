package org.scilab.forge.jlatexmath.resources;

import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

public class ResourceLoaderW implements ResourceLoader {

	@Override
	public Object loadResource(Object base, String path) throws ResourceParseException {
		// base object is either a class or null
		if (base == null) {
			// open path as string
		} else {
			
		}
		return null;
	}

	private String getPath(Class<?> clazz) {
		if (CyrillicRegistration.class.equals(clazz)) {
			return "cyrillic/";
		} 
		if (GreekRegistration.class.equals(clazz)) {
			return "greek/";
		}
		return "";
 	}
}
