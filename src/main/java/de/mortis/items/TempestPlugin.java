package de.mortis.items;

import de.mortis.Main;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import de.mortis.items.types.item.ItemTypes;
import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

@Getter
public abstract class TempestPlugin {

    // Needed to initialize NamespacedKeys
    private final Main plugin = Main.getInstance();

    private final TempestPluginInfo tempestPluginInfo;

    // Wrapper key for every declared specification!
    private final NamespacedKey itemSpecificationKey;

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    // Item specifications
    private final PersistentDataContainer persistentDataContainer;
    private final PersistentDataContainer itemSpecificationContainer;

    public TempestPlugin(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();

        tempestPluginInfo = getClass().getDeclaredAnnotation(TempestPluginInfo.class);
        Objects.requireNonNull(tempestPluginInfo, "Every declared item must have an @TempestPluginInfo annotation!");

        itemSpecificationKey = new NamespacedKey(plugin, "item-specifications");

        persistentDataContainer = itemMeta.getPersistentDataContainer();

        itemSpecificationContainer = itemMeta.getPersistentDataContainer()
                .getAdapterContext().newPersistentDataContainer();
    }

    public void setOriginType(OriginTypes originType) {
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

    public void addCTAction(ActionTypes actionType) {

    }

    public void buildItem() {
        persistentDataContainer.set(itemSpecificationKey, PersistentDataType.TAG_CONTAINER, getItemSpecificationContainer());
        itemStack.setItemMeta(itemMeta);
    }
}
