package cz.natur.cuni.mirai.math.event;

public interface KeyListener {

	void onKeyPressed(KeyEvent keyEvent);
	
	void onKeyReleased(KeyEvent keyEvent);
	
	void onKeyTyped(KeyEvent keyEvent);
}
