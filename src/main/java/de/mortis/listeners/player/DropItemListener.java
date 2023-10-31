package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.types.ItemOriginTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropItemListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onPlayerDropItemListener(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItemDrop().getItemStack();

        ItemOriginTypes originTypes = ItemOriginTypes.valueOf(plugin.getTempestItemManager().getItemOriginType(itemStack));
        if (originTypes.equals(ItemOriginTypes.GUI)) event.setCancelled(true);
    }
}
