package org.obsidianbox.magma.gui.widget;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.UUID;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IChatComponent;

import org.obsidianbox.magma.gui.RenderPriority;
import org.obsidianbox.magma.gui.container.Container;
import org.obsidianbox.magma.gui.screen.Screen;

public interface Widget {
    /**
     * The type of widget this is. Required for proper synchronization between the server and client.
     *
     * @return the widget type.
     */
    public WidgetType getType();

    /**
     * Returns a unique id for this widget.
     *
     * @return the unique id.
     */
    public UUID getId();

    /**
     * Called after this widget this created for serialization.
     *
     * @param compound the {@link net.minecraft.nbt.NBTTagCompound}.
     * @throws IOException
     */
    public void fromNBT(NBTTagCompound compound) throws IOException;

    /**
     * Called when this widget is serialized to the client.
     *
     * @param compound the {@link net.minecraft.nbt.NBTTagCompound}.
     * @throws IOException
     */
    public void toNBT(NBTTagCompound compound) throws IOException;

    /**
     * Gets the plugin that attached this widget to the screen, or null if this screen is unattached.
     *
     * @return the plugin that attached this widget to the screen.
     */
    public String getPlugin();

    /**
     * Gets the render priority for this widget. Highest priorities render first (in the background), the lowest priorities render on top (in the foreground).
     *
     * @return the priority.
     */
    public RenderPriority getPriority();

    /**
     * Sets the render priority for this widget. Highest priorities render first (in the background), the lowest priorities render on top (in the foreground).
     *
     * @param priority the priority to render at.
     * @return the widget.
     */
    public Widget setPriority(RenderPriority priority);

    /**
     * Gets the actual unscaled width of this widget, in pixels.
     *
     * @return the unscaled width.
     */
    public double getActualWidth();

    /**
     * Gets the width of this widget, in pixels.
     *
     * @return the scaled width.
     */
    public double getWidth();

    /**
     * Sets the width of this widget, in pixels.
     *
     * @param width the width to set.
     * @return the widget.
     */
    public Widget setWidth(int width);

    /**
     * Gets the actual unscaled height of this widget, in pixels.
     *
     * @return the unscaled height.
     */
    public double getActualHeight();

    /**
     * Gets the height of this widget, in pixels.
     *
     * @return the scaled height.
     */
    public double getHeight();

    /**
     * Sets the height of this widget, in pixels.
     *
     * @param height the height to set.
     * @return the widget.
     */
    public Widget setHeight(int height);

    /**
     * Gets the screen this widget is attached to, or null if unattached.
     *
     * @return the screen.
     */
    public Screen getScreen();

    /**
     * Gets the x-coordinate of this widget. Widgets (and screens) render from the top left corner the screen. 0,0 represents the top left corner.
     *
     * @return the x-coordinate.
     */
    public int getX();

    /**
     * Gets the scaled x-coordinate of this widget.
     *
     * @return the scaled x-coordinate.
     */
    public double getScreenX();

    /**
     * Gets the y-coordinate of this widget. Widgets (and screens) render from the top left corner the screen. 0,0 represents the top left corner.
     *
     * @return the y-coordinate.
     */
    public int getY();

    /**
     * Gets the scaled y-coordinate of this widget.
     *
     * @return the scaled y-coordinate.
     */
    public double getScreenY();

    /**
     * Sets the x-coordinate of this widget. Widgets (and screens) render from the top left corner the screen. 0,0 represents the top left corner.
     *
     * @param pos the position to set.
     * @return the widget.
     */
    public Widget setX(int pos);

    /**
     * Sets the y-coordinate of this widget. Widgets (and screens) render from the top left corner the screen. 0,0 represents the top left corner.
     *
     * @param pos the position to set.
     * @return the widget.
     */
    public Widget setY(int pos);

    /**
     * Shifts this widget the given number of pixels in the x direction.
     *
     * @param x the x-coordinate pixels to shift.
     * @return the widget.
     */
    public Widget shiftXPos(int x);

    /**
     * Shifts this widget the given number of pixels in the y direction.
     *
     * @param y the y-coordinate pixels to shift.
     * @return the widget.
     */
    public Widget shiftYPos(int y);

    /**
     * Is true if this widget is visible and rendering on the screen.
     *
     * @return the visibility.
     */
    public boolean isVisible();

    /**
     * Sets the visibility of this widget. If true, it will render normally. If false, it will not appear on the screen.
     *
     * @param enable enables or disables the visibility.
     * @return the widget.
     */
    public Widget setVisible(boolean enable);

    /**
     * Called each tick this widget is updated. This widget is processed for isDirty() immediately afterwords.
     */
    public void onTick();

    /**
     * Set the widget's tooltip.
     *
     * @param component the {@link net.minecraft.util.IChatComponent} to set the tooltip text.
     * @return the widget.
     */
    public Widget setTooltip(IChatComponent component);

    /**
     * Gets the widget's tooltip.
     *
     * @return the {@link net.minecraft.util.IChatComponent} for the tooltip text.
     */
    public IChatComponent getTooltip();

    /**
     * Gets the widget's container.
     *
     * @return the {@link org.obsidianbox.magma.gui.container.Container}
     */
    public Container getContainer();

    /**
     * Does the widget have a container.
     *
     * @return true if it has a container, false if not.
     */
    public boolean hasContainer();

