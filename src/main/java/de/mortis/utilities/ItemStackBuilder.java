package de.mortis.utilities;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@Getter
public class ItemStackBuilder {

    private final Main plugin = Main.getInstance();

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemStackBuilder(Material material) {
        itemStack = new ItemStack(material, 1);
        this.itemMeta = itemStack.getItemMeta();

        this.setItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
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

    public ItemStackBuilder setItemType(ItemTypes itemType) {
        plugin.getCustomItemManager().setTypeOfItem(this.itemStack, itemType);
        return this;
    }

    public @NotNull ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
