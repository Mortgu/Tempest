package de.mortis.gui.inventories;

import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.items.templates.gui.stats.CombatStatItem;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PlayerStatsInventory extends GraphicalUserInterface {

    public PlayerStatsInventory() {
        super(54, "Tempest Stats", InventoryIdentifiers.TEST_MENU);

        addButton(12, new ItemStackBuilder(Material.AIR).build());
        addButton(21, new ItemStackBuilder(Material.AIR).build());
        addButton(30, new ItemStackBuilder(Material.AIR).build());
        addButton(39, new ItemStackBuilder(Material.AIR).build());

        // PLAYER ARMOR ROW
        addButton(11, new ItemStackBuilder(Material.AIR).build());
        addButton(20, new ItemStackBuilder(Material.AIR).build());
        addButton(29, new ItemStackBuilder(Material.AIR).build());
        addButton(38, new ItemStackBuilder(Material.AIR).build());

        // EQUIPMENT ROW
        addButton(10, new ItemStackBuilder(Material.AIR).build());
        addButton(19, new ItemStackBuilder(Material.AIR).build());
        addButton(28, new ItemStackBuilder(Material.AIR).build());
        addButton(37, new ItemStackBuilder(Material.AIR).build());
        
        addButton(15, new CombatStatItem().getItemStack());
        addButton(16, new ItemStackBuilder(Material.AIR).build());
        addButton(24, new ItemStackBuilder(Material.AIR).build());
        addButton(25, new ItemStackBuilder(Material.AIR).build());
    }
}
