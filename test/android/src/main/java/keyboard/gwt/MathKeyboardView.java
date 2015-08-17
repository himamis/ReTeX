package keyboard.gwt;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import java.util.Locale;

import keyboard.Keyboard;

public class MathKeyboardView extends WebView implements Keyboard {

    private KeyboardApi mKeyboardApi;

    public MathKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setupView();
        loadKeyboard();
    }

    private void setupView() {
        getSettings().setJavaScriptEnabled(true);

        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    private void loadKeyboard() {
        mKeyboardApi = new KeyboardApi();
        loadUrl("file:///android_asset/keyboard/keyboard.html?language=" + Locale.getDefault().getDisplayLanguage());
        addJavascriptInterface(mKeyboardApi, "androidKeyboard");
    }

    @Override
    public void setMathKeyboardListener(Keyboard.MathKeyboardListener mathKeyboardListener) {
        mKeyboardApi.setMathKeyboardListener(mathKeyboardListener);
    }

    @Override
    public boolean canGoBack() {
        return false;
    }
}
