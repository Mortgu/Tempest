package de.mortis.inventories;

import de.mortis.inventories.types.DynamicInventory;
import org.bukkit.Bukkit;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class TempestInventoryManager {

    public TempestInventoryManager() {
        registerInventories(getClass().getPackage().getName());
    }

    private void registerInventories(String packageName) {
        for (Class<? extends TempestInventory> clazz : new Reflections(packageName + ".templates").getSubTypesOf(TempestInventory.class)) {
            try {
                TempestInventory tempestInventory = clazz.getDeclaredConstructor().newInstance();
                tempestInventory.convertToDynamicInventory(clazz.isAnnotationPresent(DynamicInventory.class));
                Bukkit.getConsoleSender().sendMessage("§a" + clazz.isAnnotationPresent(DynamicInventory.class));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
