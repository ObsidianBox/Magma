package org.obsidianbox.magma.gui;

import java.nio.IntBuffer;

/**
 * You must specify the width and height of the background bitmap to be used in
 * the constructor!
 */
public interface IBitmap {
    /**
     * Get the raw RGBA array used to create the texture.
     *
     * @return an array of width * height * 4 bytes.
     */
    public byte[] getRawBitmap();

    /**
     * Get the raw width of the bitmap (the widget itself can be scaled to a
     * different size like normal).
     *
     * @return the bitmap size.
     */
    public int getRawWidth();

    /**
     * Get the raw height of the bitmap (the widget itself can be scaled to a
     * different size like normal).
     *
     * @return the bitmap size.
     */
    public int getRawHeight();

    /**
     * Get an IntBuffer to use for setting individual pixels in single calls.
     *
     * @return the {@link java.nio.IntBuffer}.
     */
    public IntBuffer getBuffer();
}
