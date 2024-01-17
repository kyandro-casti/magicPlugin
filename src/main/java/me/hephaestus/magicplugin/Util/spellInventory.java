package me.hephaestus.magicplugin.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.hephaestus.magicplugin.Util.MagicWand.magicwand;

public class spellInventory {
    private void items(){
        ItemStack wand = magicwand();
    }

    public static Inventory spellsInventory(Player p){
        Inventory invent = Bukkit.createInventory(p, 45, "Spells");
        invent.setItem(22, magicwand());
        ItemStack customSpells = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta customMeta = customSpells.getItemMeta();
        customMeta.setDisplayName("Custom spells");
        customSpells.setItemMeta(customMeta);
        invent.setItem(21, customSpells);
        ItemStack spells = new ItemStack(Material.MUSIC_DISC_13);
        ItemMeta spellsMeta = spells.getItemMeta();
        spellsMeta.setDisplayName("Spells");
        spells.setItemMeta(spellsMeta);
        invent.setItem(23, spells);

        p.openInventory(invent);
        return invent;
    }
}
