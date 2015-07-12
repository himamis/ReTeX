package cz.natur.cuni.mirai.math.desktop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;

import org.scilab.forge.jlatexmath.IconHelper;
import org.scilab.forge.jlatexmath.TeXIcon;

import cz.natur.cuni.mirai.math.desktop.event.ClickListenerAdapter;
import cz.natur.cuni.mirai.math.desktop.event.FocusListenerAdapter;
import cz.natur.cuni.mirai.math.desktop.event.KeyListenerAdapter;
import cz.natur.cuni.mirai.math.editor.MathField;
import cz.natur.cuni.mirai.math.editor.MathFieldInternal;
import cz.natur.cuni.mirai.math.event.ClickListener;
import cz.natur.cuni.mirai.math.event.FocusListener;
import cz.natur.cuni.mirai.math.event.KeyListener;
import cz.natur.cuni.mirai.math.meta.MetaModel;
import cz.natur.cuni.mirai.math.model.MathFormula;

public class MathFieldD extends JLabel implements MathField {
	
	private static final MetaModel metaModel;
	
	static {
		metaModel = new MetaModel("octave.xml");
	}

	private static final long serialVersionUID = 1L;
	
	private MathFieldInternal mathFieldInternal;

	public MathFieldD() {
		setBackground(Color.white);
		setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		mathFieldInternal = new MathFieldInternal();
		mathFieldInternal.setMathField(this);
		mathFieldInternal.setFormula(MathFormula.newFormula(metaModel));
	}
	
	public MathFieldD(String latex) {
		
	}

	@Override
	public void setTeXIcon(TeXIcon icon) {
		setIcon(IconHelper.createIcon(icon));
		setFocusTraversalKeysEnabled(true);
		setFocusable(true);
		setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
	}

	@Override
	public void setFocusListener(FocusListener focusListener) {
		addFocusListener(new FocusListenerAdapter(focusListener));
	}

	@Override
	public void setClickListener(ClickListener clickListener) {
		addMouseListener(new ClickListenerAdapter(clickListener));
	}

	@Override
	public void setKeyListener(KeyListener keyListener) {
		addKeyListener(new KeyListenerAdapter(keyListener));
	}

	@Override
	public boolean hasParent() {
		return getParent() != null;
	}

	@Override
	public void requestViewFocus() {
		requestFocus();
	}
}
