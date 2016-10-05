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

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.lang.Languages;
import org.obsidianbox.magma.util.Location;

public class SimpleSlab extends BlockSlab {
    private final Addon addon;
    private final String identifier;
    private static SimpleSlab singleSlab;
    private static SimpleDoubleSlab doubleSlab;
    private IIcon bottomIcon, sideIcon, topIcon;

    public SimpleSlab(Addon addon, String identifier, String displayName, Material material, boolean showInCreativeTab) {
        this(addon, identifier, displayName, material, showInCreativeTab, false);
    }

    private SimpleSlab(Addon addon, String identifier, String displayName, Material material, boolean showInCreativeTab, boolean isDoubleSlab) {
        super(isDoubleSlab, material);
        this.addon = addon;
        this.identifier = identifier;

        setBlockName(addon.getDescription().getIdentifier() + ".tile.block." + identifier);
        setBlockTextureName(addon.getDescription().getIdentifier() + ":slabs/" + identifier);
        addon.getGame().getLanguages().put(addon, Languages.ENGLISH_AMERICAN, "tile.block." + identifier + ".name", displayName);

        if (!isDoubleSlab) {
            setLightOpacity(0);

            if (showInCreativeTab) {
                setCreativeTab(addon.getGame().getTabs());
            }

            singleSlab = this;
            doubleSlab = new SimpleDoubleSlab(this, displayName);
            GameRegistry.registerBlock(this, SimpleItemSlab.class, addon.getDescription().getIdentifier() + "_" + identifier);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    public IIcon getIcon(int side, int type) {
        switch (side) {
            case 0:
                return bottomIcon;
            case 1:
                return topIcon;
            default:
                return sideIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister icon) {
        bottomIcon = icon.registerIcon(getTextureName() + "_bottom");
        sideIcon = icon.registerIcon(getTextureName() + "_side");
        topIcon = icon.registerIcon(getTextureName() + "_top");
    }

    @Override
    public String func_150002_b(int var1) {
        return getUnlocalizedName();
    }

    @Override
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(singleSlab);
    }
    
    public Item getItem(Location loc) {
        return this.getItem(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
    }

    @Override
    public Item getItemDropped(int val1, Random random, int val2) {
        return Item.getItemFromBlock(singleSlab);
    }

    public SimpleSlab getDoubleBlock() {
        return doubleSlab;
    }

    public final Addon getAddon() {
        return addon;
    }

    public final String getIdentifier() {
        return identifier;
    }

    @Override
    public final String getLocalizedName() {
        return I18n.format(getUnlocalizedName() + ".name");
    }

    @Override
    public final String getUnlocalizedName() {
        return addon.getDescription().getIdentifier() + ".tile.block." + identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleSlab)) {
            return false;
        }

        final SimpleSlab that = (SimpleSlab) o;

        return addon.equals(that.addon) && identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        int result = addon.hashCode();
        result = 31 * result + identifier.hashCode();
        return result;
    }

    protected static class SimpleDoubleSlab extends SimpleSlab {
        public SimpleDoubleSlab(SimpleSlab singleSlab, String displayName) {
            super(singleSlab.getAddon(), singleSlab.getIdentifier() + "_double", displayName, singleSlab.getMaterial(), false, true);
            GameRegistry.registerBlock(this, SimpleItemSlab.class, singleSlab.getAddon().getDescription().getIdentifier() + "_" + singleSlab.getIdentifier() + "_double");
        }
    }

    protected static class SimpleItemSlab extends ItemSlab {
        public SimpleItemSlab(Block block) {
            super(block, (SimpleSlab) block, doubleSlab, false);
        }
    }
}
