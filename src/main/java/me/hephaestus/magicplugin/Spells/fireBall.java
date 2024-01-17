package me.hephaestus.magicplugin.Spells;

import me.hephaestus.magicplugin.MagicPlugin;
import me.hephaestus.magicplugin.Util.MagicWand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class fireBall {
    private static Plugin plugin;

    public static void initialize(Plugin plugin) {
        fireBall.plugin = plugin;
    }

    public static void castFireball(Player player) {
        if (plugin == null) {
            // Handle the case where the plugin hasn't been initialized properly
            return;
        }

        int shots = plugin.getConfig().getInt("abilities.Fireball.shots");
        double range = plugin.getConfig().getDouble("abilities.Fireball.range");
        double damage = plugin.getConfig().getDouble("abilities.Fireball.damage");

        Location eyeLocation = player.getEyeLocation();
        Vector direction = eyeLocation.getDirection();

        for (int i = 0; i < shots; i++) {
            // Calculate the position for the fire particle cluster
            Location particleLocation = eyeLocation.clone().add(direction.multiply(i * range / shots));

            // Spawn fire particles at the calculated position
            spawnFireParticles(particleLocation);

            // Apply damage to entities in the area
            applyDamage(eyeLocation, direction, damage);
        }
    }

    private static void spawnFireParticles(Location location) {
        // You can adjust the particle type and density as needed
        location.getWorld().spawnParticle(Particle.FLAME, location, 20, 0.2, 0.2, 0.2, 0.1);
    }

    private static void applyDamage(Location location, Vector direction, double damage) {
        // Define the radius within which entities will receive damage
        double radius = 2.0;

        // Get the entities within the specified radius from the location
        for (Entity entity : location.getWorld().getNearbyEntities(location, radius, radius, radius)) {
            // Check if the entity is a LivingEntity (e.g., a player or a mob)
            if (entity instanceof LivingEntity) {
                // Cast the entity to LivingEntity
                LivingEntity livingEntity = (LivingEntity) entity;

                // Apply damage to the entity
                livingEntity.damage(damage);

                // You can also perform additional actions, such as setting the entity on fire
                livingEntity.setFireTicks(20); // 20 ticks = 1 second
            }
        }
    }

}
