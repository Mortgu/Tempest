package de.mortis.inventories;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class InventoryItem {

    private int slot;
    private ItemStack itemStack;

    public InventoryItem(int slot, ItemStack itemStack) {
        this.slot = slot;
        this.itemStack = itemStack;
    }
}
