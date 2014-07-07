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
package org.obsidianbox.magma.block.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.opengl.*;

import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.block.SimpleBlock;

/**
 * A simple renderer that renders a {@link net.minecraftforge.client.model.obj.WavefrontObject} (.obj) and texture
 */
@SideOnly(Side.CLIENT)
public class SimpleBlockOBJRenderer extends BlockRenderer {
    private final WavefrontObject model;
    private static final Tessellator TESSELLATOR = Tessellator.instance;

    public SimpleBlockOBJRenderer(Addon addon, int renderID, ResourceLocation modelLocation) {
        super(addon, renderID);
        final IModelCustom temp = AdvancedModelLoader.loadModel(modelLocation);
        if (!(temp instanceof WavefrontObject)) {
            throw new IllegalArgumentException("SimpleBlockOBJRenderer is only for WaveFrontObjects (.obj)!");
        }
        model = (WavefrontObject) temp;
    }

    /**
     * Creates a renderer using properties from a {@link org.obsidianbox.magma.block.SimpleBlock}
     *
     * This will also set the render type for that block
     */
    public SimpleBlockOBJRenderer(Addon addon, int renderID, SimpleBlock block) {
        super(addon, renderID);
        final IModelCustom temp = AdvancedModelLoader.loadModel(new ResourceLocation(addon.getDescription().getIdentifier(), "models/blocks/" + block.getIdentifier() + ".obj"));
        if (!(temp instanceof WavefrontObject)) {
            throw new IllegalArgumentException("SimpleBlockOBJRenderer is only for WaveFrontObjects (.obj)!");
        }
        model = (WavefrontObject) temp;
        block.setRenderType(renderID);
    }

    /**
     * Performs complex rendering on an inventory {@link net.minecraft.block.Block}
     *
     * Only fires if {@link org.obsidianbox.magma.block.renderer.SimpleBlockOBJRenderer#shouldRender3DInInventory(int)} returns true
     * @param block Block being rendered
     * @param metadata Metadata of the block
     * @param modelId
     * @param renderer The block renderer of Minecraft
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        GL11.glPushMatrix();
        model.renderAll();
        GL11.glPopMatrix();
    }

    /**
     * Performs complex rendering of a {@link net.minecraft.block.Block} in the world.
     *
     * @param world {@link net.minecraft.world.World} the block is in
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param z The z-coordinate
     * @param block The block being rendered
     * @param modelId
     * @param renderer The block renderer of Minecraft
     * @return True to perform rendering, false to skip this pass
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        TESSELLATOR.addTranslation(x, y, z);
        if (block.getIcon(0, 0) == null) {
            addon.getGame().getLogger().error("Addon [" + addon.getDescription().getIdentifier() + "] is rendering a block with a null icon!");
        }
        model.tessellateAll(TESSELLATOR);
        TESSELLATOR.addTranslation(-x, -y, -z);
        return true;
    }

    /**
     * Returns if this renderer should perform complex rendering on the {@link net.minecraft.block.Block} in the inventory
     * @param modelId
     * @return True to perform complex rendering, false if not
     */
    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    public WavefrontObject getModel() {
        return model;
    }
}
