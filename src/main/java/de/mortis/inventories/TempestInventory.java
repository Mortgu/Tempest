package de.mortis.inventories;

import de.mortis.items.templates.gui.InventoryBackItem;
import de.mortis.items.templates.gui.InventoryCloseItem;
import de.mortis.items.templates.gui.InventoryFillerItem;
import de.mortis.items.templates.gui.InventoryNextItem;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@Getter
public abstract class TempestInventory {

    private final String identifier, title;
    private int size, currentPageIndex = 0, pageCount;

    private Inventory inventory;

    /**
     * Integer = Page
     * ItemStack = Item
     */
    private HashMap<Integer, InventoryItem> inventoryPages;
    private HashMap<Integer, ItemStack> inventoryControls;

    private Boolean needNavigation = false;

    public TempestInventory(String identifier, Integer size, String title) {
        this.identifier = identifier;
        this.size = size;
        this.title = title;

        this.inventory = Bukkit.createInventory(null, size, title);

        this.inventoryPages = new HashMap<>();
        this.inventoryControls = new HashMap<>();

        // RENDER DEFAULT EMPTY SLOTS
        for (int i = 0; i < size; i++) {
            this.inventory.setItem(i, new InventoryFillerItem().getItemStack());
        }

        // ALWAYS RENDER CLOSE BUTTON
        this.inventory.setItem(49, new InventoryCloseItem().getItemStack());
    }

    public void renderNavigation() {
        if (currentPageIndex > 0) {
            this.inventory.setItem(48, new InventoryBackItem().getItemStack());
        }
        if (currentPageIndex < pageCount) {
            this.inventory.setItem(50, new InventoryNextItem().getItemStack());
        }
    }

    public void renderPage(Integer pageIndex) {
        Bukkit.getConsoleSender().sendMessage("§f----");
        inventoryPages.forEach((key, value) -> {
            if (key > this.pageCount) {
                this.pageCount = key;
            }

            Bukkit.getConsoleSender().sendMessage("§aPage=" + key + ", Slot=" + value.getSlot() + ", Item=" + value.getItemStack().getType().toString() + ", PageCount=" + this.pageCount);

            if (key == pageIndex) {
                this.inventory.setItem(value.getSlot(), value.getItemStack());
            }
        });
        Bukkit.getConsoleSender().sendMessage("§f----");
        renderNavigation();
    }

    public void placeItem(Integer slot, ItemStack itemStack) {
        this.inventoryPages.put(calculatePage(slot), new InventoryItem(calculateSlot(slot), itemStack));
        renderPage(currentPageIndex);
    }

    protected int calculatePage(Integer itemSlot) {
        return Math.round(itemSlot / (size - 9));
    }

    protected int calculateSlot(Integer itemSlot) {
        return itemSlot & (size - 9);
    }

    public void openInventory(Player player) {
        player.openInventory(this.inventory);
    }
}
