package cz.natur.cuni.mirai.math.desktop.event;

import java.awt.event.FocusEvent;

import cz.natur.cuni.mirai.math.event.FocusListener;

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
