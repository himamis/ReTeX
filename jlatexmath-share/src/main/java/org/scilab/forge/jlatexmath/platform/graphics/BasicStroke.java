package org.scilab.forge.jlatexmath.platform.graphics;

import org.scilab.forge.jlatexmath.platform.NativeObject;

public interface BasicStroke extends NativeObject, Stroke {
	
	/**
     * Joins path segments by extending their outside edges until
     * they meet.
     */
    public final static int JOIN_MITER = 0;

    /**
     * Joins path segments by rounding off the corner at a radius
     * of half the line width.
     */
    public final static int JOIN_ROUND = 1;

    /**
     * Joins path segments by connecting the outer corners of their
     * wide outlines with a straight segment.
     */
    public final static int JOIN_BEVEL = 2;

    /**
     * Ends unclosed subpaths and dash segments with no added
     * decoration.
     */
    public final static int CAP_BUTT = 0;

    /**
     * Ends unclosed subpaths and dash segments with a round
     * decoration that has a radius equal to half of the width
     * of the pen.
     */
    public final static int CAP_ROUND = 1;

    /**
     * Ends unclosed subpaths and dash segments with a square
     * projection that extends beyond the end of the segment
     * to a distance equal to half of the line width.
     */
    public final static int CAP_SQUARE = 2;
	
}
