package de.mortis.inventories;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

@Getter
public abstract class TempestInventory {

    private String inventoryIdentifier;

    private int inventorySize;
    private String inventoryTitle;

    @Setter
    private Inventory inventory;
    private ArrayList<Inventory> subInventories;

    public TempestInventory(String inventoryIdentifier, Integer size, String title) {
        this.inventoryIdentifier = inventoryIdentifier;
        this.inventorySize = size;
        this.inventoryTitle = title;
        this.inventory = Bukkit.createInventory(null, size, title);
        this.subInventories = new ArrayList<>();
    }

    public void createSubInventory() {
        this.subInventories.add(Bukkit.createInventory(null, inventorySize, inventoryTitle));
    }

    public void openInventory(Player player) {}
}
