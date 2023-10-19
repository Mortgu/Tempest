package de.mortis.utilities;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
public class ItemStackBuilder {

    private final Main plugin = Main.getInstance();

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    private Player player;

    public ItemStackBuilder(Material material) {
        itemStack = new ItemStack(material, 1);
        this.itemMeta = itemStack.getItemMeta();

        this.setItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
    }

    public ItemStackBuilder setOwningPlayer(Player player) {
        this.player = player;
        return this;
    }

    public ItemStackBuilder disableStackable() {
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(new NamespacedKey(plugin, "uid"), PersistentDataType.STRING, UUID.randomUUID().toString());
        return this;
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
