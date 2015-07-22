/* MathFormula.java
 * =========================================================================
 * This file is part of the Mirai Math TN - http://mirai.sourceforge.net
 *
 * Copyright (C) 2008-2009 Bea Petrovicova
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
package com.himamis.retex.editor.share.model;

import com.himamis.retex.editor.share.algebra.TextParser;
import com.himamis.retex.editor.share.meta.MetaModel;

public class MathFormula {

    private static final TextParser PARSER = new TextParser();

    private MetaModel metaModel;
    private MathSequence rootContainer;

    public MathFormula(MetaModel metaModel) {
        this.metaModel = metaModel;
    }

    public static MathFormula newFormula(MetaModel metaModel) {
        MathFormula newFormula = new MathFormula(metaModel);
        newFormula.setRootComponent(new MathSequence(newFormula));
        return newFormula;
    }

    public static MathFormula newFormula(MetaModel metaModel, String text) {
        if (text == null) {
            return newFormula(metaModel);
        }
        return PARSER.parseText(metaModel, text);
    }

    /**
     * MetaModel
     */
    public MetaModel getMetaModel() {
        return metaModel;
    }

    public MathSequence getRootComponent() {
        return rootContainer;
    }

    public void setRootComponent(MathSequence rootContainer) {
        this.rootContainer = rootContainer;
        rootContainer.setParent(null);
    }

}
