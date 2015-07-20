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
        return serialize(serializer, formula, null, 0);
    }

    public String serialize(Serializer serializer, MathContainer container, MathSequence currentField,
                            int currentOffset) {
        this.currentField = currentField;
        this.currentOffset = currentOffset;
        StringBuffer buffer = new StringBuffer();
        serializer.serialize(container, buffer);
        return buffer.toString();
    }

    public void serialize(MathCon)
}
