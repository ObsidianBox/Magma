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

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.lang.Languages;

public class SimpleBow extends ItemBow {
    private final Addon addon;
    private final String identifier;
    private final IIcon[] icons = new IIcon[3];

    public SimpleBow(Addon addon, String identifier, String displayName, boolean showInCreativeTab, int maxDurability) {
        this.addon = addon;
        this.identifier = identifier;
        setMaxDamage(maxDurability);
        setTextureName(addon.getDescription().getIdentifier() + ":bows/" + identifier);
        addon.getGame().getLanguages().put(addon, Languages.ENGLISH_AMERICAN, "item." + identifier + ".name", displayName);
        if (showInCreativeTab) {
            setCreativeTab(addon.getGame().getTabs());
        }
        GameRegistry.registerItem(this, addon.getDescription().getIdentifier() + "_" + identifier);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister icon) {
        itemIcon = icon.registerIcon(this.getIconString() + "_standby");
        for (int i = 0; i < icons.length; i++) {
            icons[i] = icon.registerIcon(this.getIconString() + "_pulling_" + i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack stack2, int useRemaining) {
        final int time = stack.getMaxItemUseDuration() - useRemaining;
        if (time >= 18) {
            return icons[2];
        } else if (time > 13) {
            return icons[1];
        } else if (time > 0) {
            return icons[0];
        } else {
            return itemIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getItemIconForUseDuration(int state) {
        return icons[state];
    }

    public final Addon getAddon() {
        return addon;
    }

    public final String getIdentifier() {
        return identifier;
    }

    @Override
    public String getUnlocalizedName() {
        return addon.getDescription().getIdentifier() + ".item." + identifier;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return I18n.format(getUnlocalizedName() + ".name");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleBow)) {
            return false;
        }

        final SimpleBow that = (SimpleBow) o;

        return addon.equals(that.addon) && identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        int result = addon.hashCode();
        result = 31 * result + identifier.hashCode();
        return result;
    }
}
