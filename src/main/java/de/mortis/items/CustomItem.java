package de.mortis.items;

import de.mortis.Main;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public abstract class CustomItem {

    private final Main plugin = Main.getInstance();

    private final PluginItem pluginItem;

    @Getter
    private final ItemStack itemStack;

    public CustomItem() {
        pluginItem = getClass().getDeclaredAnnotation(PluginItem.class);
        Objects.requireNonNull(pluginItem, "Items must have PluginItem annotation!");

        itemStack = new ItemStackBuilder(pluginItem.material())
                .setDisplayName(pluginItem.name())
                .build();

        plugin.getCustomItemManager().setTypeOfItem(itemStack, pluginItem.itemType());
    }

    public abstract void onPlayerInteract();
    public abstract void onInventoryClick();
}
