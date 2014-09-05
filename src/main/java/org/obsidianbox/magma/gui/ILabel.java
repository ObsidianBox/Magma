package org.obsidianbox.magma.gui;

import org.obsidianbox.magma.util.Color;

public interface ILabel extends IWidget {
    /**
     * Gets the text of the label.
     *
     * @return the current text.
     */
    public String getText();

    /**
     * Sets the text of the label.
     *
     * @param text the text to set.
     * @return the label.
     */
    public ILabel setText(String text);

    /**
     * Gets the color for the text.
     *
     * @return the color of the text.
     */
    public Color getTextColor();

    /**
     * Sets the color for the text.
     *
     * @param color the color to set.
     * @return the label.
     */
    public ILabel setTextColor(Color color);

    /**
     * Determines if text expands to fill width and height.
     * If word wrapping and auto is enabled, the height of the ILabel will reflect the height of all lines.
     *
     * @param auto set to auto.
     * @return the label.
     */
    public ILabel setAuto(boolean auto);

    /**
     * Gets if the text will expand to fill width and height.
     *
     * @return true if auto, false if not.
     */
    public boolean isAuto();

    /**
     * Gets the current anchor.
     *
     * @return the current anchor.
     */
    public Anchor getAlign();

    /**
     * SEts the current anchor.
     *
     * @param anchor the anchor to set.
     * @return the label.
     */
    public ILabel setAlign(Anchor anchor);

    /**
     * Set the scale of the text.
     *
     * @param scale the scale to set.
     * @return the label.
     */
    public ILabel setScale(float scale);

    /**
     * Gets the scale of the text.
     *
     * @return the scale of text.
     */
    public float getScale();

    /**
     * Sets whether or not the label has a shadow.
     *
     * @param shadow show a shadow or not.
     */
    public ILabel setShadow(boolean shadow);

    /**
     * Gets whether or not the label has a shadow.
     *
     * @return true if it has a shadow, false if not.
     */
    public boolean hasShadow();
}
