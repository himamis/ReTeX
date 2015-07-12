package org.scilab.forge.jlatexmath;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import org.scilab.forge.jlatexmath.graphics.ColorD;
import org.scilab.forge.jlatexmath.graphics.Graphics2DD;

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
