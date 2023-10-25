package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InventoryClickListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        @NotNull InventoryAction inventoryAction = event.getAction();

        if (clickedItem == null)
            return;

        OriginTypes originType = OriginTypes.valueOf(plugin.getTempestItemManager().getItemOriginType(clickedItem));
        if (originType == OriginTypes.GUI) event.setCancelled(true);

        if (inventoryAction == InventoryAction.HOTBAR_SWAP && event.getClick() == ClickType.NUMBER_KEY && originType == OriginTypes.GUI)
            event.setCancelled(true);

        ActionTypes actionType = plugin.getTempestItemManager().getActionKeyOfItem(clickedItem);
        String actionValue = plugin.getTempestItemManager().getActionValueOfItem(clickedItem);

        actionType.onTrigger(player, actionValue);
    }

    @EventHandler
    public void onCreativeInventoryClick(InventoryCloseEvent event) {
        event.getPlayer().sendMessage(event.getPlayer().getOpenInventory().getType().toString());
    }
}
