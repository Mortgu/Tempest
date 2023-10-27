package de.mortis.items.types.gui.specifications;

import de.mortis.Main;
import de.mortis.gui.InventoryIdentifiers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum ActionTypes {
    OPEN_INVENTORY {
        @Override
        public void onTrigger(Player player, String inventoryIdentifier) {
            Main.getInstance().getGraphicalUserInterfaceManager()
                    .openByIdentifier(player, InventoryIdentifiers.valueOf(inventoryIdentifier));
        }
    };

    public abstract void onTrigger(Player player, String inventoryIdentifier);
}
