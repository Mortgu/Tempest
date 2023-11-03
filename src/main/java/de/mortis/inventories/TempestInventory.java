package de.mortis.inventories;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

@Getter
public abstract class TempestInventory {

    private String inventoryIdentifier;
    private Inventory defaultInventory;
    private HashMap<Integer, Inventory> inventoryPages;

    public TempestInventory(String inventoryIdentifier, Integer size, String title) {
        this.inventoryIdentifier = inventoryIdentifier;
        this.inventoryPages = new HashMap<>();
        this.defaultInventory = Bukkit.createInventory(null, size, title);
    }
}
