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
package org.obsidianbox.magma.item;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.enchantment.Enchantment;

import org.obsidianbox.magma.addon.Addon;

public class SimpleArrow extends SimpleItem {
    private int priority;
    private final Set<Enchantment> enchantments = new HashSet<>();

    public SimpleArrow(Addon addon, String identifier, String displayName, boolean showInCreativeTab, int priority) {
        super(addon, identifier, displayName, showInCreativeTab);
        this.priority = priority;
    }

    /**
     * Sets the arrows priority value, {@link net.minecraft.init.Items#arrow} has a priority of zero. Arrows with a higher priority will be used over arrows with a lower priority.
     *
     * @param priority A higher number means higher priority, lower means lower priority.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets the arrow priority value.
     *
     * @return The arrows priority value
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Adds an enchantment to the arrow
     *
     * @param enchantment The enchantment to add
     * @return True if it was added, false if not
     */
    public boolean addEnchantment(Enchantment enchantment) {
        return enchantments.add(enchantment);
    }

    /**
     * Adds enchantments to the arrow
     *
     * @param enchantments The enchantments to add
     * @return True if they were added, false if not
     */
    public boolean addEnchantments(Set<Enchantment> enchantments) {
        return this.enchantments.addAll(enchantments);
    }

    /**
     * Gets the arrows enchantments
     *
     * @return List of enchantments applied to this arrow
     */
    public Set<Enchantment> getEnchantments() {
        return Collections.unmodifiableSet(enchantments);
    }
}
