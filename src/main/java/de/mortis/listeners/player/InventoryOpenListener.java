package de.mortis.listeners.player;

import com.gmail.nossr50.runnables.player.PlayerUpdateInventoryTask;
import de.mortis.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryOpenListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getType().equals(InventoryType.CRAFTING)) return;
    }

    @EventHandler
    public void onInventoryOpen(InventoryPickupItemEvent event) {
        Player player = (Player) event.getInventory().getHolder();
    }
}
