package de.mortis.gui.inventories;

import de.mortis.Main;
import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.items.templates.gui.main.*;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@Getter
public class GameMenuInventory extends GraphicalUserInterface {

    private final Main plugin = Main.getInstance();
    private Player player;

    public GameMenuInventory() {
        super(54, "Tempest Menu", InventoryIdentifiers.GAME_MENU);

        addButton(13, new PlayerStatsItem(player).getItemStack());
        addButton(20, new SkillTreeItem().getItemStack());
        addButton(21, new TempestCollectionItem().getItemStack());
        addButton(22, new TempestLevelingItem().getItemStack());
        addButton(23, new QuestsItem().getItemStack());
        addButton(24, new CalendarEventsItem().getItemStack());
    }

    @Override
    public void openInventory(Player player, Inventory inventory) {
        this.player = player;
        super.openInventory(player, inventory);
    }
}
