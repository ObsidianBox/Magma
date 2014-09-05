package org.obsidianbox.magma.gui;

import java.awt.Rectangle;

import org.obsidianbox.magma.util.Color;

public interface IScrollable extends IControl {
    /**
     * Renders the contents of the Scrollable.
     *
     * The view port is already transformed and a matrix is pushed.
     */
    public void renderContents();

    /**
     * Gets the inner size for given axis, in pixels.
     *
     * @param axis the axis of the size vector.
     * @return the size of the view port on given axis.
     */
    public int getInnerSize(OrientationType axis);

    /**
     * Gets the scroll position, in pixels.
     *
     * @param axis the axis of the scroll vector.
     * @return the position of the view port on given axis.
     */
    public int getScrollPosition(OrientationType axis);

    /**
     * Sets the scroll position on the axis, in pixels.
     * The allowed scroll amount ranges from 0 to getMaximumScrollPosition for given axis.
     *
     * @param axis the axis to scroll.
     * @param position the position of the view port on given axis.
     */
    public void setScrollPosition(OrientationType axis, int position);

    /**
     * Adds x and y to the Horizontal and Vertical scroll position.
     *
     * @param x the x-coordinate scroll value.
     * @param y the y-coordinate scroll value.
     */
    public void scroll(int x, int y);

    /**
     * Adjusts the scroll position so that the given rectangle will fit into the view port.
     * If the given rect is too big, it will scroll to the x or y position of the rectangle.
     *
     * @param rect the {@link java.awt.Rectangle}.
     */
    public void ensureVisible(Rectangle rect);

    /**
     * Gets the maximum allowed scroll position.
     *
     * @param axis the {@link org.obsidianbox.magma.gui.OrientationType}.
     * @return the maximum scroll position. Use the return value to scroll to the very bottom. Returns
     *         0 if not scrolling is possible which means the whole content will fit in the view port.
     */
    public int getMaximumScrollPosition(OrientationType axis);

    /**
     * Depending on the set ScrollBarPolicy, returns whether to show or not to show a scroll bar on the given axis.
     *
     * @param axis the axis to check if it should view a scroll bar.
     * @return if the scroll bar should be shown for that axis.
     */
    public boolean needsScrollBar(OrientationType axis);

    /**
     * Sets the scroll bar policy for the given axis.
     *
     * @param axis the {@link org.obsidianbox.magma.gui.OrientationType}.
     * @param policy the {@link org.obsidianbox.magma.gui.ScrollBarPolicy}.
     */
    public void setScrollBarPolicy(OrientationType axis, ScrollBarPolicy policy);

    /**
     * Gets the scroll bar policy for the given axis.
     *
     * @param axis the {@link org.obsidianbox.magma.gui.OrientationType}.
     * @return the {@link org.obsidianbox.magma.gui.ScrollBarPolicy} for the given axis.
     */
    public ScrollBarPolicy getScrollBarPolicy(OrientationType axis);

    /**
     * Gets the size of the rectangle inside the scrollable. This is usually getWidth/Height() - 16 when the corresponding scrollbar is visible.
     * @param axis
     * @return
     */
    public int getViewportSize(OrientationType axis);

    /**
     * Gets the margin.
     *
     * @param pos the {@link org.obsidianbox.magma.gui.PositionOrientation}.
     * @return the margin value.
     */
    public int getMargin(PositionOrientation pos);

    /**
     * Gets the background color of this list.
     *
     * @return the {@link org.obsidianbox.magma.util.Color}.
     */
    public Color getBackgroundColor();

    /**
     * Sets the background color of this list.
     *
     * @param color the {@link org.obsidianbox.magma.util.Color} to set.
     * @return the scrollable.
     */
    public IScrollable setBackgroundColor(Color color);
}

