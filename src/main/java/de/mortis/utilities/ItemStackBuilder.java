package de.mortis.utilities;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@Getter
public class ItemStackBuilder {

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemStackBuilder(Material material) {
        itemStack = new ItemStack(material, 1);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder setDisplayName(String displayName) {
        itemMeta.setDisplayName(MessageHandler.translate(displayName));
        return this;
    }

    public ItemStackBuilder setItemFlags(ItemFlag ...flags) {
        this.itemMeta.addItemFlags(flags);
        return this;
    }

    public @NotNull ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
