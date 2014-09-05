package org.obsidianbox.magma.gui;

import org.obsidianbox.magma.util.Color;

public interface IGradient extends IWidget {
    /**
     * Gets the top color of the gradient to render.
     *
     * @return the top {@link org.obsidianbox.magma.util.Color}.
     */
    public Color getTopColor();

    /**
     * Sets the top color of the gradient to render.
     *
     * @param color the top {@link org.obsidianbox.magma.util.Color}.
     * @return the gradient.
     */
    public IGradient setTopColor(Color color);

    /**
     * Gets the bottom color of the gradient to render.
     *
     * @return the bottom {@link org.obsidianbox.magma.util.Color}.
     */
    public Color getBottomColor();

    /**
     * Sets the bottom color of the gradient to render
     *
     * @param color the bottom {@link org.obsidianbox.magma.util.Color}.
     * @return the gradient.
     */
    public IGradient setBottomColor(Color color);

    /**
     * Sets the bottom and top color of the gradient to render.
     * 
     * @param color the {@link org.obsidianbox.magma.util.Color} for top and bottom.
     * @return the gradient.
     */
    public IGradient setColor(Color color);

    /**
     * Set the direction the gradient is drawn.
     * Default is VERTICAL, if using HORIZONTAL then read top as left and bottom as right.
     * 
     * @param axis the {@link org.obsidianbox.magma.gui.OrientationType} to draw in.
     * @return the gradient.
     */
    public IGradient setOrientation(OrientationType axis);

    /**
     * Gets the direction the gradient is drawn.
     * Default is VERTICAL, if using HORIZONTAL then read top as left and bottom as right.
     * 
     * @return the {@link org.obsidianbox.magma.gui.OrientationType} being used.
     */
    public OrientationType getOrientation();
}

