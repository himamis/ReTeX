package cz.natur.cuni.mirai.math.editor;

import org.scilab.forge.jlatexmath.TeXIcon;

import cz.natur.cuni.mirai.math.event.ClickListener;
import cz.natur.cuni.mirai.math.event.FocusListener;
import cz.natur.cuni.mirai.math.event.KeyListener;

public interface MathField {
	
	void setTeXIcon(TeXIcon icon);

	void requestViewFocus();
	
	void setFocusListener(FocusListener focusListener);
	
	void setClickListener(ClickListener clickListener);
	
	void setKeyListener(KeyListener keyListener);
	
	void repaint();
	
	boolean hasParent();
}
