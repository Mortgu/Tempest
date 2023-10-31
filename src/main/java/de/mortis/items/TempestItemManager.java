package de.mortis.items;

import de.mortis.Main;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class TempestItemManager {

    private final Main plugin = Main.getInstance();

    public TempestItemManager() {}

    public ActionTypes getActionKeyOfItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return null;

        // TODO: REFACTOR ERROR HANDLING!
        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);
        if (itemSpecificationContainer == null) return null;

        // TODO: REFACTOR ERROR HANDLING!
        PersistentDataContainer actionTypeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "ct-action"), PersistentDataType.TAG_CONTAINER);
        if (actionTypeContainer == null) return null;

        String actionTypeName = actionTypeContainer.get(new NamespacedKey(plugin, "action-key"), PersistentDataType.STRING);

        if (actionTypeName == null)
            return null;

        return ActionTypes.valueOf(actionTypeName);
    }

    public String getActionValueOfItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return null;

        // TODO: REFACTOR ERROR HANDLING!
        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);
        if (itemSpecificationContainer == null) return null;

        // TODO: REFACTOR ERROR HANDLING!
        PersistentDataContainer actionTypeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "ct-action"), PersistentDataType.TAG_CONTAINER);
        if (actionTypeContainer == null) return null;

        String actionValue = actionTypeContainer.get(new NamespacedKey(plugin, "action-value"), PersistentDataType.STRING);

        if (actionValue == null)
            return null;

        return actionValue;
    }

    public String getItemOriginType(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return ItemOriginTypes.ITEM.name();

        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);

        if (itemSpecificationContainer == null)
            return ItemOriginTypes.ITEM.name();

        String originTypeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "origin-type"), PersistentDataType.STRING);

        if (originTypeContainer == null)
            return ItemOriginTypes.ITEM.name();

        return originTypeContainer;
    }

    public String getItemType(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return GuiTypes.DISPLAY.name();

        PersistentDataContainer itemSpecificationContainer = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "item-specifications"), PersistentDataType.TAG_CONTAINER);

        if (itemSpecificationContainer == null)
            return GuiTypes.DISPLAY.name();

        String typeContainer = itemSpecificationContainer.get(new NamespacedKey(plugin, "type"), PersistentDataType.STRING);

        if (typeContainer == null)
            return GuiTypes.DISPLAY.name();

        return typeContainer;
    }
}
