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
package com.himamis.retex.renderer.share;

/**
 * Simple 16 bit bitset without error handling.
 * 
 * @author himamis
 *
 */
public class BitSet {

	private int bitSet = 0;

	/**
	 * Sets the bit indexed at bitIndex to 1.
	 * 
	 * @param bitIndex the bit index to set to 1
	 */
	public void setBit(int bitIndex) {
		bitSet |= (1 << bitIndex);
	}

	/**
	 * 
	 * @param bitIndex index of the bit
	 * @return true if the bit is set to 1, false otherwise
	 */
	public boolean getBit(int bitIndex) {
		return ((bitSet >> bitIndex) & 1) == 1;
	}

}
