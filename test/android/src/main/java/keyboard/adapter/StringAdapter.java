package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;

/**
 * Created by Balazs on 7/24/2015.
 */
public class StringAdapter implements KeyboardAdapter {

    private final String input;
    private final String keyboard;

    public StringAdapter(String input, String keyboard) {
        this.input = input;
        this.keyboard = keyboard;
    }

    @Override
    public void commit(MathController mathController, String input) {
        mathController.newFunction(this.input);
    }

    @Override
    public boolean test(String input) {
        return keyboard.equals(input);
    }
}
