package keyboard;

public interface HasKeyboard {

    /**
     * Displays the keyboard in an appropriate place on the screen.
     */
    void showKeyboard();

    /**
     * Hides the keyboard.
     */
    void hideKeyboard();

    /**
     * @return the keyboard implementation.
     */
    Keyboard getKeyboard();
}
