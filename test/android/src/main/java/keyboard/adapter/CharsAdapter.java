package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Balazs on 7/23/2015.
 */
public class CharsAdapter implements KeyboardAdapter {

    private static final List<Character> extraChars = Arrays.asList('=', '>', '<', '.', ',');

    @Override
    public void commit(MathController mathController, String input) {
        mathController.keyTyped(input.charAt(0));
    }

    @Override
    public boolean test(String input) {
        return input.length() == 1 && (Character.isLetter(input.charAt(0))
                || Character.isDigit(input.charAt(0)) || extraChars.contains(input.charAt(0)));
    }

}
