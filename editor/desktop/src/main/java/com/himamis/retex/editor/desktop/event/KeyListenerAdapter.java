package com.himamis.retex.editor.desktop.event;

import java.awt.event.KeyEvent;

public class KeyListenerAdapter implements java.awt.event.KeyListener {
	
	private KeyListener keyListener;
	
	public KeyListenerAdapter(KeyListener keyListener) {
		this.keyListener = keyListener;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyListener.onKeyTyped(wrapEvent(e));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyListener.onKeyPressed(wrapEvent(e));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyListener.onKeyReleased(wrapEvent(e));
	}
	
	private static com.himamis.retex.editor.desktop.event.KeyEvent wrapEvent(java.awt.event.KeyEvent event) {
		int keyCode = event.getKeyCode();
		int keyModifiers = event.getModifiers();
		char charCode = event.getKeyChar();
		return new com.himamis.retex.editor.desktop.event.KeyEvent(keyCode, keyModifiers, charCode);
	}

}
