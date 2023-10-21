package de.mortis.items;

import de.mortis.Main;
import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.inventories.GameMenuInventory;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public enum ItemAbilities {
    FLAME() {
        @Override
        public void onTrigger(Player player, PlayerInteractEvent event) {

        }
    },
    WATER() {
        @Override
        public void onTrigger(Player player, PlayerInteractEvent event) {

        }
    },
    OPEN_GAME_MENU() {
        @Override
        public void onTrigger(Player player, PlayerInteractEvent event) {
            player.openInventory(new GameMenuInventory().getGameMenuInventory());

            GraphicalUserInterface graphicalUserInterface = new GraphicalUserInterface(54, "Tempest Menu");

            ItemStack itemStack = new ItemStackBuilder(Material.PLAYER_HEAD).setDisplayName(" ").build();
            SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
            skullMeta.setOwningPlayer(player);
            itemStack.setItemMeta(skullMeta);

            Main.getInstance().getCustomItemManager().setTypeOfItem(itemStack, ItemTypes.MENU_ITEM);

            graphicalUserInterface.addButton(13, itemStack, Bukkit.createInventory(null, 27, "test"));

            graphicalUserInterface.addButton(20, new ItemStackBuilder(Material.DIAMOND_SWORD).build(), Bukkit.createInventory(null, 27, "test"));
            graphicalUserInterface.addButton(21, new ItemStackBuilder(Material.ITEM_FRAME).build(), Bukkit.createInventory(null, 27, "test"));

            graphicalUserInterface.addButton(22, new ItemStackBuilder(Material.EMERALD).build(), Bukkit.createInventory(null, 27, "test"));
            graphicalUserInterface.addButton(23, new ItemStackBuilder(Material.WRITABLE_BOOK).build(), Bukkit.createInventory(null, 27, "test"));
            graphicalUserInterface.addButton(24, new ItemStackBuilder(Material.CLOCK).build(), Bukkit.createInventory(null, 27, "test"));

            graphicalUserInterface.addButton(24, new ItemStackBuilder(Material.CLOCK).build(), Bukkit.createInventory(null, 27, "test"));
            graphicalUserInterface.addButton(49, new ItemStackBuilder(Material.BARRIER).build(), Bukkit.createInventory(null, 27, "test"));

            player.openInventory(graphicalUserInterface.build());
        }
    };

    public abstract void onTrigger(Player player, PlayerInteractEvent event);
}
