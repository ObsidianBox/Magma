package org.obsidianbox.magma.gui;

import org.lwjgl.input.Keyboard;

import org.obsidianbox.magma.util.Color;

public interface IControl extends IWidget {
    /**
     * Gets the status of the control, if it is enabled and can receive input.
     *
     * @return true if enabled and receives input, false if not.
     */
    public boolean isEnabled();

    /**
     * Disables input to the control, but still allows it to be visible.
     *
     * @param enable the enabled status.
     * @return the control.
     */
    public IControl setEnabled(boolean enable);

    /**
     * Gets the color of this control.
     *
     * @return the {@link org.obsidianbox.magma.util.Color}.
     */
    public Color getColor();

    /**
     * Sets the color of this control.
     *
     * @param color the {@link org.obsidianbox.magma.util.Color} to set.
     * @return the control.
     */
    public IControl setColor(Color color);

    /**
     * Gets the color of this control when it is disabled.
     *
     * @return the disabled {@link org.obsidianbox.magma.util.Color}.
     */
    public Color getDisabledColor();

    /**
     * Sets the color of this control when it is disabled.
     *
     * @param color the disabled {@link org.obsidianbox.magma.util.Color} to set.
     * @return the control.
     */
    public IControl setDisabledColor(Color color);

    /**
     * Gets the focused status of the control.
     *
     * @return true if control has focus, false if not.
     */
    public boolean isFocus();

    /**
     * Sets the focus status of the control.
     *
     * @param focus true to give focus, false to remove focus.
     * @return the control.
     */
    public IControl setFocus(boolean focus);

    /**
     * Will be called if this control has focus and a key was pressed.
     *
     * @param key the pressed key.
     * @return true if you handled the key press and it shouldn't be handled elsewhere.
     */
    public boolean onKeyPressed(Keyboard key);

    /**
     * Will be called if this control has focus and a key was released.
     *
     * @param key the released key.
     * @return true if you handled the key release and it shouldn't be handled elsewhere.
     */
    public boolean onKeyReleased(Keyboard key);
}

