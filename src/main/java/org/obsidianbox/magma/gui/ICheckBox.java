package org.obsidianbox.magma.gui;

public interface ICheckBox extends IButton {
    /**
     * Gets the checked state of the checkbox.
     *
     * @return true if checked, false if not.
     */
    public boolean isChecked();

    /**
     * Sets the checked state of the checkbox.
     *
     * @param checked the checked state.
     * @return the checkbox.
     */
    public ICheckBox setChecked(boolean checked);
}

