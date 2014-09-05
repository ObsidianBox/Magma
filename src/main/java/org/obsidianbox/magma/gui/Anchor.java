package org.obsidianbox.magma.gui;

import java.util.HashMap;

public enum Anchor {
    /**
     * <p>Widget anchors allow you to place widgets that
     * stick or "anchor" to a point on the screen
     *
     * <p>A widget's coordinates refer to its top left
     * corner and anchors change the point they are
     * relative to on the screen
     *
     * <p>You can choose any of 9 points to anchor to,
     * note that if anchoring to the bottom or right
     * the widget will likely be off screen until you
     * set a negative y or x value
     *
     * <p>The only exception is scale which assumes the
     * screen to always be 427x240 and moves/scales
     * widgets to conform
     */

    /**
     * X, Y
     */
    TOP_LEFT(0),
    /**
     * (Screen Width / 2) + X, Y
     */
    TOP_CENTER(1),
    /**
     * Screen Width + X, Y
     */
    TOP_RIGHT(2),
    /**
     * X, (Screen Height / 2) + Y
     */
    CENTER_LEFT(3),
    /**
     * (Screen Width / 2) + X, (Screen Height / 2) + Y
     */
    CENTER_CENTER(4),
    /**
     * Screen Width + X, (Screen Height / 2) + Y
     */
    CENTER_RIGHT(5),
    /**
     * X, Screen Height + Y
     */
    BOTTOM_LEFT(6),
    /**
     * (Screen Width / 2) + X, Screen Height + Y
     */
    BOTTOM_CENTER(7),
    /**
     * Screen Width + X, Screen Height + Y
     */
    BOTTOM_RIGHT(8),
    /**
     * Scales
     */
    SCALE(9);

    private static final HashMap<Integer, Anchor> lookupId = new HashMap<>();
    static {
        for (Anchor t : values()) {
            lookupId.put(t.getId(), t);
        }
    }

    private final int id;
    private Anchor(int id) {
        this.id = id;
    }

    /**
     * Gets the id of the anchor type.
     *
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the anchor based on the ID.
     *
     * @param id the anchor id to search with.
     * @return the anchor found.
     */
    public static Anchor getAnchorFromId(int id) {
        return lookupId.get(id);
    }
}
