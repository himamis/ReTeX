package com.himamis.retex.renderer.share.platform;

import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;

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
