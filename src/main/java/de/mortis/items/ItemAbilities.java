package de.mortis.items;

import de.mortis.gui.inventories.GameMenuInventory;
import org.bukkit.entity.Player;

public enum ItemAbilities {
    FLAME() {
        @Override
        public <T> void onTrigger(Player player, T event) {

        }
    },
    WATER() {
        @Override
        public <T> void onTrigger(Player player, T event) {

        }
    },
    OPEN_GAME_MENU() {
        @Override
        public <T> void onTrigger(Player player, T event) {
            player.sendMessage(event.getClass().toString());
            new GameMenuInventory().openInventory(player);
        }
    };

    public abstract <T> void onTrigger(Player player, T event);
}
