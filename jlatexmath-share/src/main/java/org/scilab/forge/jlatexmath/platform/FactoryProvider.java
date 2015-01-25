package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;

public abstract class FactoryProvider {
	
	public static FactoryProvider INSTANCE;
	
	private GeomFactory geomFactory;
	private FontFactory fontFactory;
	private GraphicsFactory graphicsFactory;
	private ParserFactory parserFactory;
	private ResourceLoaderFactory resourceLoaderFactory;
	
	protected abstract GeomFactory createGeomFactory();
	
	protected abstract FontFactory createFontFactory();
	
	protected abstract GraphicsFactory createGraphicsFactory();
	
	protected abstract ParserFactory createParserFactory();
	
	protected abstract ResourceLoaderFactory createResourceLoaderFactory();
	
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

	public ResourceLoaderFactory getResourceLoaderFactory() {
		if (resourceLoaderFactory == null) {
			resourceLoaderFactory = createResourceLoaderFactory();
		}
		return resourceLoaderFactory;
	}
}
