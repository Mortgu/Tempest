package de.mortis.gui;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
public class GraphicalUserInterface {

    // Main instance
    private final Main plugin = Main.getInstance();

    private final Inventory inventory;

    public GraphicalUserInterface(int size, String inventoryTitle) {
        inventory = Bukkit.createInventory(null, size, inventoryTitle);

        ItemStack inventoryFillerItem = new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayName(" ")
                .build();
        plugin.getCustomItemManager().setTypeOfItem(inventoryFillerItem, ItemTypes.MENU_ITEM);

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, inventoryFillerItem);
        }
    }

    public void addButton(int slotPosition, ItemStack itemStack, Inventory targetInventory) {
        this.inventory.setItem(slotPosition, itemStack);
    }

    public Inventory build() {
        return inventory;
    }
}
