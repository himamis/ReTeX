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
package cz.natur.cuni.mirai.math.editor;

import java.awt.Dimension;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import cz.natur.cuni.mirai.math.algebra.TeXSerializer;
import cz.natur.cuni.mirai.math.controller.MathInputController;
import cz.natur.cuni.mirai.math.event.ClickListener;
import cz.natur.cuni.mirai.math.event.FocusListener;
import cz.natur.cuni.mirai.math.event.KeyEvent;
import cz.natur.cuni.mirai.math.event.KeyListener;
import cz.natur.cuni.mirai.math.model.MathFormula;
import cz.natur.cuni.mirai.math.model.MathSequence;

/**
 * This class is a Math Field. Displays and allows to edit single formula.
 * 
 * @author Bea Petrovicova
 */
public class MathFieldInternal {

	private TeXIcon renderer;
	private TeXSerializer serializer;
	private MathField mathField;

	FocusListener focusListener = new FocusListener() {

		public void onFocusLost() {
			controller.update();
		}

		public void onFocusGained() {
			update();
		}
	};

	private ClickListener clickListener = new ClickListener() {

		public void onClick() {
			mathField.requestFocus();

		}
	};

	private KeyListener keyListener = new KeyListener() {
		public void onKeyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			int modifiers = e.getKeyModifiers();
			// System.out.println("key_released: "+keyCode+", "+modifiers);
			controller.keyPressed(keyCode, modifiers);
		}

		public void onKeyReleased(KeyEvent e) {
			// int keyCode = e.getKeyCode();
			// int modifiers = e.getModifiersEx();
			// System.out.println("key_released: "+keyCode+", "+modifiers);
			// controller.keyReleased(keyCode,modifiers);
		}

		public void onKeyTyped(KeyEvent e) {
			char ch = e.getKeyChar();
			// System.out.println("key_typed: "+ch+", "+modifiers);
			controller.keyTyped(ch);
		}
	};

	private MathInputController controller = new MathInputController() {

		public void update() {
			MathFieldInternal.this.update(currentField, currentOffset);
		}
	};

	public MathFieldInternal() {
		serializer = new TeXSerializer();
	}

	public void setMathField(MathField mathField) {
		this.mathField = mathField;
		setupMathField();
	}

	public MathInputController getController() {
		return controller;
	}

	public MathFormula getFormula() {
		return controller.getFormula();
	}

	public void setFormula(MathFormula formula) {
		controller.setFormula(formula);
		getPreferredSize(null, 0);
	}
	
	private void setupMathField() {
		mathField.setFocusListener(focusListener);
		mathField.setClickListener(clickListener);
		mathField.setKeyListener(keyListener);
	}

	private Dimension getPreferredSize(MathSequence currentField,
			int currentOffset) {
		String serializedFormula = serializer.serialize(
				controller.getFormula(), currentField, currentOffset);
		// System.out.println("TeX> "+serializedFormula);
		TeXFormula texFormula = new TeXFormula(serializedFormula);
		renderer = texFormula.new TeXIconBuilder()
				.setStyle(TeXConstants.STYLE_DISPLAY).setSize(18).build();
		mathField.setTeXIcon(renderer);
		return new Dimension(renderer.getIconWidth(), renderer.getIconHeight());
	}

	private void update(MathSequence currentField, int currentOffset) {
		if (mathField.hasParent()) {
			getPreferredSize(currentField, currentOffset);
			mathField.repaint();
		}
	}

	public void update() {
		update(null, 0);
	}

}
