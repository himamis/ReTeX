package org.scilab.forge.jlatexmath;

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
