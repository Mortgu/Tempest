package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.ItemAbilities;
import de.mortis.items.ItemTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null)
            return;

        ItemTypes itemType = plugin.getCustomItemManager().getTypeOfItem(clickedItem);
        ItemAbilities itemAbility = plugin.getCustomItemManager().getItemAbility(clickedItem);

        if (event.getAction() == InventoryAction.HOTBAR_SWAP && event.getClick() == ClickType.NUMBER_KEY) {
            event.setCancelled(true);
        }

        if (itemType != null) {
            itemType.onInventoryClick(event);
        }

        if (itemAbility != null) {
            itemAbility.onTrigger(player, event);
        }
    }

    @EventHandler
    public void onCreativeInventoryClick(InventoryCreativeEvent event) {
    }
}
