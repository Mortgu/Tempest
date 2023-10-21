package de.mortis.gui.inventories;

import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
public class GameMenuInventory {

    private final Inventory gameMenuInventory;

    /**
     * Game menu inventory Buttons
     */
    private final ItemStack PlayerHead = new ItemStackBuilder(Material.PLAYER_HEAD).build();
    private final ItemStack PlayerSkills = new ItemStackBuilder(Material.NETHERITE_SWORD).build();
    private final ItemStack PlayerCollections = new ItemStackBuilder(Material.ITEM_FRAME).build();
    private final ItemStack PlayerLevels = new ItemStackBuilder(Material.EMERALD).build();
    private final ItemStack PlayerQuests = new ItemStackBuilder(Material.WRITABLE_BOOK).build();
    private final ItemStack ServerEvents = new ItemStackBuilder(Material.CLOCK).build();
    private final ItemStack InventoryClose = new ItemStackBuilder(Material.BARRIER).build();

    public GameMenuInventory() {
        gameMenuInventory = Bukkit.createInventory(null, 54, "Tempest Menu");
    }

    public void initialize_buttons() {
        gameMenuInventory.setItem(13, PlayerHead);
    }
}
