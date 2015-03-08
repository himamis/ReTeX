package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.geom.GeomFactoryGWT;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;

public class FactoryProviderGWT extends FactoryProvider {

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryGWT();
	}

	@Override
	protected FontFactory createFontFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ParserFactory createParserFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
