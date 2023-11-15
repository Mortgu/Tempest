package de.mortis.inventories;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public abstract class TempestInventory {

    private final Integer inventorySize;
    private final String title;

    public boolean isDynamicInventory;

    @Getter
    private Inventory inventory;

    public TempestInventory(Integer size, String title) {
        this.inventorySize = size;
        this.title = title;

        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public void openInventory(Player player) { }

    public Inventory createSubInventory() {
        return Bukkit.createInventory(null, inventorySize, title);
    }

    public void convertToDynamicInventory(boolean value) {
        this.isDynamicInventory = value;
    }
}
