package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;

/**
 * Created by Balazs on 7/23/2015.
 */
public class CharAdapter implements KeyboardAdapter {

    private final char keyboard;
    private final char input;

    public CharAdapter(char keyboard) {
        this(keyboard, keyboard);
    }

    public CharAdapter(char keyboard, char input) {
        this.keyboard = keyboard;
        this.input = input;
    }

    @Override
    public void commit(MathController mathController, String input) {
        mathController.keyTyped(this.input);
    }

    @Override
    public boolean test(String input) {
        return input.length() == 1 && input.charAt(0) == keyboard;
    }
}
