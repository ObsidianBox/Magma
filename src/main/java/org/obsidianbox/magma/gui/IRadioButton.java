package org.obsidianbox.magma.gui;

public interface IRadioButton extends IButton {
    /**
     * Is true if the radio button is selected.
     *
     * @return true if selected, false if not.
     */
    public boolean isSelected();

    /**
     * Sets the radio button's selected state.
     *
     * @param selected the selected state of the radio button.
     * @return the radio button.
     */
    public IRadioButton setSelected(boolean selected);

    /**
     * Gets the group id for this radio button. Radio buttons on the same screen, with the same group id will be grouped together.
     *
     * @return the group id.
     */
    public int getGroup();

    /**
     * Sets the group id for this radio button.
     *
     * @param group the group id to set.
     * @return the radio button.
     */
    public IRadioButton setGroup(int group);
}

