package de.mortis.inventories.templates;

import de.mortis.inventories.TempestInventory;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Material;

public class PlayerLevelInventory extends TempestInventory {

    public PlayerLevelInventory() {
        super("PLAYER_LEVELS", 54, "Levels");

        super.placeItem(53, new ItemStackBuilder(Material.DIAMOND_SWORD).build());
        super.placeItem(198, new ItemStackBuilder(Material.DIAMOND_SWORD).build());
    }
}
