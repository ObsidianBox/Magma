package org.obsidianbox.magma.gui;

public interface IContainer extends IWidget {
    /**
     * Adds a single widget to a container.
     *
     * @param child the {@link org.obsidianbox.magma.gui.IWidget} to add.
     * @return the container.
     */
    public IContainer addChild(IWidget child);

    /**
     * Adds a single widget to a container.
     *
     * @param index the position to insert it at, use -1 for append.
     * @param child the {@link org.obsidianbox.magma.gui.IWidget} to add.
     * @return the container.
     */
    public IContainer insertChild(int index, IWidget child);

    /**
     * Adds a list of children to a container.
     *
     * @param children the {@link org.obsidianbox.magma.gui.IWidget}s to add.
     * @return the container.
     */
    public IContainer addChildren(IWidget... children);

    /**
     * Removes a single widget from this container.
     *
     * @param child the {@link org.obsidianbox.magma.gui.IWidget} to add.
     * @return the container.
     */
    public IContainer removeChild(IWidget child);

    /**
     * Get a list of widgets inside this container.
     *
     * @return the {@link org.obsidianbox.magma.gui.IWidget}s in the container.
     */
    public IWidget[] getChildren();

    /**
     * Set the automatic layout type for children, triggered by setWidth() or setHeight().
     *
     * @param type the {@link org.obsidianbox.magma.gui.ContainerType}.
     * @return the container.
     */
    public IContainer setLayout(ContainerType type);

    /**
     * Get the automatic layout type for children.
     *
     * @return the container type.
     */
    public ContainerType getLayout();

    /**
     * <p>Force the container to re-layout all non-fixed children.
     *
     * <p>Unless you specifically need to update the layout at this instant,
     * you should use use deferLayout() instead.
     *
     * <p>This will re-position and resize all child elements.
     *
     * @return the container.
     */
    public IContainer updateLayout();

    /**
     * <p>Automatically call updateLayout during the next onTick().
     *
     * <p>This is automatically called when anything changes that would affect the container layout.
     *
     * <p>NOTE: Subclasses should ensure they don't prevent Container.onTick() from running.
     *
     * @return the container.
     */
    public IContainer deferLayout();

    /**
     * Set the contents alignment.
     *
     * @return the container.
     */
    public IContainer setAlign(Anchor anchor);

    /**
     * Get the contents alignment.
     *
     * @return the {@link org.obsidianbox.magma.gui.Anchor}
     */
    public Anchor getAlign();

    /**
     * Reverse the drawing order (right to left or bottom to top).
     *
     * @param reverse set to the reverse direction.
     * @return the container.
     */
    public IContainer setReverse(boolean reverse);

    /**
     * If this is drawing in reverse order.
     *
     * @return true if reversed, false if not.
     */
    public boolean getReverse();

    /**
     * Determines if children expand to fill width and height.
     *
     * @param auto set to auto.
     * @return the container.
     */
    public IContainer setAuto(boolean auto);

    /**
     * True if the children will expand to fill width and height.
     *
     * @return true if auto, false if not.
     */
    public boolean isAuto();
}
