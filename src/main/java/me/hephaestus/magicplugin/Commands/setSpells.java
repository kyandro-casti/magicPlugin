package me.hephaestus.magicplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.hephaestus.magicplugin.Util.MagicWand.magicwand;

public class setSpells implements CommandExecutor{
    public void items(){
        ItemStack wands = magicwand();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            Inventory inventory = Bukkit.createInventory(p, 45, "Spell picking");
            inventory.setItem(22, magicwand());

            ItemStack Clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta clearMeta = Clear.getItemMeta();
            clearMeta.setDisplayName(ChatColor.GRAY + "Clear spot");
            Clear.setItemMeta(clearMeta);

            inventory.setItem(13, Clear);
            inventory.setItem(21, Clear);
            inventory.setItem(23, Clear);
            inventory.setItem(31, Clear);

            p.openInventory(inventory);

        }
        return true;
    }
}

