package org.obsidianbox.magma.gui;

import java.util.HashMap;

public enum ScrollBarPolicy {
    /**
     * Shows the scroll bar when getMaximumScrollPosition is greater than 0.
     */
    SHOW_IF_NEEDED(0),
    /**
     * Never show the scroll bar. However, you'll still be able to scroll with the scroll wheel, your track pad or with arrow keys if the widget implemented that (like the list widget).
     */
    SHOW_NEVER(1),
    /**
     * Always show the scroll bar
     */
    SHOW_ALWAYS(2);

    private final int id;
    private static HashMap<Integer, ScrollBarPolicy> ids = new HashMap<Integer, ScrollBarPolicy>();
    ScrollBarPolicy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ScrollBarPolicy getById(int id) {
        return ids.get(id);
    }

    static {
        for (ScrollBarPolicy s: values()) {
            ids.put(s.id, s);
        }
    }
}
