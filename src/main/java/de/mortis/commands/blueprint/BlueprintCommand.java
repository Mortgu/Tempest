package de.mortis.commands.blueprint;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.items.ItemTypes;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

@CommandInfo(name = "blueprint", permission = "blueprint.*", requiresPlayer = true)
public class BlueprintCommand extends PluginCommand {

    private final Main plugin = Main.getInstance();

    @Override
    public void execute(Player player, String[] args) {
        Inventory inventory = Bukkit.createInventory(null, 54, "SkyBlock Menu");

        ItemStack playerHead = new ItemStackBuilder(Material.PLAYER_HEAD)
                .setItemType(ItemTypes.MENU_ITEM)
                .build();

        plugin.getCustomItemManager().setTypeOfItem(playerHead, ItemTypes.MENU_ITEM);

        SkullMeta skull = (SkullMeta) playerHead.getItemMeta();
        skull.setDisplayName(player.getName());
        skull.setOwningPlayer(player);
        playerHead.setItemMeta(skull);

        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack inventoryItem = new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                    .setDisplayName(" ")
                    .build();

            plugin.getCustomItemManager().setTypeOfItem(inventoryItem, ItemTypes.MENU_ITEM);

            inventory.setItem(i, inventoryItem);
        }

        inventory.setItem(13, playerHead);

        player.openInventory(inventory);
    }
}
