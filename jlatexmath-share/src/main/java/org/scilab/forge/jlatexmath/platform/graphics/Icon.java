package org.scilab.forge.jlatexmath.platform.graphics;

public interface Icon {
	
	/**
     * Draw the icon at the specified location.  Icon implementations
     * may use the Component argument to get properties useful for
     * painting, e.g. the foreground or background color.
     */
    void paintIcon(HasForegroundColor c, Graphics2DInterface g, int x, int y);

    /**
     * Returns the icon's width.
     *
     * @return an int specifying the fixed width of the icon.
     */
    int getIconWidth();

    /**
     * Returns the icon's height.
     *
     * @return an int specifying the fixed height of the icon.
     */
    int getIconHeight();
}
