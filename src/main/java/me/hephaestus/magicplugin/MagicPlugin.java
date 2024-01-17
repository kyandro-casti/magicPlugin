package me.hephaestus.magicplugin;

import me.hephaestus.magicplugin.Commands.setSpells;
import me.hephaestus.magicplugin.Listener.joinFirstTime;
import me.hephaestus.magicplugin.Listener.useMagic;
import me.hephaestus.magicplugin.Spells.fireBall;
import me.hephaestus.magicplugin.Spells.wolfSummon;
import me.hephaestus.magicplugin.Util.MagicWand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicPlugin extends JavaPlugin {
    public static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        fireBall.initialize(this);
        wolfSummon.initialize(this);
        getServer().getPluginManager().registerEvents(new joinFirstTime(), this);
        getServer().getPluginManager().registerEvents(new useMagic(), this);
        getCommand("spells").setExecutor(new setSpells());
    }
}
