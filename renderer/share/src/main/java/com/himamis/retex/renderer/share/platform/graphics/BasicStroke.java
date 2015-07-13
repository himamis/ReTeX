/**
 * This file is part of the ReTeX library - https://github.com/himamis/ReTeX
 *
 * Copyright (C) 2015 Balazs Bencze
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 *
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package com.himamis.retex.renderer.share.platform.graphics;

public interface BasicStroke extends Stroke {

	/**
	 * Joins path segments by extending their outside edges until they meet.
	 */
	public final static int JOIN_MITER = 0;

	/**
	 * Joins path segments by rounding off the corner at a radius of half the line width.
	 */
	public final static int JOIN_ROUND = 1;

	/**
	 * Joins path segments by connecting the outer corners of their wide outlines with a straight
	 * segment.
	 */
	public final static int JOIN_BEVEL = 2;

	/**
	 * Ends unclosed subpaths and dash segments with no added decoration.
	 */
	public final static int CAP_BUTT = 0;

	/**
	 * Ends unclosed subpaths and dash segments with a round decoration that has a radius equal to
	 * half of the width of the pen.
	 */
	public final static int CAP_ROUND = 1;

	/**
	 * Ends unclosed subpaths and dash segments with a square projection that extends beyond the end
	 * of the segment to a distance equal to half of the line width.
	 */
	public final static int CAP_SQUARE = 2;

}
