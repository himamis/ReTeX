package com.himamis.retex.editor.desktop.event;

import com.himamis.retex.editor.share.event.FocusListener;

import java.awt.event.FocusEvent;

public class FocusListenerAdapter implements java.awt.event.FocusListener {
	
	private FocusListener focusListener;
	
	public FocusListenerAdapter(FocusListener focusListener) {
		this.focusListener = focusListener;
	}

	@Override
	public void focusGained(FocusEvent e) {
		focusListener.onFocusGained();
	}

	@Override
	public void focusLost(FocusEvent e) {
		focusListener.onFocusLost();
	}
	
}
