package de.mortis.items.types.gui.specifications;

import de.mortis.Main;
import de.mortis.gui.InventoryIdentifiers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum ActionTypes {
    NO_ACTION {
        @Override
        public void onTrigger(Player player, String inventoryIdentifier) { }
    },
    OPEN_INVENTORY {
        @Override
        public void onTrigger(Player player, String inventoryIdentifier) {
            Main.getInstance().getGraphicalUserInterfaceManager()
                    .openGraphicalUserInterfaceByIdentifier(player, InventoryIdentifiers.valueOf(inventoryIdentifier));
        }
    };

    public abstract void onTrigger(Player player, String inventoryIdentifier);
}
