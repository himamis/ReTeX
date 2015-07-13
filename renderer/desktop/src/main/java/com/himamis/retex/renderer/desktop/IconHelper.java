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
package com.himamis.retex.renderer.desktop;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.himamis.retex.renderer.desktop.graphics.ColorD;
import com.himamis.retex.renderer.desktop.graphics.Graphics2DD;
import com.himamis.retex.renderer.share.ColorUtil;
import com.himamis.retex.renderer.share.platform.graphics.Color;
import com.himamis.retex.renderer.share.platform.graphics.HasForegroundColor;
import com.himamis.retex.renderer.share.platform.graphics.Icon;

public class IconHelper {

	public static javax.swing.Icon createIcon(final Icon icon) {
		return new javax.swing.Icon() {

			public void paintIcon(Component c, Graphics g, int x, int y) {
				final Component component = c;
				final Graphics2DD g2d = new Graphics2DD((Graphics2D) g);
				icon.paintIcon(new HasForegroundColor() {

					public Color getForegroundColor() {
						if (component != null) {
							return new ColorD(component.getForeground());
						}
						return ColorUtil.BLACK;
					}
				}, g2d, x, y);
			}

			public int getIconWidth() {
				return icon.getIconWidth();
			}

			public int getIconHeight() {
				return icon.getIconHeight();
			}

		};
	}

}
