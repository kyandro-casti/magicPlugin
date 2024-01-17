package me.hephaestus.magicplugin.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.hephaestus.magicplugin.Util.spellInventory.spellsInventory;

public class inventoryCLick implements Listener {
    private ItemStack glass(){
        ItemStack Clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta clearMeta = Clear.getItemMeta();
        clearMeta.setDisplayName(ChatColor.GRAY + "Clear spot");
        Clear.setItemMeta(clearMeta);
        return Clear;
    }

    private void inventory(Player p){
        Inventory inventory = spellsInventory(p);
    }
    @EventHandler
    public void slotsInventory (InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if(event.getView().getTitle().equals("Spell picking")){
            event.setCancelled(true);
        }if(event.getInventory().equals(Material.GRAY_STAINED_GLASS_PANE)){
            p.openInventory(spellsInventory(p));
        }if(event.getInventory().equals(Material.AIR)){
            p.sendMessage("please pick a slot");
        }if(event.isShiftClick() && clickedItem.getType() != Material.AIR && clickedItem.getType() != Material.GRAY_STAINED_GLASS_PANE){
            event.setCurrentItem(glass());
        }
    }
}
