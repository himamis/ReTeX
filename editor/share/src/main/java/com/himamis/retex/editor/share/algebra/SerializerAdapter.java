package com.himamis.retex.editor.share.algebra;

import com.himamis.retex.editor.share.model.MathArray;
import com.himamis.retex.editor.share.model.MathBraces;
import com.himamis.retex.editor.share.model.MathCharacter;
import com.himamis.retex.editor.share.model.MathComponent;
import com.himamis.retex.editor.share.model.MathContainer;
import com.himamis.retex.editor.share.model.MathFormula;
import com.himamis.retex.editor.share.model.MathFunction;
import com.himamis.retex.editor.share.model.MathSequence;

/**
 * Created by Balazs on 7/20/2015.
 */
public abstract class SerializerAdapter implements Serializer{

    protected MathSequence currentField = null;
    protected int currentOffset = 0;
    protected boolean currentBraces = true;

    public String serialize(MathFormula formula) {
        return serialize(formula, null, 0);
    }

    public String serialize(MathFormula formula, MathSequence currentField,
                            int currentOffset) {
        this.currentField = currentField;
        this.currentOffset = currentOffset;
        currentBraces = currentField != null;
        StringBuilder buffer = new StringBuilder();
        serialize(formula.getRootComponent(), buffer);
        return buffer.toString();
    }

    public String serialize(MathContainer container, MathSequence currentField,
                            int currentOffset) {
        this.currentField = currentField;
        this.currentOffset = currentOffset;
        StringBuilder buffer = new StringBuilder();
        serialize(container, buffer);
        return buffer.toString();
    }

    @Override
    public void serialize(MathComponent container, StringBuilder buffer) {
        if (container instanceof MathCharacter) {
            serialize((MathCharacter) container, buffer);

        } else if (container instanceof MathSequence) {
            serialize((MathSequence) container, buffer);

        } else if (container instanceof MathArray) {
            serialize((MathArray) container, buffer);

        } else if (container instanceof MathBraces) {
            serialize((MathBraces) container, buffer);

        } else if (container instanceof MathFunction) {
            serialize((MathFunction) container, buffer);
        }
    }
}
