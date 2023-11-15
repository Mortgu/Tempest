package de.mortis.items.types.gui.specifications;

import de.mortis.Main;
import org.bukkit.entity.Player;

public enum ActionTypes {
    OPEN_INVENTORY {
        @Override
        public void onTrigger(Player player, String inventoryIdentifier) {
        }
    },
    CLOSE_INVENTORY {
        @Override
        public void onTrigger(Player player, String inventoryIdentifier) {
            player.closeInventory();
        }
    };

    public abstract void onTrigger(Player player, String inventoryIdentifier);
}
