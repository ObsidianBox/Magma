package org.obsidianbox.magma.gui;

import java.util.HashMap;

public class WidgetType {
    private static HashMap<WidgetType, Integer> lookupClass = new HashMap<>();
    private static HashMap<Integer, WidgetType> lookupId = new HashMap<>();
    private static int lastId = 0;

    /*
    public static WidgetType Label = new WidgetType(GenericLabel.class, 0);
    public static WidgetType HealthBar = new WidgetType(HealthBar.class, 1);
    public static WidgetType BubbleBar = new WidgetType(BubbleBar.class, 2);
    public static WidgetType ChatBar = new WidgetType(ChatBar.class, 3);
    public static WidgetType ChatTextBox = new WidgetType(ChatTextBox.class, 4);
    public static WidgetType ArmorBar = new WidgetType(ArmorBar.class, 5);
    public static WidgetType Texture = new WidgetType(GenericTexture.class, 6);
    public static WidgetType PopupScreen = new WidgetType(GenericPopup.class, 7);
    public static WidgetType InGameScreen = new WidgetType(null, 8);
    public static WidgetType ItemWidget = new WidgetType(GenericItemWidget.class, 9);
    public static WidgetType Button = new WidgetType(GenericButton.class, 10);
    public static WidgetType Slider = new WidgetType(GenericSlider.class, 11);
    public static WidgetType TextField = new WidgetType(GenericTextField.class, 12);
    public static WidgetType Gradient = new WidgetType(GenericGradient.class, 13);
    public static WidgetType Container = new WidgetType(GenericGradient.class, 14, true);
    public static WidgetType EntityWidget = new WidgetType(GenericEntityWidget.class, 15);
    public static WidgetType OverlayScreen = new WidgetType(GenericOverlayScreen.class, 16);
    public static WidgetType HungerBar = new WidgetType(HungerBar.class, 17);
    public static WidgetType ExpBar = new WidgetType(ExpBar.class, 18);
    public static WidgetType CheckBox = new WidgetType(GenericCheckBox.class, 19);
    public static WidgetType RadioButton = new WidgetType(GenericRadioButton.class, 20);
    public static WidgetType ListWidget = new WidgetType(GenericListWidget.class, 21);
    public static WidgetType DirtBackground = new WidgetType(DirtBackground.class, 22);
    public static WidgetType ScrollArea = new WidgetType(GenericScrollArea.class, 23);
    public static WidgetType ListView = new WidgetType(GenericListView.class, 24);
    public static WidgetType ComboBox = new WidgetType(GenericComboBox.class, 25);
    public static WidgetType Polygon = new WidgetType(GenericPolygon.class, 26);
    public static WidgetType Slot = new WidgetType(GenericSlot.class, 27);
    */

    private final int id;
    private final boolean client;
    private final Class <? extends IWidget> widgetClass;

    public WidgetType(Class<? extends IWidget> widget) {
        widgetClass = widget;
        id = lastId;
        lastId++;
        lookupClass.put(this, id);
        lookupId.put(id, this);
        client = false;
    }

    private WidgetType(Class<? extends IWidget> widget, int id) {
        widgetClass = widget;
        this.id = id;

        if (id > lastId) {
            lastId = id;
        }

        lookupClass.put(this, id);
        lookupId.put(id, this);
        client = false;
    }

    public WidgetType(Class<? extends IWidget> widget, boolean client) {
        widgetClass = widget;
        id = lastId;
        lastId++;
        lookupClass.put(this, id);
        lookupId.put(id, this);
        this.client = client;
    }

    public WidgetType(Class<? extends IWidget> widget, int id, boolean client) {
        widgetClass = widget;
        this.id = id;

        if (id > lastId) {
            lastId = id;
        }

        lookupClass.put(this, id);
        lookupId.put(id, this);
        this.client = client;
    }

    public final int getId() {
        return id;
    }

    public final Class <? extends IWidget> getWidgetClass() {
        return widgetClass;
    }

    public final boolean isClientOnly() {
        return client;
    }

    public static Integer getWidgetId(Class <? extends IWidget> widget) {
        return lookupClass.get(widget);
    }

    public static WidgetType getWidgetFromId(int id) {
        return lookupId.get(id);
    }

    public static int getNumWidgetTypes() {
        return lastId;
    }
}
