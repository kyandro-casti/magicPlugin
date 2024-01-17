package me.hephaestus.magicplugin.Listener;

import me.hephaestus.magicplugin.Util.inventUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


import static me.hephaestus.magicplugin.MagicPlugin.logger;
import static me.hephaestus.magicplugin.Util.MagicWand.magicwand;

public class joinFirstTime implements Listener {
    public void items(){
        ItemStack wands = magicwand();
    }
    @EventHandler
    public void join (PlayerJoinEvent event){
        Player p = event.getPlayer();
        boolean hasWand = inventUtil.hasItem(p, magicwand());
        if(hasWand){
            p.sendMessage("Welcome back");
        }else{
            p.getInventory().addItem(magicwand());
        }
    }
}
