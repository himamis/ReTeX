/* JMathField.java
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
package com.himamis.retex.editor.share.editor;

import com.himamis.retex.editor.share.algebra.TeXSerializer;
import com.himamis.retex.editor.share.controller.MathInputController;
import com.himamis.retex.editor.share.event.ClickListener;
import com.himamis.retex.editor.share.event.FocusListener;
import com.himamis.retex.editor.share.event.KeyEvent;
import com.himamis.retex.editor.share.event.KeyListener;
import com.himamis.retex.editor.share.model.MathFormula;
import com.himamis.retex.editor.share.model.MathSequence;
import com.himamis.retex.renderer.share.TeXConstants;
import com.himamis.retex.renderer.share.TeXFormula;
import com.himamis.retex.renderer.share.TeXIcon;

/**
 * This class is a Math Field. Displays and allows to edit single formula.
 *
 * @author Bea Petrovicova
 */
public class MathFieldInternal {

    private TeXIcon renderer;
    private TeXSerializer serializer;
    private MathField mathField;
    private ClickListener clickListener = new ClickListener() {

        public void onClick() {
            mathField.requestViewFocus();

        }
    };
    private MathInputController controller = new MathInputController() {

        public void update(boolean focusEvent) {
            MathFieldInternal.this.update(focusEvent, currentField, currentOffset);
        }
    };
    FocusListener focusListener = new FocusListener() {

        public void onFocusLost() {
            update(true);
        }

        public void onFocusGained() {
            controller.update(true);
        }
    };
    private KeyListener keyListener = new KeyListener() {
        public boolean onKeyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            int modifiers = e.getKeyModifiers();
            // System.out.println("key_released: "+keyCode+", "+modifiers);
            return controller.keyPressed(keyCode, modifiers);
        }

        public boolean onKeyReleased(KeyEvent e) {
            // int keyCode = e.getKeyCode();
            // int modifiers = e.getModifiersEx();
            // System.out.println("key_released: "+keyCode+", "+modifiers);
            // controller.keyReleased(keyCode,modifiers);
            return false;
        }

        public boolean onKeyTyped(KeyEvent e) {
            char ch = e.getUnicodeKeyChar();
            // System.out.println("key_typed: "+ch+", "+modifiers);
            return controller.keyTyped(ch);
        }
    };

    private float size = 16;
    private int type = TeXFormula.SERIF;

    public MathFieldInternal() {
        serializer = new TeXSerializer();
    }

    public void setMathField(MathField mathField) {
        this.mathField = mathField;
        setupMathField();
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MathInputController getController() {
        return controller;
    }

    public MathFormula getFormula() {
        return controller.getFormula();
    }

    public void setFormula(MathFormula formula) {
        controller.setFormula(formula);
        if (mathField.hasFocus()) {
            controller.update(false);
        } else {
            update(false);
        }
    }

    private void setupMathField() {
        mathField.setFocusListener(focusListener);
        mathField.setClickListener(clickListener);
        mathField.setKeyListener(keyListener);
    }

    private void updateFormula(MathSequence currentField,
                               int currentOffset) {
        String serializedFormula = serializer.serialize(
                controller.getFormula(), currentField, currentOffset);

        TeXFormula texFormula = new TeXFormula(serializedFormula);
        renderer = texFormula.new TeXIconBuilder()
                .setStyle(TeXConstants.STYLE_DISPLAY).setSize(size).setType(type).build();
        mathField.setTeXIcon(renderer);
    }

    private void update(boolean focusEvent, MathSequence currentField, int currentOffset) {
        updateFormula(currentField, currentOffset);
        if (mathField.hasParent()) {
            if (!focusEvent) {
                // prevent infinite focusChanged <-> requestLayout event cycle
                mathField.requestLayout();
            }
            mathField.repaint();

        }
    }

    public void update(boolean focusEvent) {
        update(focusEvent, null, 0);
    }

}
