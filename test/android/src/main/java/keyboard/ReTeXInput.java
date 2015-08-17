package keyboard;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import com.himamis.retex.editor.android.FormulaEditor;
import com.himamis.retex.editor.share.model.MathFormula;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.UiThread;

@EView
public class ReTeXInput extends FormulaEditor implements Keyboard.MathKeyboardListener {

    @Bean
    protected KeyboardController mKeyboardController;

    public ReTeXInput(Context context) {
        super(context);
    }

    public ReTeXInput(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReTeXInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return false;
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return null;
    }

    @Override
    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void onEnter() {
        MathFormula mathFormula = mMathFieldInternal.getFormula();
        String string = mathFormula.toString();
        int x = 2;
    }

    @Override
    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void onBackSpace() {
        KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL);
        dispatchKeyEvent(keyEvent);
    }

    @Override
    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void onArrow(int type) {
        int direction = 0;
        switch (type) {
            case 0:
                direction = KeyEvent.KEYCODE_DPAD_LEFT;
                break;
            case 1:
                direction = KeyEvent.KEYCODE_DPAD_RIGHT;
                break;
        }
        KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, direction);
        dispatchKeyEvent(keyEvent);
    }

    @Override
    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void insertString(final String text) {
        KeyboardInputAdapter.onKeyboardInput(mMathFieldInternal.getController(), text);
    }

    @Override
    public void scrollCursorIntoView() {
        // alright
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus) {
            mKeyboardController.showKeyboard(this);
        }
    }
}
