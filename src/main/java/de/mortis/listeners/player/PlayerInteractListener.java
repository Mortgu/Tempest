package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.systems.gis.types.ItemTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (itemStack == null)
            return;

        ItemTypes itemType = plugin.getCustomItemManager().getTypeOfItem(itemStack);

        if (itemType != null) {
            itemType.onInteract(event);
        }
    }
}
