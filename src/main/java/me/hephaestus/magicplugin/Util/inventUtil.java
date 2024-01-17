package me.hephaestus.magicplugin.Util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class inventUtil {
    public static boolean hasItem(Player player, ItemStack item) {
        for (ItemStack stack : player.getInventory().getContents()) {
            if (stack != null && stack.isSimilar(item)) {
                // Item found in the player's inventory
                return true;
            }
        }
        // Item not found in the player's inventory
        return false;
    }
}
