package com.himamis.retex.editor.share.algebra;

import com.himamis.retex.editor.share.meta.MetaModel;
import com.himamis.retex.editor.share.model.MathArray;
import com.himamis.retex.editor.share.model.MathBraces;
import com.himamis.retex.editor.share.model.MathCharacter;
import com.himamis.retex.editor.share.model.MathFunction;
import com.himamis.retex.editor.share.model.MathSequence;

/**
 * Serializes internal format into TeX format.
 */
public class TeXSerializer extends SerializerAdapter {

    private static final String cursor = "\\textcolor{red}{|}";

    private static final String latexFunctions[] = {"sin", "cos", "tan",
            "sec", "csc", "cot", "sinh", "cosh", "tanh", "coth", "lim",
            "limsup", "liminf", "min", "max", "sup", "exp", "ln", "lg", "log",
            "ker", "deg", "gcd", "det", "hom", "arg", "dim", "sum", "prod",
            "int", "pmod"};
    private static final String characterMissing = "\\nbsp ";
    private boolean jmathtex = true;

    @Override
    public void serialize(MathCharacter mathCharacter, StringBuilder buffer) {
        // jmathtex v0.7: incompatibility
        if (" ".equals(mathCharacter.getName())) {
            buffer.append((jmathtex ? "\\nbsp" : "\\ ") + " ");
        } else {
            buffer.append(mathCharacter.getTexName());
        }

        // safety space after operator / symbol
        if (mathCharacter.isOperator() || mathCharacter.isSymbol()) {
            buffer.append(' ');
        }
    }

    @Override
    public void serialize(MathSequence sequence, StringBuilder buffer) {
        boolean addBraces = (sequence.hasChildren() || // {a^b_c}
                sequence.size() > 1 || // {aa}
                (sequence.size() == 1 && letterLength(sequence, 0) > 1) || // {\pi}
                (sequence.size() == 0 && sequence != currentField) || // {\triangleright}
                (sequence.size() == 1 && sequence == currentField))
                && // {a|}
                (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) != '{');

        if (addBraces) {
            // when necessary add curly braces
            buffer.append('{');
        }

        if (sequence.size() == 0) {
            if (sequence == currentField) {
                buffer.append(cursor);
            } else {
                if (sequence.getParent() == null
                        || /* symbol.getParent() instanceof MathOperator || */
                        (sequence.getParent() instanceof MathFunction && sequence
                                .getParentIndex() == sequence.getParent()
                                .getInsertIndex())) {
                    buffer.append(characterMissing);
                } else {
                    buffer.append(characterMissing);
                }
            }
        } else {
            if (sequence == currentField) {
                if (currentOffset > 0) {
                    serialize(sequence, buffer, 0, currentOffset);
                }
                buffer.append(cursor);
                if (currentOffset < sequence.size()) {
                    serialize(sequence, buffer, currentOffset, sequence.size());
                }
            } else {
                serialize(sequence, buffer, 0, sequence.size());
            }
        }

