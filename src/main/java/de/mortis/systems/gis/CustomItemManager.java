package de.mortis.systems.gis;

import de.mortis.Main;
import de.mortis.systems.gis.types.ItemTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomItemManager {
    // https://www.spigotmc.org/threads/how-to-handle-custom-items.593039/

    private final NamespacedKey itemTypeKey;

    public CustomItemManager(Main plugin) {
        this.itemTypeKey = new NamespacedKey(plugin, "custom-item-type");
    }

    public void setTypeOfItem(ItemStack itemStack, ItemTypes itemType) {
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null)
            return;

        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(this.itemTypeKey, PersistentDataType.STRING, itemType.toString());
        itemStack.setItemMeta(itemMeta);
    }

    public ItemTypes getTypeOfItem(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null)
            return null;

        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        String typeValue = persistentDataContainer.get(this.itemTypeKey, PersistentDataType.STRING);

        if (typeValue == null)
            return null;

        return ItemTypes.valueOf(typeValue);
    }
}
