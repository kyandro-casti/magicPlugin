package me.hephaestus.magicplugin.Util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicWand {
    public static ItemStack magicwand(){
        ItemStack Wand = new ItemStack(Material.STICK);
        ItemMeta wandMeta = Wand.getItemMeta();
        List<String> wandLore = new ArrayList<>();
        wandLore.add("has magical properties");
        wandLore.add("to help use magic");
        wandMeta.setLore(wandLore);
        wandMeta.setUnbreakable(true);
        wandMeta.setDisplayName("magic wand");
        wandMeta.addEnchant(Enchantment.LURE, 1, false);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Wand.setItemMeta(wandMeta);

        return Wand;
    }
}
