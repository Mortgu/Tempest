package de.mortis.inventories.templates.levels;

import de.mortis.inventories.TempestInventory;

public class PlayerLevelInventory extends TempestInventory {

    public PlayerLevelInventory(String inventoryIdentifier, Integer size, String title) {
        super("PLAYER_LEVELS", 54, "Tempest Level's");

        super.createSubInventory();
    }
}
