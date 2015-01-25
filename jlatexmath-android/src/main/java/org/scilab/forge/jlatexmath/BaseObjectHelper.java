package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;

public class BaseObjectHelper {
	public static String getPath(Object base, String name) {
		String ret = null;
		if (base == CyrillicRegistration.class) {
			ret = "cyrillic/fonts/" + name;
		} else if (base == GreekRegistration.class) {
			ret = "greek/fonts/" + name;
		} else {
			ret = name;
		}
		return ret;
	}
}
