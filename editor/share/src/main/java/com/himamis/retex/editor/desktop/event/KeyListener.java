package com.himamis.retex.editor.desktop.event;

public interface KeyListener {

	void onKeyPressed(KeyEvent keyEvent);
	
	void onKeyReleased(KeyEvent keyEvent);
	
	void onKeyTyped(KeyEvent keyEvent);
}
