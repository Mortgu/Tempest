package de.mortis.inventories;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class TempestInventoryManager {

    public TempestInventoryManager() {

    }

    public static void registerPrimaryInventories(String packageName) {
        for (Class<? extends TempestInventory> clazz : new Reflections(packageName + ".templates").getSubTypesOf(TempestInventory.class)) {
            try {
                TempestInventory tempestInventory = clazz.getDeclaredConstructor().newInstance();

                if (tempestInventory.getPrevInventory() == null)
                    return;

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
