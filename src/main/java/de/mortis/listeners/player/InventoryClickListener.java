package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.systems.gis.types.ItemTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null)
            return;

        ItemTypes itemType = plugin.getItemManager().getTypeOfItem(clickedItem);

        if (itemType != null) {
            itemType.onInventoryClick(event);
        }
    }
}
