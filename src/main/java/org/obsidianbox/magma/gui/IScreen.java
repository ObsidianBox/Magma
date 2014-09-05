package org.obsidianbox.magma.gui;

import java.util.Set;
import java.util.UUID;

public interface IScreen extends IWidget {
    /**
     * Gets an array of all the attached widgets to this screen. Modifying this array will not affect the screen.
     *
     * @return array of all widgets.
     */
    public IWidget[] getAttachedWidgets();

    /**
     * Gets an array of all the attached widgets to this screen, and if recursive, any widgets of screens attached to this screen.
     *
     * @param recursive whether to get widgets attached to screens attached to this screen.
     * @return array of all widgets.
     */
    public IWidget[] getAttachedWidgets(boolean recursive);

    /**
     * Gets a set of all the attached widgets to this screen. Modifying this array will not affect the screen.
     *
     * @return set of all widgets.
     */
    public Set<IWidget> getAttachedWidgetsAsSet();

    /**
     * Gets a set of all the attached widgets to this screen, and if recursive, any widgets of screens attached to this screen.
     *
     * @param recursive whether to get widgets attached to screens attached to this screen.
     * @return set of all widgets.
     */
    public Set<IWidget> getAttachedWidgetsAsSet(boolean recursive);

    /**
     * Attaches a widget to this screen.
     *
     * @param iWidget the widget to attach.
     * @param plugin the plugin that created this widget.
     * @return the screen.
     */
    public IScreen attachWidget(String plugin, IWidget iWidget);

    /**
     * Attaches an array of widgets to this screen.
     *
     * @param plugin the plugin that created this widget.
     * @param iWidgets the widgets to attach.
     * @return the screen.
     */
    public IScreen attachWidgets(String plugin, IWidget... iWidgets);

    /**
     * Removes a widget from this screen.
     *
     * @param iWidget the widget to remove.
     * @return the screen.
     */
    public IScreen removeWidget(IWidget iWidget);

    /**
     * Is true if the screen has the given widget attached to it. Uses a linear search, takes O(n) time to complete.
     *
     * @param iWidget the widget to search for.
     * @return true if the widget was found, false if not.
     */
    public boolean containsWidget(IWidget iWidget);

    /**
     * Is true if the screen has a widget with the given id attached to it. Uses a linear search, takes O(n) time to complete.
     *
     * @param id the id to search for.
     * @return true if the widget was found, false if not.
     */
    public boolean containsWidget(UUID id);

    /**
     * Gets the widget that is associated with the given id, or null if none was found.
     *
     * @param id the id to search for.
     * @return widget if found, null if not.
     */
    public IWidget getWidget(UUID id);

    /**
     * Gets the height of the screen.
     *
     * @return the height.
     */
    public double getHeight();

    /**
     * Gets the width of the screen.
     *
     * @return the width.
     */
    public double getWidth();

    /**
     * Gets the screen type of this screen.
     *
     * @return the screen type.
     */
    public ScreenType getScreenType();

    /**
     * Gets the x-coordinate of the mouse on this screen.
     *
     * @return the x-coordinate of the mouse.
     */
    public int getMouseX();

    /**
     * Gets the y-coordinate of the mouse on this screen.
     *
     * @return the y-coordinate of the mouse.
     */
    public int getMouseY();
}

