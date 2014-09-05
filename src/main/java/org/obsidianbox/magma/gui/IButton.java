package org.obsidianbox.magma.gui;

import org.obsidianbox.magma.util.Color;

public interface IButton extends IControl, ILabel {
    /**
     * Gets the text that is displayed when the control is disabled.
     *
     * @return the disabled text.
     */
    public String getDisabledText();

    /**
     * Sets the text that is displayed when the control is disabled.
     *
     * @param text the text to display.
     * @return the button.
     */
    public IButton setDisabledText(String text);

    /**
     * Gets the color of the control while the mouse is hovering over it.
     *
     * @return the {@link org.obsidianbox.magma.util.Color}.
     */
    public Color getHoverColor();

    /**
     * Sets the color of the control while the mouse is hovering over it.
     *
     * @param color the hover {@link org.obsidianbox.magma.util.Color} to use.
     * @return the button.
     */
    public IButton setHoverColor(Color color);

    /**
     * Sets the text that is displayed.
     *
     * @param text the text to set.
     * @return the button.
     */
    public IButton setText(String text);

    /**
     * Sets the text color to use.
     *
     * @param color the {@link org.obsidianbox.magma.util.Color} to set.
     * @return the button.
     */
    public IButton setTextColor(Color color);

    /**
     * Sets if the button should automatically resize for the text.
     *
     * @param auto set to auto.
     * @return the button.
     */
    public IButton setAuto(boolean auto);

    /**
     * Sets the alignment of the button.
     *
     * @param align the {@link org.obsidianbox.magma.gui.Anchor} alignment.
     * @return the button.
     */
    public IButton setAlign(Anchor align);

    /**
     * Fires when this button is clicked on the screen.
     */
    public void onButtonClick();
}

