package cz.natur.cuni.mirai.math.desktop.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cz.natur.cuni.mirai.math.event.ClickListener;

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
