package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.ItemAbilities;
import de.mortis.items.ItemTypes;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.setGameMode(GameMode.SURVIVAL);

        Inventory playerInventory = player.getInventory();
        ItemStack itemStack = new ItemStackBuilder(Material.NETHER_STAR)
                .setDisplayName("§aTempest Menu §8(Right Click)")
                .setSimpleLore("§7View all of your Tempest", "§7progress, including your Skills,", "§7Collections, Recipes and more!")
                .build();

        plugin.getCustomItemManager().setTypeOfItem(itemStack, ItemTypes.MENU_ITEM);
        plugin.getCustomItemManager().setItemStack(itemStack).setItemAbilities(ItemAbilities.GAME_MENU);

        playerInventory.setItem(8, itemStack);
    }
}
