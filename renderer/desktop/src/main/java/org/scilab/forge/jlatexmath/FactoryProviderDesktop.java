package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.font.FontFactoryDesktop;
import org.scilab.forge.jlatexmath.geom.GeomFactoryDesktop;
import org.scilab.forge.jlatexmath.graphics.GraphicsFactoryDesktop;
import org.scilab.forge.jlatexmath.parser.ParserFactoryDesktop;
import org.scilab.forge.jlatexmath.resources.ResourceLoaderFactoryDesktop;

import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;

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
