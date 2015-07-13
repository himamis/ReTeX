package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.font.FontFactoryDesktop;
import org.scilab.forge.jlatexmath.geom.GeomFactoryDesktop;
import org.scilab.forge.jlatexmath.graphics.GraphicsFactoryDesktop;
import org.scilab.forge.jlatexmath.parser.ParserFactoryDesktop;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;
import org.scilab.forge.jlatexmath.resources.ResourceLoaderFactoryDesktop;

public class FactoryProviderDesktop extends FactoryProvider {
	
	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryDesktop();
	}
	
	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryDesktop();
	}
	
	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryDesktop();
	}
	
	@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryDesktop();
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryDesktop();
	}
}
