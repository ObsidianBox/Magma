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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.lang.Languages;
import org.obsidianbox.magma.util.Location;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

/**
 * 
 * @author bensku
 *
 */
public class SimpleDoublePlant extends BlockDoublePlant {
    private final Addon addon;
    private final String identifier;

    public SimpleDoublePlant(Addon addon, String identifier, String displayName, Material material, boolean showInCreativeTab) {
        throw new UnsupportedOperationException("Work in progress, textures not working yet.");
        
        //this.addon = addon;
        //this.identifier = identifier;
        
        //setBlockName(addon.getDescription().getIdentifier() + ".tile.block." + identifier);
        //GameRegistry.registerBlock(this, addon.getDescription().getIdentifier() + "_" + identifier);
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    
    /**
     * Updates the blocks bounds based on its current state.
     */
    public void setBlockBoundsBasedOnState(Location loc) {
        this.setBlockBoundsBasedOnState(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
    }
    
    /**
     * Gets metadata of doubleplant.
     * @param blockAccess
     * @param x
     * @param y
     * @param z
     * @return metadata of block
     */
    public int getBlockMetadata(IBlockAccess blockAccess, int x, int y, int z) {
        return this.func_149885_e(blockAccess, x, y, z);
    }
    
    public int getBlockMetadata(Location loc) {
        return this.getBlockMetadata(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates
     * @return can block placed
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return super.canPlaceBlockAt(world, x, y, z);
    }
    
    /**
     * Checks to see if its valid to put this block at the specified coordinates
     * @return can block placed
     */
    public boolean canPlaceBlockAt(Location loc) {
        return this.canPlaceBlockAt(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
    }

    /**
     * Checks if the block can stay, if not drop as item
     */
    protected void checkAndDropBlock(World world, int x, int y, int z) {
        if (!this.canBlockStay(world, x, y, z))
        {
            int l = world.getBlockMetadata(x, y, z);

            if (!func_149887_c(l))
            {
                this.dropBlockAsItem(world, x, y, z, l, 0);

                if (world.getBlock(x, y + 1, z) == this)
                {
                    world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
                }
            }

            world.setBlock(x, y, z, Blocks.air, 0, 2);
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) != this) return super.canBlockStay(world, x, y, z); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        int l = world.getBlockMetadata(x, y, z);
        return func_149887_c(l) ? world.getBlock(x, y - 1, z) == this : world.getBlock(x, y + 1, z) == this && super.canBlockStay(world, x, y, z);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        if (func_149887_c(p_149650_1_))
        {
            return null;
        }
        else
        {
            int k = func_149890_d(p_149650_1_);
            return k != 3 && k != 2 ? Item.getItemFromBlock(this) : null;
        }
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess blockAccess, int x, int y, int z) {
        int l = this.getBlockMetadata(blockAccess, x, y, z);
        return l != 2 && l != 3 ? 16777215 : blockAccess.getBiomeGenForCoords(x, z).getBiomeGrassColor(x, y, z);
    }
    
    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(Location loc) {
        return this.colorMultiplier(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
    }
    
    /**
     * Places double plant to the given location. From World.setBlock javadoc:
     * Flag 1 will cause a block update. 
     * Flag 2 will send the change to clients (you almost always want this). 
     * Flag 4 prevents the block from being re-rendered, if this is a client world. 
     * Flags can be added together
     * @param world
     * @param x
     * @param y
     * @param z
     * @param metadata
     * @param flags
     */
    public void placeDoublePlant(World world, int x, int y, int z, int metadata, int flags) {
        world.setBlock(x, y, z, this, metadata, flags);
        world.setBlock(x, y + 1, z, this, 8, flags);
    }
    
    /**
     * Places double plant to the given location. From World.setBlock javadoc:
     * Flag 1 will cause a block update. 
     * Flag 2 will send the change to clients (you almost always want this). 
     * Flag 4 prevents the block from being re-rendered, if this is a client world. 
     * Flags can be added together
     * @param world
     * @param x
     * @param y
     * @param z
     * @param metadata
     * @param flags
     */
    public void placeDoublePlant(Location loc, int metadata, int flags) {
        this.placeDoublePlant(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), metadata, flags);
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemStack) {
        int l = ((MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        world.setBlock(x, y + 1, z, this, 8 | l, 2);
    }
    
    public void onBlockPlacedBy(Location loc, EntityLivingBase placer, ItemStack itemStack) {
        this.onBlockPlacedBy(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), placer, itemStack);
    }
    
    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int dmgValue) {
        super.harvestBlock(world, player, x, y, z, dmgValue);
        this.harvestBlock(new Location(world, x, y, z), player, dmgValue);
    }
    
    /**
     * Called when the player destroys a block with an item that can harvest it.
     */
    public void harvestBlock(Location loc, EntityPlayer player, int dmgValue) {
        this.harvestBlock(loc.getWorld(), player, (int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), dmgValue);
    }
    
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int p_149681_5_, EntityPlayer player) {
        super.onBlockHarvested(world, x, y, z, p_149681_5_, player);
        this.onBlockHarvested(new Location(world, x, y, z), p_149681_5_, player);
    }
    
    /**
     * Called when the block is attempted to be harvested
     * @param loc
     * @param i
     * @param player
     */
    public void onBlockHarvested(Location loc, int i, EntityPlayer player) {
        super.onBlockHarvested(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), i, player);
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    @Override
    public int getDamageValue(World world, int x, int y, int z) {
        return super.getDamageValue(world, x, y, z);
    }
    
    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(Location loc) {
        return this.getDamageValue(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
    }
}