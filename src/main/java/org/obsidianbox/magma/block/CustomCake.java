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
package org.obsidianbox.magma.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockCake;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.item.CustomBlockItem;
import org.obsidianbox.magma.lang.Languages;

public class CustomCake extends BlockCake {
    private final Addon addon;
    private final String identifier;
    private final Item cakeItem;
    private IIcon topIcon, bottomIcon, sideIcon, innerIcon;

    public CustomCake(Addon addon, String identifier, String displayName, Material material, boolean showInCreativeTab) {
        this.addon = addon;
        this.identifier = identifier;

        setBlockName(addon.getDescription().getIdentifier() + ".tile.block." + identifier);
        setBlockTextureName(addon.getDescription().getIdentifier() + ":" + "cakes/" + identifier);
        addon.getGame().getLanguages().put(addon, Languages.ENGLISH_AMERICAN, "tile.block." + identifier + ".name", displayName);
        GameRegistry.registerBlock(this, addon.getDescription().getIdentifier() + "_" + identifier);

        cakeItem = new CustomBlockItem(addon, identifier + "_item", displayName, true, this);
    }

    public final Addon getAddon() {
        return addon;
    }

    public final String getIdentifier() {
        return identifier;
    }

    @Override
    public String getLocalizedName() {
        return I18n.format(getUnlocalizedName() + ".name");
    }

    @Override
    public String getUnlocalizedName() {
        return addon.getDescription().getIdentifier() + ".tile.block." + identifier;
    }

    @Override
    public Item getItem(World world, int x, int y, int z) {
        return cakeItem;
    }

    @Override
    public void registerBlockIcons(IIconRegister icon) {
        topIcon = icon.registerIcon(getTextureName() + "_top");
        bottomIcon = icon.registerIcon(getTextureName() + "_bottom");
        sideIcon = icon.registerIcon(getTextureName() + "_side");
        innerIcon = icon.registerIcon(getTextureName() + "_inner");
    }

    @Override
    public IIcon getIcon(int side, int meta) {

        switch (side) {
            case 1:
                return topIcon;
            case 0:
                return bottomIcon;
            case 4:
                if (meta > 0) {
                    return innerIcon;
                }
            default:
                return sideIcon;
        }
    }
}
