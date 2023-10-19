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
            modifiersDataContainer.set(this.attributeValueNamespacedKey, PersistentDataType.INTEGER, ia.getValue());
            modifiersDataContainer.set(this.attributeModifierNamespacedKey, PersistentDataType.INTEGER, ia.getModifier());
            attributeDataContainer.set(new NamespacedKey(Main.getInstance(), ia.getWeaponAttributes().name()), PersistentDataType.TAG_CONTAINER, modifiersDataContainer);
        }


        persistentDataContainer.set(this.attributesNamespacedKey, PersistentDataType.TAG_CONTAINER, attributeDataContainer);
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    /** modifiers functions **/

    public void addItemAttributeModifier() {}

    public void getItemAttribute() {}

    /** SET AND GET TYPE OF THE ITEM **/

    public CustomItemManager setTypeOfItem(ItemTypes itemType) {
        PersistentDataContainer typeDataContainer = this.itemMeta.getPersistentDataContainer();
        typeDataContainer.set(this.typeNamespacedKey, PersistentDataType.STRING, itemType.name());
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public void setTypeOfItem(ItemStack itemStack, ItemTypes itemType) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null)
            return;

        PersistentDataContainer typeDataContainer = meta.getPersistentDataContainer();
        typeDataContainer.set(this.typeNamespacedKey, PersistentDataType.STRING, itemType.name());
        itemStack.setItemMeta(meta);
    }

    public ItemTypes getTypeOfItem() {
        PersistentDataContainer typeDataContainer = this.itemMeta.getPersistentDataContainer();
        String typeValue = typeDataContainer.get(this.typeNamespacedKey, PersistentDataType.STRING);

        if (typeValue == null) return null;

        return ItemTypes.valueOf(typeValue);
    }

    public ItemTypes getTypeOfItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null)
            return null;

        PersistentDataContainer typeDataContainer = meta.getPersistentDataContainer();
        String typeValue = typeDataContainer.get(this.typeNamespacedKey, PersistentDataType.STRING);

        if (typeValue == null) return null;

        return ItemTypes.valueOf(typeValue);
    }

}
