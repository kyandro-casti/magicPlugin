package me.hephaestus.magicplugin.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static me.hephaestus.magicplugin.MagicPlugin.logger;
import static me.hephaestus.magicplugin.Util.MagicWand.magicwand;

public class useMagic implements Listener {
    public void items(){
        ItemStack wand = magicwand();
    }
    @EventHandler
    public void usemagic (PlayerInteractEvent event){
        Player p = event.getPlayer();
        Action action = event.getAction();
        if(p.getInventory().getItemInMainHand().equals(magicwand())){
            if (action == Action.LEFT_CLICK_AIR){
                p.sendMessage("you've left clicked");
            }
        }
    }
}
