package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

        if (clickedItem == null) {
            event.setCancelled(true);
            return;
        }

        ItemOriginTypes originType = ItemOriginTypes.valueOf(plugin.getTempestItemManager().getItemOriginType(clickedItem));

        if (inventoryAction.equals(InventoryAction.HOTBAR_SWAP) ||
                event.getClick().equals(ClickType.NUMBER_KEY) ||
                originType.equals(ItemOriginTypes.GUI)) {
            event.setCancelled(true);
            player.updateInventory();
        }

        ActionTypes actionType = plugin.getTempestItemManager().getActionKeyOfItem(clickedItem);
        String actionValue = plugin.getTempestItemManager().getActionValueOfItem(clickedItem);

        if (actionType != null) {
            actionType.onTrigger(player, actionValue);
            GuiTypes guiTypes = GuiTypes.valueOf(plugin.getTempestItemManager().getItemType(clickedItem));
        }
    }

    @EventHandler
    public void onCreativeInventoryClick(InventoryCloseEvent event) {}
}
