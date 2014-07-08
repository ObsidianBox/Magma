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
