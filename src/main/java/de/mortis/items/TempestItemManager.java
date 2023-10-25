package de.mortis.items;

import de.mortis.Main;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class TempestItemManager {

    private final Main plugin = Main.getInstance();

    public TempestItemManager() {

    }

    public ActionTypes getActionKeyOfItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return null;

        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);
        PersistentDataContainer actionTypeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "ct-action"), PersistentDataType.TAG_CONTAINER);
        String actionTypeName = actionTypeContainer.get(new NamespacedKey(plugin, "action-key"), PersistentDataType.STRING);

        if (actionTypeName == null)
            return null;

        return ActionTypes.valueOf(actionTypeName);
    }

    public String getActionValueOfItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return null;

        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);
        PersistentDataContainer actionTypeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "ct-action"), PersistentDataType.TAG_CONTAINER);
        String actionValue = actionTypeContainer.get(new NamespacedKey(plugin, "action-value"), PersistentDataType.STRING);

        if (actionValue == null)
            return null;

        return actionValue;
    }

    public String getItemOriginType(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return OriginTypes.ITEM.name();

        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);

        if (itemSpecificationContainer == null)
            return OriginTypes.ITEM.name();

        String originTypeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "origin-type"), PersistentDataType.STRING);

        if (originTypeContainer == null)
            return OriginTypes.ITEM.name();

        return originTypeContainer;
    }
}