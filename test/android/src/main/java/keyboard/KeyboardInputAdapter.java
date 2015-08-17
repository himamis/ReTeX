package keyboard;

import android.util.Log;

import com.himamis.retex.editor.share.controller.MathController;

import java.util.ArrayList;
import java.util.List;

import keyboard.adapter.CharAdapter;
import keyboard.adapter.FunctionsAdapter;
import keyboard.adapter.KeyboardAdapter;
import keyboard.adapter.StringAdapter;
import keyboard.adapter.StringCharAdapter;

/**
 * Created by Balazs on 7/23/2015.
 */
public class KeyboardInputAdapter {


    private static final List<KeyboardAdapter> adapters;

    static {
        adapters = new ArrayList<>();
        adapters.add(new FunctionsAdapter());
        //adapters.add(new CharsAdapter());
        adapters.add(new CharAdapter('÷', '\\'));
        adapters.add(new CharAdapter('×', '*'));
        adapters.add(new CharAdapter('−', '-'));
        //adapters.add(new CharAdapter('+'));
        adapters.add(new StringCharAdapter("a^x", '^'));
        adapters.add(new StringCharAdapter("()", '('));
        adapters.add(new StringCharAdapter("abs", '|'));
        adapters.add(new StringCharAdapter("quotes", '"'));
        adapters.add(new StringAdapter("asin", "arcsin"));
        adapters.add(new StringAdapter("acos", "arccos"));
        adapters.add(new StringAdapter("atan", "arctan"));
        adapters.add(new KeyboardAdapter() {
            @Override
            public void commit(MathController mathController, String input) {
                mathController.keyTyped('^');
                mathController.keyTyped('2');
                mathController.nextCharacter();
            }

            @Override
            public boolean test(String input) {
                return input.equals("\u00B2");
            }
        });
        adapters.add(new KeyboardAdapter() {
            @Override
            public void commit(MathController mathController, String input) {
                mathController.newFunction("sqrt");
            }

            @Override
            public boolean test(String input) {
                return input.equals("\u221A");
            }
        });
        adapters.add(new KeyboardAdapter() {
            @Override
            public void commit(MathController mathController, String input) {
                mathController.keyTyped('ℯ');
                mathController.keyTyped('^');
                mathController.update();
            }

            @Override
            public boolean test(String input) {
                return "ℯ^".equals(input);
            }
        });
        adapters.add(new KeyboardAdapter() {
            @Override
            public void commit(MathController mathController, String input) {
                mathController.newFunction("nthroot", 0);
            }

            @Override
            public boolean test(String input) {
                return "nroot".equals(input);
            }
        });

        // Let through all one length characters!
        adapters.add(new KeyboardAdapter() {
            @Override
            public void commit(MathController mathController, String input) {
                mathController.keyTyped(input.charAt(0));
            }

            @Override
            public boolean test(String input) {
                return input.length() == 1;
            }
        });
    }

    public static void onKeyboardInput(MathController mathController, String input) {
        if (input == null) {
            return;
        }
        Log.e("KeyboardInputAdapter", input);

        int i = 0;
        while (i < adapters.size() && !adapters.get(i).test(input)) i++;

        if (i < adapters.size()) {
            KeyboardAdapter adapter = adapters.get(i);
            adapter.commit(mathController, input);
            mathController.update();
        } else {
            Log.e("KeyboardInputAdapter", "No adapter found");
        }
    }

}
