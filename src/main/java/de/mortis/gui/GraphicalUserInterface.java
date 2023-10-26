package de.mortis.gui;

import de.mortis.Main;
import de.mortis.items.templates.gui.InventoryBackItem;
import de.mortis.items.templates.gui.InventoryCloseItem;
import de.mortis.items.templates.gui.InventoryFillerItem;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class GraphicalUserInterface {

    // Create a new instance of the main class
    private final Main plugin = Main.getInstance();

    private final Inventory inventory;
    private final InventoryIdentifiers inventoryIdentifier;

    private final ItemStack closeItem = new ItemStackBuilder(Material.BARRIER)
            .setDisplayName("§cClose").build();

    private final ItemStack backItem = new ItemStackBuilder(Material.ARROW)
            .setDisplayName("§aBack").build();

    public GraphicalUserInterface(int size, String inventoryTitle, InventoryIdentifiers inventoryIdentifier) {
        this.inventoryIdentifier = inventoryIdentifier;

        // Initialize the required inventory.
        inventory = Bukkit.createInventory(null, size, inventoryTitle);

        /*
        Creates the ItemStack of the item that fills in the blank spaces.
        Uses the custom ItemStackBuilder class for construction.
        TODO: MAKE THE FUNCTION "setTypeOfItem" functional.
         */

        // Fills in every slot in inventory by default.
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, new InventoryFillerItem().getItemStack());
        }

        // Sets close button
        inventory.setItem(49, new InventoryCloseItem().getItemStack());
    }

    /*
    A button is an item in an inventory that has the ability to open another inventory
    TODO: MAKE "targetInventory" functional!
     */
    public void addButton(int slotPosition, ItemStack itemStack) {
        this.inventory.setItem(slotPosition, itemStack);
    }

    public void openInventory(Player player) {
        player.openInventory(this.getInventory());
        plugin.getGraphicalUserInterfaceManager().getCurrentlyOpenInventories().add(inventory);
        player.sendMessage(String.valueOf(plugin.getGraphicalUserInterfaceManager().getCurrentlyOpenInventories().size()));
    }
}
