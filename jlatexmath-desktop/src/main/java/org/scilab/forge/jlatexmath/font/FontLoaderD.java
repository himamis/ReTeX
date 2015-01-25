package org.scilab.forge.jlatexmath.font;

import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.exception.XMLResourceParseException;
import org.scilab.forge.jlatexmath.platform.Resource;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;

public class FontLoaderD implements FontLoader {
	
	private static boolean registerFontExceptionDisplayed = false; 
	private static boolean shouldRegisterFonts = true;

	public Font loadFont(Object fontInputStream, String name) throws ResourceParseException {
		InputStream fontIn = (InputStream) fontInputStream;
		if (fontIn ==  null) {
			fontIn = (InputStream) new Resource().loadResource(name);
		}
		try {
            java.awt.Font f = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fontIn).deriveFont(PIXELS_PER_POINT);
	    GraphicsEnvironment graphicEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    /**
	     * The following fails under java 1.5
	     * graphicEnv.registerFont(f);
	     * dynamic load then
	     */
	    if (shouldRegisterFonts) {
		try {
		    Method registerFontMethod = graphicEnv.getClass().getMethod("registerFont", new Class[] { Font.class });
		    if ((Boolean) registerFontMethod.invoke(graphicEnv, new Object[] { f }) == Boolean.FALSE) {
			System.err.println("Cannot register the font " + f.getFontName());
		    }
		} catch (Exception ex) {
		    if (!registerFontExceptionDisplayed) {
			System.err.println("Warning: Jlatexmath: Could not access to registerFont. Please update to java 6");
			registerFontExceptionDisplayed = true;
		    }
		}
	    }
	    return new FontD(f);
        } catch (Exception e) {
            throw new XMLResourceParseException("FontLoader"
						+ ": FontLoader '" + name + "'. Error message: "
						+ e.getMessage());
        } finally {
            try {
                if (fontIn != null)
                    fontIn.close();
            } catch (IOException ioex) {
                throw new RuntimeException("Close threw exception", ioex);
            }
        }
	}

}
