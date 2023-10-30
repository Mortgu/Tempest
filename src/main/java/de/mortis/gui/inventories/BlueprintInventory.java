package de.mortis.gui.inventories;

import de.mortis.Main;
import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.items.templates.gui.InventoryBackItem;
import de.mortis.items.templates.gui.main.*;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@Getter
public class BlueprintInventory extends GraphicalUserInterface {

    private final Main plugin = Main.getInstance();
    private Player player;

    public BlueprintInventory() {
        super(54, "Tempest Blueprints", InventoryIdentifiers.BLUEPRINT);

        for (int j = 0; j < 4; j++) {
            for (int i = 10; i < 17; i++) {
                addButton(i + (9*j), new ItemStackBuilder(Material.AIR).build());
            }
        }
        addButton(17, new ItemStackBuilder(Material.GOLD_BLOCK).setDisplayName("§eCreate item").build());
        addButton(48, new InventoryBackItem().getItemStack());
        addButton(50, new ItemStackBuilder(Material.ARROW).setDisplayName("§bNext").build());
    }
}