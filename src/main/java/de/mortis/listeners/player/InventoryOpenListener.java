package de.mortis.listeners.player;

import de.mortis.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryOpenListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getType().equals(InventoryType.CRAFTING)) return;

        plugin.getGraphicalUserInterfaceManager().getCurrentlyOpenInventories().add(inventory);
        event.getPlayer().sendMessage(event.getInventory().getType().toString() + " " + String.valueOf(plugin.getGraphicalUserInterfaceManager().getCurrentlyOpenInventories().size()));
    }
}
