package org.obsidianbox.magma.gui;

import java.util.HashMap;
import java.util.Map;

public enum ScreenType {
    GAME_SCREEN(0),
    CHAT_SCREEN(1),
    CUSTOM_SCREEN(2),
    PLAYER_INVENTORY(3),
    CHEST_INVENTORY(4),
    DISPENSER_INVENTORY(5),
    FURNACE_INVENTORY(6),
    INGAME_MENU(7),
    OPTIONS_MENU(8),
    VIDEO_SETTINGS_MENU(9),
    CONTROLS_MENU(10),
    ACHIEVEMENTS_SCREEN(11),
    STATISTICS_SCREEN(12),
    WORKBENCH_INVENTORY(13),
    SIGN_SCREEN(14),
    GAME_OVER_SCREEN(15),
    SLEEP_SCREEN(16),
    ADD_WAYPOINT(17),
    BREWING_STAND_INVENTORY(18),
    PLAYER_INVENTORY_CREATIVE(19),
    ENCHANTMENT_INVENTORY(20),
    EDIT_SHORTCUT(21),
    CHANGE_LANGUAGE(22),
    MINIMAP_SETTINGS(23),
    AMBIGUOUS_SHORTCUT(24),
    CHAT_SETTINGS(25),
    LIST_EDIT(26),
    MOVE_MINIMAP(27),
    OVERVIEW_MAP(28),
    WIN_GAME(29),
    CONFIRM_URL(30),
    UNKNOWN(-1);

    private final int code;
    private static Map<Integer, ScreenType> lookup = new HashMap<Integer, ScreenType>();
    static {
        for (ScreenType type : values()) {
            lookup.put(type.code, type);
        }
    }

    private ScreenType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ScreenType getType(int code) {
        return lookup.get(code);
    }
}
