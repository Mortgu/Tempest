package de.mortis.gui;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
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
    private final ItemStack inventoryFillerItem;
    private Player player;
    private final InventoryIdentifiers inventoryIdentifier;

    public GraphicalUserInterface(int size, String inventoryTitle, InventoryIdentifiers inventoryIdentifier) {
        this.inventoryIdentifier = inventoryIdentifier;

        // Initialize the required inventory.
        inventory = Bukkit.createInventory(null, size, inventoryTitle);

        /*
        Creates the ItemStack of the item that fills in the blank spaces.
        Uses the custom ItemStackBuilder class for construction.
        TODO: MAKE THE FUNCTION "setTypeOfItem" functional.
         */
        inventoryFillerItem = new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayName(" ").setTypeOfItem(ItemTypes.MENU_ITEM).build();

        /*
        Make so that the filler item can't be moved by the player
         */
        plugin.getCustomItemManager().setTypeOfItem(inventoryFillerItem, ItemTypes.MENU_ITEM);

        // Fills in every slot in inventory by default.
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, inventoryFillerItem);
        }
    }

    /*
    A button is an item in an inventory that has the ability to open another inventory
    TODO: MAKE "targetInventory" functional!
     */
    public void addButton(int slotPosition, ItemStack itemStack, InventoryIdentifiers targetInventory) {
        new UserInterfaceButton(itemStack, targetInventory);
        this.inventory.setItem(slotPosition, itemStack);
    }

    public void openInventory(Player player) {
        player.openInventory(this.getInventory());
    }

    public Inventory build() {
        return inventory;
    }
}
