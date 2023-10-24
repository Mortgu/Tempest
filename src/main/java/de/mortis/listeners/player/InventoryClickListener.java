package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.ItemAbilities;
import de.mortis.items.ItemTypes;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

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
    public void onCreativeInventoryClick(InventoryCloseEvent event) {
        event.getPlayer().sendMessage(event.getPlayer().getOpenInventory().getType().toString());
    }
}
