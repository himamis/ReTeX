package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Balazs on 7/23/2015.
 */
public class FunctionsAdapter implements KeyboardAdapter {

    @Override
    public void commit(MathController mathController, String input) {
        mathController.newFunction(input);
        mathController.update();
    }

    @Override
    public boolean test(String input) {
        return fnList.contains(input);
    }

    private static final List<String> fnList = Arrays.asList(new String[]{"sin", "cos", "tan", "ln", "log",
            "sinh", "cosh", "tanh"});
}
