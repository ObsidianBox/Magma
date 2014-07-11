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
package org.obsidianbox.magma.block.fluid;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.lang.Languages;

public class SimpleBlockFluid extends BlockFluidClassic {
    private final Addon addon;
    private final String identifier;

    public SimpleBlockFluid(Addon addon, String identifier, String displayName, Material material, boolean showInCreativeTab) {
        this(addon, identifier, displayName, material, showInCreativeTab, new SimpleFluid(addon, identifier));
    }

    public SimpleBlockFluid(Addon addon, String identifier, String displayName, Material material, boolean showInCreativeTab, SimpleFluid fluid) {
        super(fluid, material);
        this.addon = addon;
        this.identifier = identifier;

        setBlockName(addon.getDescription() + ".title.block" + identifier);
        setBlockTextureName(addon.getDescription().getIdentifier() + ":fluids/" + identifier);
        addon.getGame().getLanguages().put(addon, Languages.ENGLISH_AMERICAN, "tile.block." + identifier + ".name", displayName);
        if (showInCreativeTab) {
            setCreativeTab(addon.getGame().getTabs());
        }
        GameRegistry.registerBlock(this, addon.getDescription().getIdentifier() + "_" + identifier);
    }

    @Override
    @SuppressWarnings ({"unchecked", "rawtypes"})
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    @SideOnly (Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        IIcon still = iconRegister.registerIcon(getTextureName());
        IIcon flowing = iconRegister.registerIcon(getTextureName() + "_flow");
        getFluid().setIcons(still, flowing);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0:
                return getFluid().getStillIcon();
            case 1:
                return getFluid().getStillIcon();
            default:
                return getFluid().getFlowingIcon();
        }
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.displaceIfPossible(world, x, y, z);
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleBlockFluid)) {
            return false;
        }

        final SimpleBlockFluid that = (SimpleBlockFluid) o;

        return addon.equals(that.addon) && identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        int result = addon.hashCode();
        result = 31 * result + identifier.hashCode();
        return result;
    }
}

