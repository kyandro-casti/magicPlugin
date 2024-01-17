package me.hephaestus.magicplugin.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class manMadeSpells {
    public static Inventory madeSpells(Player p){
        Inventory inventory = Bukkit.createInventory(p, 54, "Spells");
        ItemStack fireball = new ItemStack(Material.FIRE);
        ItemMeta ballMeta = fireball.getItemMeta();
        ballMeta.setDisplayName("Fireball");
        fireball.setItemMeta(ballMeta);
        inventory.setItem(0, fireball);

        ItemStack InvocareLupus = new ItemStack(Material.WOLF_SPAWN_EGG);
        ItemMeta wolfMeta = InvocareLupus.getItemMeta();
        wolfMeta.setDisplayName("InvocareLupus");
        InvocareLupus.setItemMeta(wolfMeta);
        inventory.setItem(1, InvocareLupus);

        p.openInventory(inventory);
        return inventory;
    }
}