        if (addBraces) {
            // when necessary add curly braces
            buffer.append('}');
        }
    }

    @Override
    public void serialize(MathSequence sequence, StringBuilder buffer, int from, int to) {
        for (int i = from; i < to; i++) {
            serialize(sequence.getArgument(i), buffer);
        }
    }

    @Override
    public void serialize(MathFunction function, StringBuilder buffer) {
        if (function.getFormula().getMetaModel().isGeneral(function.getName())) {

            if ("^".equals(function.getName())
                    || "_".equals(function.getName())) {
                MathSequence parent = (MathSequence) function.getParent();
                int index = function.getParentIndex();
                if (index == 0
                        || (index > 0
                        && parent.getArgument(index - 1) instanceof MathCharacter && ((MathCharacter) parent
                        .getArgument(index - 1)).isOperator())) {
                    buffer.append(characterMissing);
                }
                buffer.append(function.getName() + '{');
                serialize(function.getArgument(0), buffer);
                buffer.append('}');

            } else if ("frac".equals(function.getName())) {
                buffer.append("{" + function.getTexName());
                buffer.append("{");
                serialize(function.getArgument(0), buffer);
                buffer.append("}{");
                serialize(function.getArgument(1), buffer);
                buffer.append("}}");

            } else if ("sqrt".equals(function.getName())) {
                buffer.append(function.getTexName());
                buffer.append("{");
                serialize(function.getArgument(0), buffer);
                buffer.append("}");

            } else if ("nthroot".equals(function.getName())) {
                buffer.append(function.getTexName());
                buffer.append('[');
                serialize(function.getArgument(0), buffer);
                buffer.append("]{");
                serialize(function.getArgument(1), buffer);
                buffer.append('}');

            } else if ("sum".equals(function.getName())
                    || "prod".equals(function.getName())) {
                buffer.append(function.getTexName());
                buffer.append("_{");
                serialize(function.getArgument(0), buffer);
                buffer.append('=');
                serialize(function.getArgument(1), buffer);
                buffer.append("}^");
                serialize(function.getArgument(2), buffer);
                boolean addBraces = currentBraces
                        || (function.getArgument(3).hasOperator());
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(3), buffer);
                if (addBraces) {
                    buffer.append(')');
                }

            } else if ("nsum".equals(function.getName())
                    || "nprod".equals(function.getName())) {
                buffer.append(function.getTexName());
                buffer.append("_{");
                serialize(function.getArgument(0), buffer);
                buffer.append('=');
                serialize(function.getArgument(1), buffer);
                buffer.append('}');
                boolean addBraces = currentBraces
                        || (function.getArgument(2).hasOperator());
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(2), buffer);
                if (addBraces) {
                    buffer.append(')');
                }

            } else if ("int".equals(function.getName())) {
                buffer.append(function.getTexName());
                buffer.append('_');
                serialize(function.getArgument(0), buffer);
                buffer.append('^');
                serialize(function.getArgument(1), buffer);
                buffer.append('{');
                boolean addBraces = currentBraces;
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(2), buffer);
                // jmathtex v0.7: incompatibility
                buffer.append(" " + (jmathtex ? "\\nbsp" : "\\ ") + " d");
                serialize(function.getArgument(3), buffer);
                if (addBraces) {
                    buffer.append(')');
                }
                buffer.append('}');

            } else if ("nint".equals(function.getName())) {
                buffer.append(function.getTexName());
                buffer.append((jmathtex ? "_{\\nbsp}" : "") + "{");
                boolean addBraces = currentBraces;
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(0), buffer);
                // jmathtex v0.7: incompatibility
                buffer.append(" " + (jmathtex ? "\\nbsp" : "\\ ") + " d");
                serialize(function.getArgument(1), buffer);
                if (addBraces) {
                    buffer.append(')');
                }
                buffer.append('}');

            } else if ("lim".equals(function.getName())) {
                // lim not implemented in jmathtex
                if (!jmathtex) {
                    buffer.append("\\");
                }
                buffer.append(function.getTexName());
                buffer.append("_{");
                serialize(function.getArgument(0), buffer);
                buffer.append(" \\rightarrow ");
                serialize(function.getArgument(1), buffer);
                // jmathtex v0.7: incompatibility
                buffer.append("} " + (jmathtex ? "\\nbsp" : "\\ ") + " {");
                boolean addBraces = currentBraces
                        || (function.getArgument(2).hasOperator() && function
                        .getParent().hasOperator());
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(2), buffer);
                if (addBraces) {
                    buffer.append(')');
                }
                buffer.append('}');

            } else if ("factorial".equals(function.getName())) {
                boolean addBraces = currentBraces
                        || function.getArgument(0).hasOperator();
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(0), buffer);
                if (addBraces) {
                    buffer.append(')');
                }
                buffer.append(function.getTexName());

            } else if ("function".equals(function.getName())) {
                buffer.append("\\mathrm{" + function.getTexName() + "} ");
                // jmathtex v0.7: incompatibility
                buffer.append((jmathtex ? "\\nbsp" : "\\ ") + " ");
                serialize(function.getArgument(0), buffer);
                buffer.append('(');
                serialize(function.getArgument(1), buffer);
                buffer.append(")=");
                boolean addBraces = currentBraces
                        || (function.getArgument(2).hasOperator() && function
                        .getParent().hasOperator());
                if (addBraces) {
                    buffer.append('(');
                }
                serialize(function.getArgument(2), buffer);
                if (addBraces) {
                    buffer.append(')');
                }
            }
        } else {
            if (!jmathtex && isLatexFunction(function.getTexName())) {
                buffer.append("{\\" + function.getTexName() + "(");
            } else {
                buffer.append("{\\mathrm{" + function.getTexName() + "}(");
            }
            for (int i = 0; i < function.size(); i++) {
                serialize(function.getArgument(i), buffer);
                if (i + 1 < function.size()) {
                    buffer.append(",");
                }
            }
            buffer.append(")}");
        }
    }

    @Override
    public void serialize(MathBraces braces, StringBuilder buffer) {
        if (braces.getClassif() == MathBraces.REGULAR) {
            buffer.append("\\left(");
            serialize(braces.getArgument(0), buffer);
            buffer.append("\\right)");

        } else if (braces.getClassif() == MathBraces.SQUARE) {
            buffer.append("\\left[");
            serialize(braces.getArgument(0), buffer);
            buffer.append("\\right]");

        } else if (braces.getClassif() == MathBraces.CURLY) {
            buffer.append("\\lbrace");
            serialize(braces.getArgument(0), buffer);
            buffer.append("\\rbrace");

        } else if (braces.getClassif() == MathBraces.APOSTROPHES) {
            buffer.append("\"");
            serialize(braces.getArgument(0), buffer);
            buffer.append("\"");

        } else {
            throw new ArrayIndexOutOfBoundsException("Unsupported function "
                    + braces.getClassif());
        }
    }

    @Override
    public void serialize(MathArray array, StringBuilder buffer) {
        if (jmathtex && MetaModel.MATRIX.equals(array.getName())) {
            // jmathlib does not implement matrix
            buffer.append(array.getOpen().getCasName());
            for (int i = 0; i < array.rows(); i++) {
                for (int j = 0; j < array.columns(); j++) {
                    serialize(array.getArgument(i, j), buffer);
                    if (j + 1 < array.columns()) {
                        buffer.append(array.getField().getCasName());
                    } else if (i + 1 < array.rows()) {
                        buffer.append(array.getRow().getCasName());
                    }
                }
            }
            buffer.append(array.getClose().getCasName());

        } else {
            buffer.append(array.getOpen().getTexName());
            for (int i = 0; i < array.rows(); i++) {
                for (int j = 0; j < array.columns(); j++) {
                    serialize(array.getArgument(i, j), buffer);
                    if (j + 1 < array.columns()) {
                        buffer.append(array.getField().getTexName());
                    } else if (i + 1 < array.rows()) {
                        buffer.append(array.getRow().getTexName());
                    }
                }
            }
            buffer.append(array.getClose().getTexName());
        }
    }

    private int letterLength(MathSequence symbol, int i) {
        if (symbol.getArgument(i) instanceof MathCharacter) {
            return ((MathCharacter) symbol.getArgument(i)).getTexName()
                    .length();
        } else {
            return 2;
        }
    }

    private boolean isLatexFunction(String texName) {
        for (int i = 0; i < latexFunctions.length; i++) {
            if (latexFunctions[i].equals(texName)) {
                return true;
            } else if (texName.length() > latexFunctions[i].length() + 1
                    && texName.startsWith(latexFunctions[i])
                    && (texName.charAt(latexFunctions[i].length()) == ' '
                    || texName.charAt(latexFunctions[i].length()) == '^'
                    || texName.charAt(latexFunctions[i].length()) == '_' || texName
                    .charAt(latexFunctions[i].length()) == '{')) {
                return true;
            }
        }
        return false;
    }
}
