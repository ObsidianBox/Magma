package org.obsidianbox.magma.gui;

import java.util.HashMap;

/**
 * This is used to define the orientation for Scrollable widgets.
 */
public enum OrientationType {
    /**
     * Horizontal axis (left-right)
     */
    HORIZONTAL(0),
    /**
     * Vertical axis (top-bottom)
     */
    VERTICAL(1);

    private final int id;
    OrientationType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private static final HashMap<Integer, OrientationType> lookupId = new HashMap<>();

    static {
        for (OrientationType t : values()) {
            lookupId.put(t.getId(), t);
        }
    }

    public static OrientationType getOrientationFromId(int id) {
        return lookupId.get(id);
    }

    public OrientationType getOther() {
        switch (this) {
            case HORIZONTAL:
                return VERTICAL;
            case VERTICAL:
                return HORIZONTAL;
        }
        return null;
    }
}

