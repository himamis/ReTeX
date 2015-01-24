package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;

public abstract class FactoryProvider {
	
	public static FactoryProvider INSTANCE;
	
	private GeomFactory geomFactory;
	private FontFactory fontFactory;
	private GraphicsFactory graphicsFactory;
	private ParserFactory parserFactory;
	
	protected abstract GeomFactory createGeomFactory();
	
	protected abstract FontFactory createFontFactory();
	
	protected abstract GraphicsFactory createGraphicsFactory();
	
	protected abstract ParserFactory createParserFactory();
	
	protected FactoryProvider() { }

	public GeomFactory getGeomFactory() {
		if (geomFactory == null) {
			geomFactory = createGeomFactory();
		}
		return geomFactory;
	}

	public FontFactory getFontFactory() {
		if (fontFactory == null) {
			fontFactory = createFontFactory();
		}
		return fontFactory;
	}

	public GraphicsFactory getGraphicsFactory() {
		if (graphicsFactory == null) {
			graphicsFactory = createGraphicsFactory();
		}
		return graphicsFactory;
	}
	
	public ParserFactory getParserFactory() {
		if (parserFactory == null) {
			parserFactory = createParserFactory();
		}
		return parserFactory;
	}
}
