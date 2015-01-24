/* ScaleBox.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://forge.scilab.org/jlatexmath
 *
 * Copyright (C) 2009 DENIZET Calixte
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 *
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 *
 */

package org.scilab.forge.jlatexmath;

import java.util.Hashtable;
import java.util.Map;

import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

/**
 * A box representing a scaled box.
 */
public class JavaFontRenderingBox extends Box {
	
	private static final GraphicsFactory GRAPHICS_FACTORY = FactoryProvider.INSTANCE.getGraphicsFactory();
	private static final FontFactory FONT_FACTORY = FactoryProvider.INSTANCE.getFontFactory();

    private static final Graphics2DInterface TEMPGRAPHIC = GRAPHICS_FACTORY.createImage(1, 1, Image.TYPE_INT_ARGB).createGraphics2D();

    private static Font font = FONT_FACTORY.createFont("Serif", Font.PLAIN, 10);

    private String str;
    private TextLayout text;
    private float size;
    private static TextAttribute KERNING;
    private static Integer KERNING_ON;
    private static TextAttribute LIGATURES;
    private static Integer LIGATURES_ON;

    static {
    	TextAttributeProvider textAttributeProvider = FONT_FACTORY.createTextAttributeProvider();
        try { // to avoid problems with Java 1.5
            KERNING = textAttributeProvider.getTextAttribute("KERNING");
            KERNING_ON = textAttributeProvider.getTextAttributeValue("KERNING_ON");
            LIGATURES = textAttributeProvider.getTextAttribute("LIGATURES");
            LIGATURES_ON = textAttributeProvider.getTextAttributeValue("LIGATURES_ON");
        } catch (Exception e) { }
    }

    public JavaFontRenderingBox(String str, int type, float size, Font f, boolean kerning) {
        this.str = str;
        this.size = size;

        if (kerning && KERNING != null) {
            Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
            map.put(KERNING, KERNING_ON);
            map.put(LIGATURES, LIGATURES_ON);
            f = f.deriveFont(map);
        }

        this.text = FONT_FACTORY.createTextLayout(str, f.deriveFont(type), TEMPGRAPHIC.getFontRenderContext());
        Rectangle2D rect = text.getBounds();
        this.height = (float) (-rect.getY() * size / 10);
        this.depth = (float) (rect.getHeight() * size / 10) - this.height;
        this.width = (float) ((rect.getWidth() + rect.getX() + 0.4f) * size / 10);
    }

    public JavaFontRenderingBox(String str, int type, float size) {
        this(str, type, size, font, true);
    }

    public static void setFont(String name) {
        font = FONT_FACTORY.createFont(name, Font.PLAIN, 10);
    }

    public void draw(Graphics2DInterface g2, float x, float y) {
        drawDebug(g2, x, y);
        g2.translate(x, y);
        g2.scale(0.1 * size, 0.1 * size);
        text.draw(g2, 0, 0);
        g2.scale(10 / size, 10 / size);
        g2.translate(-x, -y);
    }

    public int getLastFontId() {
        return 0;
    }
}
