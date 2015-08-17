package keyboard;

import android.content.Context;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class KeyboardController {

    @RootContext
    protected Context mContext;

    private HasKeyboard mHasKeyboard;

    @AfterInject
    protected void setupBean() {
        if (!(mContext instanceof HasKeyboard)) {
            throw new RuntimeException("Cannot instantiate a keyboard controller in a context " +
                    "without a keyboard. Please see HasKeyboard interface.");
        }
        mHasKeyboard = (HasKeyboard) mContext;
    }

    public void showKeyboard(Keyboard.MathKeyboardListener mathKeyboardListener) {
        Keyboard keyboard = mHasKeyboard.getKeyboard();
        keyboard.setMathKeyboardListener(mathKeyboardListener);
        mHasKeyboard.showKeyboard();
    }

    public void hideKeyboard() {
        mHasKeyboard.hideKeyboard();
    }
}
