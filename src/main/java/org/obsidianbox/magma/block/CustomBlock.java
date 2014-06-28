/**
 * This file is part of Obsidian, licensed under the MIT License (MIT).
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

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import org.obsidianbox.magma.Game;
import org.obsidianbox.magma.Materials;
import org.obsidianbox.magma.addon.Addon;
import org.obsidianbox.magma.block.renderer.BlockRenderer;
import org.obsidianbox.magma.block.renderer.SimpleOBJRenderer;
import org.obsidianbox.magma.lang.Languages;

public class CustomBlock extends Block {
    private final Addon addon;
    private final String identifier;
    private final RenderingType type;

    public CustomBlock(Addon addon, String identifier, String displayName, boolean showInCreativeTab) {
        this(addon, identifier, displayName, showInCreativeTab, RenderingType.DEFAULT);
    }

    public CustomBlock(Addon addon, String identifier, String displayName, boolean showInCreativeTab, RenderingType type) {
        super(Materials.CUSTOM_BLOCK);
        this.addon = addon;
        this.identifier = identifier;
        this.type = type;

        setBlockName(addon.getDescription().getIdentifier() + ".tile.block." + identifier);
        setBlockTextureName(addon.getDescription().getIdentifier() + ":" + identifier);
        addon.getGame().getLanguages().put(addon, Languages.ENGLISH_AMERICAN, "tile.block." + identifier + ".name", displayName);
        if (showInCreativeTab) {
            setCreativeTab(addon.getGame().getTabs());
        }
        GameRegistry.registerBlock(this, addon.getDescription().getIdentifier() + "_" + identifier);

        // TODO IF RenderingType.OBJ, get block renderer and add to it
        if (type == RenderingType.OBJ) {
            BlockRenderer blockRenderer = addon.getGame().getBlockRenderer();
            blockRenderer.put(addon, identifier, this);
        }
    }

    @Override
    public int getRenderType() {
        if (type != RenderingType.DEFAULT) {
            return addon.getGame().getBlockRenderer().getRenderId();
        }
        return super.getRenderType();
    }

    @Override
    public boolean renderAsNormalBlock() {
        if (type != RenderingType.DEFAULT) {
            return true;
        }
        return false;
    }

    @Override
    public final String getLocalizedName() {
        return I18n.format(getUnlocalizedName() + ".name");
    }

    @Override
    public final String getUnlocalizedName() {
        return addon.getDescription().getIdentifier() + ".tile.block." + identifier;
    }

    public final Addon getAddon() {
        return addon;
    }

    public final String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomBlock)) {
            return false;
        }

        final CustomBlock that = (CustomBlock) o;

        return addon.equals(that.addon) && identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        int result = addon.hashCode();
        result = 31 * result + identifier.hashCode();
        return result;
    }
}
