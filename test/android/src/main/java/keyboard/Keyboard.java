package keyboard;

public interface Keyboard {

    void setMathKeyboardListener(MathKeyboardListener mathKeyboardListener);

    /**
     * Keyboard action callback definition.
     */
    interface MathKeyboardListener {

        void onEnter();

        void onBackSpace();

        void onArrow(int type);

        void insertString(String text);

        void scrollCursorIntoView();
    }
}
