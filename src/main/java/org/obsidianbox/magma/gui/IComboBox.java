package org.obsidianbox.magma.gui;

import java.util.List;

public interface IComboBox extends IButton {
    /**
     * Sets the list of items in the combo box.
     *
     * @param items the list of items.
     * @return the combo box.
     */
    public IComboBox setItems(List<String> items);

    /**
     * Gets the list of items in the combo box.
     *
     * @return the list of items in the combo box.
     */
    public List<String> getItems();

    /**
     * Opens the combo box list.
     *
     * @return the combo box.
     */
    public IComboBox openList();

    /**
     * Closes the combo box list.
     *
     * @return the combo box.
     */
    public IComboBox closeList();

    /**
     * Gets the selected item's string value.
     *
     * @return the selected item's string value.
     */
    public String getSelectedItem();

    /**
     * Gets the selected row.
     *
     * @return the selected row's index number.
     */
    public int getSelectedRow();

    /**
     * Sets the selected row.
     *
     * @param row the row to select.
     * @return the combo box.
     */
    public IComboBox setSelection(int row);

    /**
     * Fires when a selection has changed in the combo box.
     *
     * @param i the selected row's index number.
     * @param text the selected item's string.
     */
    public void onSelectionChanged(int i, String text);

    /**
     * Gets the open status of the combo box.
     *
     * @return true if open, false if not.
     */
    public boolean isOpen();

    /**
     * Sets the format of the text on the button. Default is "%text%: %selected%".
     *
     * %text% will be replaced with whatever can be obtained by Button.getText().
     * %selected% will be replaced with the text of the selected item.
     * @param format the format of the text on the button.
     * @return the combo box.
     */
    public IComboBox setFormat(String format);

    /**
     * Gets the current format of the text on the button.
     *
     * @return the format string.
     */
    public String getFormat();
}

