package me.hephaestus.magicplugin.Spells;

import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.Plugin;

public class wolfSummon {
    private static Plugin plugin;

    public static void initialize(Plugin plugin) {
        wolfSummon.plugin = plugin;
    }

    public static void cast(Player caster) {
        int numberOfWolves = plugin.getConfig().getInt("abilities.InvocareLupus.wolfs");
        for (int i = 0; i < numberOfWolves; i++) {
            InvocareLupus(caster);
        }
    }
    public static void InvocareLupus(Player player){
        Wolf wolf = player.getWorld().spawn(player.getLocation(), Wolf.class);

        // Set the owner of the wolf to the caster
        wolf.setOwner(player);

        // Customize the wolf appearance or behavior if needed
        wolf.setCustomName(player.getName() + "'s Wolf");
        wolf.setCustomNameVisible(true);
    }
}
