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

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import org.obsidianbox.magma.Materials;
import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.lang.Languages;

public class CustomBlockFluid extends BlockFluidClassic {
    private final Addon addon;
    private final String identifier;
    private IIcon still, flowing;

    public CustomBlockFluid(Addon addon, String identifier, String displayName, boolean showInCreativeTab) {
        this(addon, identifier, displayName, showInCreativeTab, new CustomFluid(identifier));
    }

    public CustomBlockFluid(Addon addon, String identifier, String displayName, boolean showInCreativeTab, int luminosity, int density, int temperature, int viscosity, boolean isGaseous) {
        this(addon, identifier, displayName, showInCreativeTab, new CustomFluid(identifier, luminosity, density, temperature, viscosity, isGaseous));
    }

    public CustomBlockFluid(Addon addon, String identifier, String displayName, boolean showInCreativeTab, CustomFluid fluid) {
        super(fluid, Materials.CUSTOM_FLUID);
        this.addon = addon;
        this.identifier = identifier;

        setBlockName(addon.getDescription() + ".title.block" + identifier);
        setBlockTextureName(addon.getDescription().getIdentifier() + ":" + "fluids/" + identifier);
        addon.getGame().getLanguages().put(addon, Languages.ENGLISH_AMERICAN, "tile.block." + identifier + ".name", displayName);
        if (showInCreativeTab) {
            setCreativeTab(addon.getGame().getTabs());
        }
        GameRegistry.registerBlock(this, addon.getDescription().getIdentifier() + "_" + identifier);
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
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    @SideOnly (Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        still = iconRegister.registerIcon(getTextureName());
        flowing = iconRegister.registerIcon(getTextureName() + "_flow");
        getFluid().setIcons(still, flowing);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0:
                return still;
            case 1:
                return still;
            default:
                return flowing;
        }
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }
}

