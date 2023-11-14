package de.mortis.inventories;

import de.mortis.items.templates.gui.InventoryFillerItem;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@Getter
public abstract class TempestInventory {

    private String identifier, title;
    private int size;

    private Inventory inventory;

    /**
     * Integer = Page
     * ItemStack = Item
     */
    private HashMap<Integer, ItemStack> inventoryItems;

    private Boolean needNavigation;

    public TempestInventory(String identifier, Integer size, String title) {
        this.identifier = identifier;
        this.size = size;
        this.title = title;

        this.inventory = Bukkit.createInventory(null, size, title);
        this.inventoryItems = new HashMap<>();

        for (int i = 0; i < size; i++) {
            this.inventory.setItem(i, new InventoryFillerItem().getItemStack());
        }
    }

    public void addNavigation() {
        if (needNavigation) {
            this.inventoryItems.put(size, new ItemStackBuilder(Material.ARROW).build());
            this.inventoryItems.put(49, new ItemStackBuilder(Material.BARRIER).build());
            this.inventoryItems.put(50, new ItemStackBuilder(Material.ARROW).build());
        }
    }

    public void placeItem(Integer slot, ItemStack itemStack) {
        inventoryItems.put(calculatePage(slot), itemStack);
        needNavigation = calculatePage(slot) >= 1;
        addNavigation();
    }

    protected int calculatePage(Integer itemSlot) {
        return Math.round(itemSlot / size);
    }

    public void openInventory(Player player) {
        player.openInventory(this.inventory);
    }
}
