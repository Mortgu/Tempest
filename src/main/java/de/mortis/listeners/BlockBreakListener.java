package de.mortis.listeners;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getItemInHand();

        ItemTypes type = plugin.getCustomItemManager().getTypeOfItem(itemStack);
        if (type != null) {
            type.onBlockBreak(event);
        }
    }
}
