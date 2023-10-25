package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryDragListener implements Listener {
    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryDrag(InventoryMoveItemEvent event) {
        ItemStack itemStack = event.getItem();

        if (itemStack == null)
            return;

        ItemTypes itemType = plugin.getCustomItemManager().getTypeOfItem(itemStack);

        if (itemType != null) {
            itemType.onInventoryDrag(event);
        }
    }

}
