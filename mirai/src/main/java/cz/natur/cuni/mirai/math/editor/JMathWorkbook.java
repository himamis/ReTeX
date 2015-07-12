/* JMathWorkbook.java
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;

import cz.natur.cuni.mirai.math.controller.MathInputController;
import cz.natur.cuni.mirai.math.model.MathFormula;
import cz.natur.cuni.mirai.math.model.MathModel;

public class JMathWorkbook {

	private MathModel model;
	private JMathField current = null;
	private Font font;

	private KeyAdapter keyListener = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			// int modifiers = e.getModifiersEx();
			// System.out.println("key_released: "+keyCode+", "+modifiers);
			JMathField field = (JMathField) e.getComponent();
			MathFormula formula = field.getFormula();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				MathInputController controller = field.getController();
				if (controller.upField()) {
					// Update current formula
					controller.update();
				} else {
					if (model.hasPrevFormula(formula.getModelIndex())) {
						int i = model.prevFormula(formula.getModelIndex());
					}
				}
				break;
			case KeyEvent.VK_DOWN:
				controller = field.getController();
				if (controller.downField()) {
					// Update current formula
					controller.update();
				} else {
					if (model.hasNextFormula(formula.getModelIndex())) {
						int i = model.nextFormula(formula.getModelIndex());
					}
				}
				break;
			case KeyEvent.VK_DELETE:
				if (formula.getRootComponent().size() == 0
						&& model.hasNextFormula(formula.getModelIndex())) {
					// select next formula
					int i = model.nextFormula(formula.getModelIndex());
					// delete current formula
					i = formula.getModelIndex();
					model.removeResults(i);
					model.removeElements(i, i);
				} else {
					controller = field.getController();
					controller.delCharacter();
					controller.update();
				}
				break;
			case KeyEvent.VK_BACK_SPACE:
				if (formula.getRootComponent().size() == 0
						&& model.hasPrevFormula(formula.getModelIndex())) {
					// select previous formula
					int i = model.prevFormula(formula.getModelIndex());
					// delete current formula
					i = formula.getModelIndex();
					model.removeResults(i);
					model.removeElements(i, i);
				} else {
					controller = field.getController();
					controller.bkspCharacter();
					controller.update();
				}
				break;

			case KeyEvent.VK_ENTER:

				break;
			}
		}

		public void keyReleased(KeyEvent e) {

		}
	};

	public void detachModel() {
		if (model != null) {
			model.replaceElementList();
		}
	}

	public MathModel getModel() {
		return model;
	}

	public MathInputController getController() {
		return current.getController();
	}

	/** Add element (override to add new type). */
	private void addElement(int i, Object element) {
		if (element instanceof MathFormula) {
			addFormula(i, (MathFormula) element);
		} else if (element instanceof String) {
			addLabel(i, (String) element);
		}
	}

	private void addLabel(int i, String output) {
		JLabel label = new JLabel();
		label.setText(output);
		if (font == null) {
			font = label.getFont().deriveFont(8);
		}
		label.setFont(font);
		label.putClientProperty("model", output);
	}

	private void addFormula(int i, MathFormula formula) {
		JMathField field = new JMathField();
		field.addKeyListener(keyListener);
		field.setFormula(formula);
		field.putClientProperty("model", formula);
	}

	private static final long serialVersionUID = 1L;

}
