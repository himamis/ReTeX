package com.himamis.retex.editor.desktop.editor;

import org.scilab.forge.jlatexmath.TeXIcon;

import com.himamis.retex.editor.desktop.event.ClickListener;
import com.himamis.retex.editor.desktop.event.FocusListener;
import com.himamis.retex.editor.desktop.event.KeyListener;

public interface MathField {
	
	void setTeXIcon(TeXIcon icon);

	void requestViewFocus();
	
	void setFocusListener(FocusListener focusListener);
	
	void setClickListener(ClickListener clickListener);
	
	void setKeyListener(KeyListener keyListener);
	
	void repaint();
	
	boolean hasParent();
}