    /**
     * Sets the parent container for this widget.
     *
     * @param container the {@link Container} to set as parent.
     */
    public void setContainer(Container container);

    /**
     * Container Layout - Set whether the widget will be resized with its container.
     *
     * @param fixed set if it is a static size.
     * @return the widget.
     */
    public Widget setFixed(boolean fixed);

    /**
     * Container Layout - Whether the widget is fixed size inside its container.
     *
     * @return true if fixed, false if not.
     */
    public boolean isFixed();

    // NOTE: Margins follow the same order as CSS
    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginAll the margin to set.
     * @return the widget.
     */
    public Widget setMargin(int marginAll);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginTopBottom the top margin.
     * @param marginLeftRight the left margin.
     * @return the widget.
     */
    public Widget setMargin(int marginTopBottom, int marginLeftRight);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginTop the top margin.
     * @param marginLeftRight the left and right margin.
     * @param marginBottom the bottom margin.
     * @return the widget.
     */
    public Widget setMargin(int marginTop, int marginLeftRight, int marginBottom);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginTop the top margin.
     * @param marginRight the right margin.
     * @param marginBottom the bottom margin.
     * @param marginLeft the left margin.
     * @return the widget.
     */
    public Widget setMargin(int marginTop, int marginRight, int marginBottom, int marginLeft);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginTop the top margin.
     * @return the widget.
     */
    public Widget setMarginTop(int marginTop);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginRight the right margin.
     * @return the widget.
     */
    public Widget setMarginRight(int marginRight);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginBottom the bottom margin.
     * @return the widget.
     */
    public Widget setMarginBottom(int marginBottom);

    /**
     * Container Layout - Padding to use for automatic container layout - not included in dimensions.
     *
     * @param marginLeft the left margin.
     * @return the widget.
     */
    public Widget setMarginLeft(int marginLeft);

    /**
     * Container Layout - Get the margin used for container layout.
     *
     * @return the top margin.
     */
    public int getMarginTop();

    /**
     * Container Layout - Get the margin used for container layout.
     *
     * @return the right margin.
     */
    public int getMarginRight();

    /**
     * Container Layout - Get the margin used for container layout.
     *
     * @return the bottom margin.
     */
    public int getMarginBottom();

    /**
     * Container Layout - Get the margin used for container layout.
     *
     * @return the left margin.
     */
    public int getMarginLeft();

    /**
     * Container Layout - Set the minimum width for this widget.
     *
     * @param min the minimum width to allow.
     * @return the widget.
     */
    public Widget setMinWidth(int min);

    /**
     * Container Layout - Get the minimum width for this widget.
     *
     * @return the minimum width allowed.
     */
    public int getMinWidth();

    /**
     * Container Layout - Set the maximum width for this widget.
     *
     * @param max the maximum width to allow.
     * @return the widget.
     */
    public Widget setMaxWidth(int max);

    /**
     * Container Layout - Get the maximum width for this widget.
     *
     * @return the maximum width allowed.
     */
    public int getMaxWidth();

    /**
     * Container Layout - Set the minimum height for this widget.
     *
     * @param min the minimum height to allow.
     * @return the widget.
     */
    public Widget setMinHeight(int min);

    /**
     * Container Layout - Get the minimum height for this widget.
     *
     * @return the minimum height allowed.
     */
    public int getMinHeight();

    /**
     * Container Layout - Set the maximum height for this widget.
     *
     * @param max the maximum height to allow.
     * @return the widget.
     */
    public Widget setMaxHeight(int max);

    /**
     * Container Layout - Get the maximum height for this widget.
     *
     * @return the maximum height allowed.
     */
    public int getMaxHeight();

    /**
     * Container Layout - Save the position for later restoration.
     *
     * @return the widget.
     */
    public Widget savePosition();

    /**
     * Container Layout - Restore the earlier saved position.
     *
     * @return the widget.
     */
    public Widget restorePosition();

    /**
     * Set the anchor point for this widget, default is CENTER.
     *
     * @param anchor the {@link Anchor} to set.
     * @return the widget.
     */
    public Widget setAnchor(Anchor anchor);

    /**
     * Get the current anchor position.
     *
     * @return the current {@link Anchor} position.
     */
    public Anchor getAnchor();

    /**
     * <p>Returns a clone of this widget with a new UUID.
     *
     * <p>Copies will not be equal to each other, but will have the same internal data.
     *
     * <p>Note: The clone will not be attached to a screen, nor be part of a container even if the original was.
     *
     * @return a clone of this widget.
     */
    public Widget clone();

    /**
     * Gets the unscaled x-coordinate.
     *
     * @return the unscaled x-coordinate.
     */
    public double getActualX();

    /**
     * Gets the unscaled y-coordinate.
     *
     * @return the unscaled y-coordinate.
     */
    public double getActualY();

    /**
     * Gets the widgets coordinates and size in one object.
     *
     * @return the bounds of the widget.
     */
    public Rectangle getBounds();

    /**
     * Sets the widgets coordinates and size with one object.
     *
     * @param rect the new {@link java.awt.Rectangle} of the widget.
     * @return the widget.
     */
    public Widget setBounds(Rectangle rect);

    /**
     * Sets the widgets coordinates and size.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @param width the width.
     * @param height the height.
     * @return the widget.
     */
    public Widget setBounds(int x, int y, int width, int height);
}

