package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.types.gui.specifications.ActionTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();
        Action action = event.getAction();

        if (itemStack == null)
            return;

        ActionTypes actionType = plugin.getTempestItemManager().getActionKeyOfItem(itemStack);
        String actionValue = plugin.getTempestItemManager().getActionValueOfItem(itemStack);

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
            if (actionType == null) return;
            actionType.onTrigger(player, actionValue);
        }
    }
}
