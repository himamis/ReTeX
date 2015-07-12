package cz.natur.cuni.mirai.math.android.event;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;

import cz.natur.cuni.mirai.math.event.KeyListener;

public class KeyListenerAdapter implements View.OnKeyListener {

    private KeyListener mKeyListener;

    public KeyListenerAdapter(KeyListener keyListener) {
        mKeyListener = keyListener;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (event.getAction()) {
            case KeyEvent.ACTION_DOWN:
                mKeyListener.onKeyPressed(wrapEvent(event));
                break;
            case KeyEvent.ACTION_UP:
            case KeyEvent.ACTION_MULTIPLE:
                mKeyListener.onKeyReleased(wrapEvent(event));
                mKeyListener.onKeyTyped(wrapEvent(event));
        }
        return true;
    }

    private static cz.natur.cuni.mirai.math.event.KeyEvent wrapEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        char charCode = (char) keyEvent.getUnicodeChar();
        int modifiers = getModifiers(keyEvent);
        return new cz.natur.cuni.mirai.math.event.KeyEvent(keyCode, modifiers, charCode);
    }

    private static int getModifiers(KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 13) {
            // TODO use the same modifiers as in natur/cuni... KeyEvent
            return keyEvent.getModifiers();
        }
        // TODO ?
        return 0;
    }
}
