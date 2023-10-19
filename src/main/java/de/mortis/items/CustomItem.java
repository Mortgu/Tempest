package de.mortis.items;

import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public abstract class CustomItem {

    private final PluginItem pluginItem;

    @Getter
    private final ItemStack itemStack;

    public CustomItem() {
        pluginItem = getClass().getDeclaredAnnotation(PluginItem.class);
        Objects.requireNonNull(pluginItem, "Items must have PluginItem annotation!");

        itemStack = new ItemStackBuilder(pluginItem.material())
                .setDisplayName(pluginItem.name()).setItemType(pluginItem.itemType())
                .build();
    }

    public abstract void onPlayerInteract();
    public abstract void onInventoryClick();
}
