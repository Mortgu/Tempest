package de.mortis.gui;

import de.mortis.Main;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class GraphicalUserInterfaceManager {

    private final Main plugin = Main.getInstance();

    private final HashMap<InventoryIdentifiers, GraphicalUserInterface> registeredInventories;

    private final ArrayList<Inventory> currentlyOpenInventories;

    public GraphicalUserInterfaceManager() {
        registeredInventories = new HashMap<>();

        currentlyOpenInventories = new ArrayList<>();

        registerInterface(getClass().getPackage().getName());
    }

    public void openByIdentifier(Player player, InventoryIdentifiers identifier) {
        if (!registeredInventories.containsKey(identifier)) {
            player.sendMessage("Inventory not found!");
            return;
        }
        registeredInventories.get(identifier).openInventory(player, registeredInventories.get(identifier).getInventory());
    }

    public void registerInterface(String packageName) {
        for (Class<? extends GraphicalUserInterface> clazz : new Reflections(packageName + ".inventories").getSubTypesOf(GraphicalUserInterface.class)) {
            try {
                GraphicalUserInterface graphicalUserInterface = clazz.getDeclaredConstructor().newInstance();
                registeredInventories.put(graphicalUserInterface.getInventoryIdentifier(), graphicalUserInterface);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
