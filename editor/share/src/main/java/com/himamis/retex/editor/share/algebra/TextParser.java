package com.himamis.retex.editor.share.algebra;

import com.himamis.retex.editor.share.controller.MathController;
import com.himamis.retex.editor.share.meta.MetaModel;
import com.himamis.retex.editor.share.model.MathFormula;

/**
 * Created by Balazs on 7/22/2015.
 */
public class TextParser {

    public MathFormula parseText(MetaModel model , String text) {
        MathFormula formula = MathFormula.newFormula(model);
        MathController controller = new MathController() {
            @Override
            public void update() {
                // noop
            }
        };

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            controller.keyTyped(character);
        }

        return formula;
    }
}
