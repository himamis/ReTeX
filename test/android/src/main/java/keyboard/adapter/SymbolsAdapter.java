package keyboard.adapter;

import com.himamis.retex.editor.share.controller.MathController;
import com.himamis.retex.editor.share.meta.MetaModel;

/**
 * Created by Balazs on 7/23/2015.
 */
public class SymbolsAdapter implements KeyboardAdapter {

    private MetaModel metaModel;

    public SymbolsAdapter(MetaModel metaModel) {
        this.metaModel = metaModel;
    }

    @Override
    public void commit(MathController mathController, String input) {
        mathController.keyTyped(input.charAt(0));
    }

    @Override
    public boolean test(String input) {
        return input.length() == 1 && metaModel.isSymbol(input);
    }
}
