/**
 * This file is part of Magma, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013-2014 ObsidianBox <http://obsidianbox.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.obsidianbox.magma.util;

import java.io.Serializable;

import com.flowpowered.math.vector.Vector4i;

public class Color implements Serializable {
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color BROWN = new Color(193, 153, 83);
    public static final Color CRIMSON = new Color(220, 20, 60);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color GOLD = new Color(255, 215, 0);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color GREEN = new Color(0, 128, 0);
    public static final Color INDIGO = new Color(75, 0, 130);
    public static final Color OBSIDIAN_BLACK_PRIMARY = new Color(108, 108, 109);
    public static final Color OBSIDIAN_BLACK_SECONDARY = new Color(48, 48, 48);
    public static final Color OBSIDIAN_BLUE_PRIMARY = new Color(77, 146, 184);
    public static final Color OBSIDIAN_BLUE_SECONDARY = new Color(18, 35, 82);
    public static final Color OBSIDIAN_GREEN_PRIMARY = new Color(75, 150, 39);
    public static final Color OBSIDIAN_GREEN_SECONDARY = new Color(6, 73, 0);
    public static final Color OBSIDIAN_ORANGE_PRIMARY = new Color(237, 118, 0);
    public static final Color OBSIDIAN_ORANGE_SECONDARY = new Color(161, 80, 0);
    public static final Color OBSIDIAN_PURPLE_PRIMARY = new Color(119, 103, 174);
    public static final Color OBSIDIAN_PURPLE_SECONDARY = new Color(50, 42, 79);
    public static final Color OBSIDIAN_RED_PRIMARY = new Color(217, 12, 26);
    public static final Color OBSIDIAN_RED_SECONDARY = new Color(98, 7, 15);
    public static final Color OBSIDIAN_YELLOW_PRIMARY = new Color(192, 186, 29);
    public static final Color OBSIDIAN_YELLOW_SECONDARY = new Color(159, 165, 0);
    public static final Color ORANGE = new Color(255, 165, 0);
    public static final Color PINK = new Color(255, 192, 203);
    public static final Color PURPLE = new Color(128, 0, 128);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color SILVER = new Color(192, 192, 192);
    public static final Color VIOLET = new Color(238, 130, 238);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color YELLOW = new Color(255, 255, 0);
    private static final long serialVersionUID = 1L;
    private final Vector4i vec;

    /**
     * Creates a Color with the alpha set to 255.
     *
     * @param r the red value.
     * @param g the green value.
     * @param b the blue value.
     */
    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public Color(int r, int g, int b, int a) {
        this(new Vector4i(r, g, b, a));
    }

    public Color(Vector4i vec) {
        if (vec.getX() < 0 || vec.getX() > 255) {
            throw new IllegalArgumentException("Red value must be between 0 and 255, current value is: " + vec.getX());
        }
        if (vec.getY() < 0 || vec.getY() > 255) {
            throw new IllegalArgumentException("Green value must be between 0 and 255, current value is: " + vec.getY());
        }
        if (vec.getZ() < 0 || vec.getZ() > 255) {
            throw new IllegalArgumentException("Blue value must be between 0 and 255, current value is: " + vec.getZ());
        }
        if (vec.getW() < 0 || vec.getW() > 255) {
            throw new IllegalArgumentException("Alpha value must be between 0 and 255, current value is: " + vec.getW());
        }
        this.vec = vec;
    }

    /**
     * Gets the Red value.
     *
     * @return the red value.
     */
    public int getR() {
        return vec.getX();
    }

    /**
     * Gets the Green value.
     *
     * @return the green value.
     */
    public int getG() {
        return vec.getY();
    }

    /**
     * Gets the Blue value.
     *
     * @return the blue value.
     */
    public int getB() {
        return vec.getZ();
    }

    /**
     * Gets the Alpha value.
     *
     * @return the alpha value.
     */
    public int getA() {
        return vec.getW();
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && vec.equals(((Color) o).vec);
    }

    @Override
    public int hashCode() {
        return vec.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "r: " + vec.getX() +
                "g: " + vec.getY() +
                "b: " + vec.getZ() +
                "g: " + vec.getW() +
                '}';
    }
}

