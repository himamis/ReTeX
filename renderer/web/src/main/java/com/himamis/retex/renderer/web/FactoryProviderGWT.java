package com.himamis.retex.renderer.web;

import com.himamis.retex.renderer.share.platform.FactoryProvider;
import com.himamis.retex.renderer.share.platform.font.FontFactory;
import com.himamis.retex.renderer.share.platform.geom.GeomFactory;
import com.himamis.retex.renderer.share.platform.graphics.GraphicsFactory;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;
import com.himamis.retex.renderer.share.platform.resources.ResourceLoaderFactory;
import com.himamis.retex.renderer.web.font.FontFactoryGWT;
import com.himamis.retex.renderer.web.geom.GeomFactoryGWT;
import com.himamis.retex.renderer.web.graphics.GraphicsFactoryGWT;
import com.himamis.retex.renderer.web.parser.ParserFactoryGWT;
import com.himamis.retex.renderer.web.resources.ResourceLoaderFactoryGWT;

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
