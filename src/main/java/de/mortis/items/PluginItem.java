package de.mortis.items;

import de.mortis.items.types.AbilityActionTypes;
import de.mortis.items.types.AbilityIdentifiers;
import de.mortis.items.types.item.specifications.ItemAttributes;
import lombok.Getter;

import java.util.HashMap;

@Getter
public abstract class PluginItem {
    private HashMap<ItemAttributes, ?> itemAttributes = new HashMap<>();
    private HashMap<AbilityActionTypes, AbilityIdentifiers> itemAbilities = new HashMap<>();
    private ItemLoreManager itemLoreManager;

}
