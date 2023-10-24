package de.mortis.items;

import de.mortis.gui.inventories.GameMenuInventory;
import de.mortis.gui.inventories.PlayerStatsInventory;
import org.bukkit.entity.Player;

public enum ItemAbilities {
    TEST_MENU() {
        @Override
        public <T> void onTrigger(Player player, T event) {
            new PlayerStatsInventory().openInventory(player);
        }
    },
    GAME_MENU() {
        @Override
        public <T> void onTrigger(Player player, T event) {
            new GameMenuInventory().openInventory(player);
        }
    };

    public abstract <T> void onTrigger(Player player, T event);
}
