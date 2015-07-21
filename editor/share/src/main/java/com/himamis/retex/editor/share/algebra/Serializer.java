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

    void serialize(MathSequence sequence, StringBuilder buffer);

    void serialize(MathSequence sequence, StringBuilder buffer, int from, int to);

    void serialize(MathFunction function, StringBuilder buffer);

    void serialize(MathBraces braces, StringBuilder buffer);

    void serialize(MathArray array, StringBuilder buffer);
}
