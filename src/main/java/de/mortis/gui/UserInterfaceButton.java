package de.mortis.gui;

import de.mortis.Main;
import de.mortis.items.ItemAbilities;
import de.mortis.items.ItemTypes;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class UserInterfaceButton {

    private final Main plugin = Main.getInstance();
    private final ItemStack itemStack;
    private final InventoryIdentifiers targetInventory;

    public UserInterfaceButton(ItemStack itemStack, InventoryIdentifiers targetInventory) {
        this.itemStack = itemStack;
        plugin.getCustomItemManager().setTypeOfItem(itemStack, ItemTypes.MENU_ITEM);

        if (targetInventory != null)
            plugin.getCustomItemManager().setItemStack(itemStack).setItemAbilities(ItemAbilities.valueOf(targetInventory.name()));

        this.targetInventory = targetInventory;
    }

    public String targetInventoryId() {
        return "";
    }
}
