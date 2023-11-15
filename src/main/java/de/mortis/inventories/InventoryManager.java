package de.mortis.inventories;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class InventoryManager {

    @Getter
    public HashMap<String, TempestInventory> registeredInventories;

    public InventoryManager() {
        registeredInventories = new HashMap<>();

        registerInventories(getClass().getPackage().getName());
    }

    public void registerInventories(String packageName) {
        for (Class<? extends TempestInventory> clazz : new Reflections(packageName + ".templates").getSubTypesOf(TempestInventory.class)) {
            try {
                TempestInventory tempestInventory = clazz.getDeclaredConstructor().newInstance();
                this.registeredInventories.put(tempestInventory.getIdentifier(), tempestInventory);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void renderNextInventoryPage(String identifier) {
        registeredInventories.get(identifier).renderPage(registeredInventories.get(identifier).getCurrentPageIndex() + 1);
    }

    public void openInventory(Player player, String identifier) {
        registeredInventories.get(identifier).openInventory(player);
    }
}
