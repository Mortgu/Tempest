package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.types.OriginTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryDragListener implements Listener {
    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryDrag(InventoryMoveItemEvent event) {
        ItemStack itemStack = event.getItem();

        OriginTypes originType = OriginTypes.valueOf(plugin.getTempestItemManager().getItemOriginType(itemStack));
        if (originType == OriginTypes.GUI) event.setCancelled(true);
    }
}
