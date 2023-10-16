package de.mortis.utilities;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public class ItemStackBuilder {

    private ItemStack itemStack;

    public ItemStackBuilder(Material material) { }

    public ItemStackBuilder build() {
        return this;
    }
}
