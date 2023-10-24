package de.mortis.gui;

import de.mortis.Main;
import de.mortis.managers.PluginManager;
import lombok.Getter;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class GraphicalUserInterfaceManager extends PluginManager {

    private final HashMap<InventoryIdentifiers, Inventory> registeredInventories;
    private final ArrayList<Inventory> currentlyOpenInventories;

    public GraphicalUserInterfaceManager(Main plugin) {
        super(plugin);

        registeredInventories = new HashMap<>();
        currentlyOpenInventories = new ArrayList<>();
    }

    public void registerInterface(InventoryIdentifiers inventoryIdentifier, Inventory inventory) {
        registeredInventories.put(inventoryIdentifier, inventory);
    }
}
