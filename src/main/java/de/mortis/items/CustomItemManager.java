package de.mortis.items;

import de.mortis.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomItemManager {

    // DEFINES THE TYPE OF THE ITEM
    private final NamespacedKey typeNamespacedKey;

    // OBJECT WITH OBJECTS FOR EACH ELEMENT
    private final NamespacedKey attributesNamespacedKey;

    private final NamespacedKey attributeValueNamespacedKey;
    private final NamespacedKey attributeModifierNamespacedKey;

    // ARRAY WITH ABILITY KEYS
    private final NamespacedKey abilityNamespacedKey;

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public CustomItemManager(Main plugin) {
        this.typeNamespacedKey = new NamespacedKey(plugin, "item-type");
        this.attributesNamespacedKey = new NamespacedKey(plugin, "item-attributes");

        this.attributeValueNamespacedKey = new NamespacedKey(plugin, "value");
        this.attributeModifierNamespacedKey = new NamespacedKey(plugin, "modifier");

        this.abilityNamespacedKey = new NamespacedKey(plugin, "item-abilities");
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

    public void getItemAttribute(ItemStack itemStack) {}

    /** SET AND GET TYPE OF THE ITEM **/

    public CustomItemManager setTypeOfItem(ItemTypes itemType) {
        PersistentDataContainer typeDataContainer = this.itemMeta.getPersistentDataContainer();
        typeDataContainer.set(this.typeNamespacedKey, PersistentDataType.STRING, itemType.name());
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public CustomItemManager setTypeOfItem(ItemStack itemStack, ItemTypes itemType) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null)
            return null;

        PersistentDataContainer typeDataContainer = meta.getPersistentDataContainer();
        typeDataContainer.set(this.typeNamespacedKey, PersistentDataType.STRING, itemType.name());
        itemStack.setItemMeta(meta);
        return this;
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

    /*** SET AND GET THE ABILITY KEYS ***/
    public void setItemAbilities(ItemAbilities ...itemAbilities) {
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        List<String> abilities = new ArrayList<>();

        for (ItemAbilities ia : itemAbilities) {
            abilities.add(ia.name());
        }

        persistentDataContainer.set(abilityNamespacedKey, PersistentDataType.STRING, String.join(";", abilities));

        itemStack.setItemMeta(itemMeta);
    }

    public ItemAbilities getItemAbility() {
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        String itemAbilities = persistentDataContainer.get(abilityNamespacedKey, PersistentDataType.STRING);

        if (itemAbilities == null) return null;

        return ItemAbilities.valueOf(itemAbilities);
    }

    public ItemAbilities getItemAbility(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null) return null;

        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        String itemAbilities = persistentDataContainer.get(abilityNamespacedKey, PersistentDataType.STRING);

        if (itemAbilities == null) return null;

        return ItemAbilities.valueOf(itemAbilities);
    }
}
