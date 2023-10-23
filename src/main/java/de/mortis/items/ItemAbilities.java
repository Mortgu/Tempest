package de.mortis.items;

import de.mortis.gui.inventories.GameMenuInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

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
            new GameMenuInventory().openInventory(player);
        }
    };

    public abstract void onTrigger(Player player, PlayerInteractEvent event);
}
