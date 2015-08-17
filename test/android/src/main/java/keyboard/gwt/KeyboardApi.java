package keyboard.gwt;

import android.webkit.JavascriptInterface;

import keyboard.Keyboard;

public class KeyboardApi {

    private Keyboard.MathKeyboardListener mMathKeyboardListener;

    public void setMathKeyboardListener(Keyboard.MathKeyboardListener mathKeyboardListener) {
        mMathKeyboardListener = mathKeyboardListener;
    }

    @JavascriptInterface
    public void onEnter() {
        if (mMathKeyboardListener != null) {
            mMathKeyboardListener.onEnter();
        }
    }

    @JavascriptInterface
    public void onBackSpace() {
        if (mMathKeyboardListener != null) {
            mMathKeyboardListener.onBackSpace();
        }
    }


    @JavascriptInterface
    public void onArrow(int type) {
        if (mMathKeyboardListener != null) {
            mMathKeyboardListener.onArrow(type);
        }
    }

    @JavascriptInterface
    public void insertString(String text) {
        if (mMathKeyboardListener != null) {
            mMathKeyboardListener.insertString(text);
        }
    }

    @JavascriptInterface
    public void scrollCursorIntoView() {
        if (mMathKeyboardListener != null) {
            mMathKeyboardListener.scrollCursorIntoView();
        }
    }
}
