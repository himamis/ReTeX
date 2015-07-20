package com.himamis.retex.editor.share.algebra;

import com.himamis.retex.editor.share.model.MathArray;
import com.himamis.retex.editor.share.model.MathBraces;
import com.himamis.retex.editor.share.model.MathCharacter;
import com.himamis.retex.editor.share.model.MathFunction;
import com.himamis.retex.editor.share.model.MathSequence;

/**
 * Created by Balazs on 7/20/2015.
 */
public interface Serializer {

    void serialize(MathCharacter mathCharacter, StringBuilder buffer);

    void serialize(MathSequence sequence, StringBuffer buffer);

    void serialize(MathSequence sequence, StringBuffer buffer, int from, int to);

    void serialize(MathFunction function, StringBuffer buffer);

    void serialize(MathBraces braces, StringBuffer buffer);

    void serialize(MathArray array, StringBuffer buffer);
}
