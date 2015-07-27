package com.himamis.retex.editor.share.algebra;

import com.himamis.retex.editor.share.model.MathArray;
import com.himamis.retex.editor.share.model.MathBraces;
import com.himamis.retex.editor.share.model.MathCharacter;
import com.himamis.retex.editor.share.model.MathComponent;
import com.himamis.retex.editor.share.model.MathFormula;
import com.himamis.retex.editor.share.model.MathFunction;
import com.himamis.retex.editor.share.model.MathSequence;

/**
 * Serializes the internal format into String format. See also {@link SerializerAdapter}.
 */
public interface Serializer {

    String serialize(MathFormula formula);

}
