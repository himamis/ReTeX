package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;

/**
 * Created by Balazs on 7/23/2015.
 */
public class StringCharAdapter implements KeyboardAdapter {

    private final String string;
    private final char input;

    public StringCharAdapter(String string, char input) {
        this.string = string;
        this.input = input;
    }

    @Override
    public void commit(MathController mathController, String input) {
        mathController.keyTyped(this.input);
    }

    @Override
    public boolean test(String input) {
        return input.equals(string);
    }
}
