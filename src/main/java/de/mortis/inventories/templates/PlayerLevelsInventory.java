package de.mortis.inventories.templates;

import de.mortis.inventories.types.DynamicInventory;
import de.mortis.inventories.TempestInventory;
import de.mortis.inventories.types.SubInventory;
import org.bukkit.inventory.Inventory;

@DynamicInventory
public class PlayerLevelsInventory extends TempestInventory {

    public PlayerLevelsInventory() {
        super(54, "Levels");
    }

    @SubInventory
    public Inventory pageTwo(Inventory inventory) {
        return super.createSubInventory();
    }
}
