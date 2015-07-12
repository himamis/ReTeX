/* MacroInfo.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://forge.scilab.org/jlatexmath
 * 
 * Copyright (C) 2009 DENIZET Calixte
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
 * 
 */

package com.himamis.retex.renderer.share;

import java.util.HashMap;

import com.himamis.retex.renderer.share.exception.ParseException;

public class MacroInfo {

	public static HashMap<String, MacroInfo> Commands = new HashMap<String, MacroInfo>(300);
	public static HashMap<String, Object> Packages = new HashMap<String, Object>();

	public int nbArgs;
	public boolean hasOptions = false;
	public int posOpts;
	public Macro macro;

	public MacroInfo(Macro macro, int nbArgs) {
		this.macro = macro;
		this.nbArgs = nbArgs;
	}

	public MacroInfo(Macro macro, int nbArgs, int posOpts) {
		this(macro, nbArgs);
		this.posOpts = posOpts;
		this.hasOptions = true;
	}

	public MacroInfo(int nbArgs, int posOpts) {
		this(null, nbArgs, posOpts);
	}

	public MacroInfo(int nbArgs) {
		this(null, nbArgs);
	}

	public Object invoke(final TeXParser tp, final String[] args) throws ParseException {
		return macro.executeMacro(tp, args);
	}
}