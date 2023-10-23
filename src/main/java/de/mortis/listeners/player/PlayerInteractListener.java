package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.ItemAbilities;
import de.mortis.items.ItemTypes;
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

        if (itemStack == null)
            return;

        ItemTypes itemType = plugin.getCustomItemManager().getTypeOfItem(itemStack);
        ItemAbilities itemAbility = plugin.getCustomItemManager().getItemAbility(itemStack);

        if (itemAbility == null)
            return;

        if (itemType != null) {
            itemType.onInteract(event);
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            itemAbility.onTrigger(player, event);
        }
    }
}
