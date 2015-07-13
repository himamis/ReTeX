package com.himamis.retex.editor.desktop.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListenerAdapter extends MouseAdapter {

	private ClickListener clickListener;
	
	public ClickListenerAdapter(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		clickListener.onClick();
	}
}
