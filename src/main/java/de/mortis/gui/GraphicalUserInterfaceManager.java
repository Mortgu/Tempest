package de.mortis.gui;

import de.mortis.Main;
import de.mortis.managers.PluginManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
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

        registerInterface(getClass().getPackage().getName());
    }

    public void openGraphicalUserInterfaceByIdentifier(Player player, InventoryIdentifiers inventoryIdentifier) {
        if (!registeredInventories.containsKey(inventoryIdentifier)) {
            player.openInventory(Bukkit.createInventory(null, 54, "Kein Inventar gefunden!"));
            return;
        }

        player.openInventory(registeredInventories.get(inventoryIdentifier));
        plugin.getGraphicalUserInterfaceManager().getCurrentlyOpenInventories().add(registeredInventories.get(inventoryIdentifier));
    }

    public void registerInterface(String packageName) {
        for (Class<? extends GraphicalUserInterface> clazz : new Reflections(packageName + ".inventories").getSubTypesOf(GraphicalUserInterface.class)) {
            try {
                GraphicalUserInterface graphicalUserInterface = clazz.getDeclaredConstructor().newInstance();
                registeredInventories.put(graphicalUserInterface.getInventoryIdentifier(), graphicalUserInterface.getInventory());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
