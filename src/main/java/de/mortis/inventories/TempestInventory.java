package de.mortis.inventories;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

@Getter
public abstract class TempestInventory {

    private String inventoryIdentifier;

    @Setter
    private Inventory defaultInventory, nextInventory, prevInventory;

    public TempestInventory(String inventoryIdentifier, Integer size, String title) {
        this.inventoryIdentifier = inventoryIdentifier;
        this.defaultInventory = Bukkit.createInventory(null, size, title);
    }
}
