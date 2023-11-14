package de.mortis.inventories;

import de.mortis.gui.InventoryIdentifiers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class TempestInventoryManager {

    public TempestInventoryManager() {
        Bukkit.getConsoleSender().sendMessage("TempestInventoryManager");
    }

    public void openInventory(Player player, String identifier) {

    }

    public static void registerInventories(String packageName) {
        for (Class<? extends TempestInventory> clazz : new Reflections(packageName + ".templates").getSubTypesOf(TempestInventory.class)) {
            try {
                TempestInventory tempestInventory = clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
