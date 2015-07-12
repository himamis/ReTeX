package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.font.FontFactoryGWT;
import org.scilab.forge.jlatexmath.geom.GeomFactoryGWT;
import org.scilab.forge.jlatexmath.graphics.GraphicsFactoryGWT;
import org.scilab.forge.jlatexmath.parser.ParserFactoryGWT;
import org.scilab.forge.jlatexmath.resources.ResourceLoaderFactoryGWT;

import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;

public class FactoryProviderGWT extends FactoryProvider {

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryGWT();
	}

	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryGWT();
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryGWT();
	}

	@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryGWT();
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryGWT();
	}

}
