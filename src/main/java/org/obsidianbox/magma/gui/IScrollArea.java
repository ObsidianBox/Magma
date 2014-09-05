package org.obsidianbox.magma.gui;

public interface IScrollArea extends IScrollable, IScreen {
    /**
     * Recalculates height and width for all widgets.
     * This is useful when the size of a widget changed while it was already attached to the ScrollArea.
     */
    public void updateInnerSize();
}