package de.mortis.items;

import de.mortis.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomItemManager {

    // DEFINES THE TYPE OF THE ITEM
    private final NamespacedKey typeNamespacedKey;

    // OBJECT WITH OBJECTS FOR EACH ELEMENT
    private final NamespacedKey attributesNamespacedKey;

    private final NamespacedKey attributeValueNamespacedKey;
    private final NamespacedKey attributeModifierNamespacedKey;

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public CustomItemManager(Main plugin) {
        this.typeNamespacedKey = new NamespacedKey(plugin, "item-type");
        this.attributesNamespacedKey = new NamespacedKey(plugin, "item-attributes");

        this.attributeValueNamespacedKey = new NamespacedKey(plugin, "value");
        this.attributeModifierNamespacedKey = new NamespacedKey(plugin, "modifier");
    }

    public CustomItemManager setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
        return this;
    }

    /** All addItemAttributes functions for different attribute types **/

    public CustomItemManager addItemAttribute(ItemAttributes... itemAttributes) {
        // "item-attributes": { "strength": {"value": 20, "modifier": 40, ...}, "damage": {...} }
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        PersistentDataContainer attributeDataContainer = itemMeta.getPersistentDataContainer().getAdapterContext().newPersistentDataContainer();
        PersistentDataContainer modifiersDataContainer = itemMeta.getPersistentDataContainer().getAdapterContext().newPersistentDataContainer();

        for (ItemAttributes ia : itemAttributes) {
            attributeDataContainer.set(new NamespacedKey(Main.getInstance(), ia.getWeaponAttributes().name()), PersistentDataType.TAG_CONTAINER, modifiersDataContainer);
        }

        persistentDataContainer.set(this.attributesNamespacedKey, PersistentDataType.TAG_CONTAINER, attributeDataContainer);
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    /** modifiers functions **/

    public void addItemAttributeModifier() {}

    public void getItemAttribute() {}

}
