package de.mortis.listeners.player;

import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.setGameMode(GameMode.SURVIVAL);

        Inventory playerInventory = player.getInventory();
        playerInventory.setItem(0, new ItemStackBuilder(Material.STONE).build());
    }
}
