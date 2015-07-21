package com.himamis.retex.editor.share.algebra;

import com.himamis.retex.editor.share.model.MathContainer;
import com.himamis.retex.editor.share.model.MathFormula;
import com.himamis.retex.editor.share.model.MathSequence;

/**
 * Created by Balazs on 7/20/2015.
 */
public class SerializerAdapter {

    private MathSequence currentField = null;
    private int currentOffset = 0;

    public String serialize(Serializer serializer, MathFormula formula) {
        return serialize(serializer, formula.getRootComponent(), null, 0);
    }

    public String serialize(Serializer serializer, MathContainer container, MathSequence currentField,
                            int currentOffset) {
        this.currentField = currentField;
        this.currentOffset = currentOffset;
        StringBuilder buffer = new StringBuilder();
        container.serialize(serializer, buffer);
        return buffer.toString();
    }
}
