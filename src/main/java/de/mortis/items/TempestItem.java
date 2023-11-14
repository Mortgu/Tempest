package de.mortis.items;

import de.mortis.Main;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import de.mortis.items.types.item.ItemTypes;
import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

@Getter
public abstract class TempestItem {

    // Needed to initialize NamespacedKeys
    private final Main plugin = Main.getInstance();

    private final TempestItemInfo tempestPluginInfo;

    // Wrapper key for every declared specification!
    private final NamespacedKey itemSpecificationKey;

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    private Player player;

    // Item specifications
    private final PersistentDataContainer persistentDataContainer;
    private final PersistentDataContainer itemSpecificationContainer;
    private final PersistentDataContainer itemCtActionContainer;

    public TempestItem(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();

        tempestPluginInfo = getClass().getDeclaredAnnotation(TempestItemInfo.class);
        Objects.requireNonNull(tempestPluginInfo, "Every declared item must have an @TempestPluginInfo annotation!");

        itemSpecificationKey = new NamespacedKey(plugin, "item-specifications");

        persistentDataContainer = itemMeta.getPersistentDataContainer();

        itemSpecificationContainer = itemMeta.getPersistentDataContainer()
                .getAdapterContext().newPersistentDataContainer();

        itemCtActionContainer = itemMeta.getPersistentDataContainer()
                .getAdapterContext().newPersistentDataContainer();

        itemSpecificationContainer.set(new NamespacedKey(plugin, "origin-type"),
                PersistentDataType.STRING, tempestPluginInfo.originType().name());

        if (tempestPluginInfo.itemType() != ItemTypes.NULL)
            itemSpecificationContainer.set(new NamespacedKey(plugin, "type"),
                    PersistentDataType.STRING, tempestPluginInfo.itemType().name());

        if (tempestPluginInfo.guiTypes() != GuiTypes.NULL)
            itemSpecificationContainer.set(new NamespacedKey(plugin, "type"),
                    PersistentDataType.STRING, tempestPluginInfo.guiTypes().name());
    }

    public void setOriginType(ItemOriginTypes originType) {
        itemSpecificationContainer.set(new NamespacedKey(plugin, "origin-type"), PersistentDataType.STRING, originType.name());
    }

    // Function to set the type of origin "ITEM"
    public void setTypeOfItem(ItemTypes itemTypes) {
        itemSpecificationContainer.set(new NamespacedKey(plugin, "type"), PersistentDataType.STRING, itemTypes.name());
    }

    // Function to set the type of origin "GUI"
    public void setTypeOfItem(GuiTypes itemTypes) {
        itemSpecificationContainer.set(new NamespacedKey(plugin, "type"), PersistentDataType.STRING, itemTypes.name());
    }

    public void addCtAction(ActionTypes actionType, String inventoryIdentifiers) {
        itemCtActionContainer.set(new NamespacedKey(plugin, "action-key"), PersistentDataType.STRING, actionType.name());
        itemCtActionContainer.set(new NamespacedKey(plugin, "action-value"), PersistentDataType.STRING, inventoryIdentifiers);
        itemSpecificationContainer.set(new NamespacedKey(plugin, "ct-action"), PersistentDataType.TAG_CONTAINER, itemCtActionContainer);
    }

    public void addCtAction(ActionTypes actionType) {
        itemCtActionContainer.set(new NamespacedKey(plugin, "action-key"), PersistentDataType.STRING, actionType.name());
        itemSpecificationContainer.set(new NamespacedKey(plugin, "ct-action"), PersistentDataType.TAG_CONTAINER, itemCtActionContainer);
    }

    public void buildItem() {
        persistentDataContainer.set(itemSpecificationKey, PersistentDataType.TAG_CONTAINER, getItemSpecificationContainer());
        itemStack.setItemMeta(itemMeta);
    }
}
