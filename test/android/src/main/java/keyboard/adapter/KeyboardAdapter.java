package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;

/**
 * Created by Balazs on 7/23/2015.
 */
public interface KeyboardAdapter {
    void commit(MathController mathController, String input);
    boolean test(String input);
}
