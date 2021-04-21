package org.pixel.kitpvpinvclear;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("Enabled ClearInv v1.0.0");
        PluginManager pmger = this.getServer().getPluginManager();
        DeathListener listener = new DeathListener();
        pmger.registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Disabled ClearInv v1.0.0");
    }

    public class DeathListener implements Listener {
        @EventHandler
        public void onEvent(PlayerRespawnEvent event) {
            Player player = event.getPlayer();
            String world = player.getWorld().getName();

            if(world.equals("pvp")) {
                player.getInventory().clear();
            }
        }
    }

}
