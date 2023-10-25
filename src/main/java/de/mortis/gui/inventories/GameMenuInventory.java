package de.mortis.gui.inventories;

import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.items.templates.gui.PlayerStatsItem;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter
public class GameMenuInventory extends GraphicalUserInterface {

    private Player player;

    /**
     * Game menu inventory Buttons
     */
    private final ItemStack PlayerSkills = new ItemStackBuilder(Material.NETHERITE_SWORD)
            .setDisplayName("§aSkill tree").build();

    private final ItemStack PlayerCollections = new ItemStackBuilder(Material.ITEM_FRAME)
            .setDisplayName("§aCollections").build();

    private final ItemStack PlayerLevels = new ItemStackBuilder(Material.EMERALD)
            .setDisplayName("§aTempest Leveling").build();

    private final ItemStack PlayerQuests = new ItemStackBuilder(Material.WRITABLE_BOOK)
            .setDisplayName("§aCalendar and Events").setSimpleLore("§7View the Tempest Calendar", "§7upcoming events, and event", "§7rewards!", " ", "§7Date: §a27th Autumn 309").build();

    private final ItemStack ServerEvents = new ItemStackBuilder(Material.CLOCK)
            .setDisplayName("§aServer events").build();

    public GameMenuInventory() {
        super(54, "Tempest Menu", InventoryIdentifiers.GAME_MENU);

        addButton(13, new PlayerStatsItem().getItemStack());
        addButton(20, PlayerSkills);
        addButton(21, PlayerCollections);
        addButton(22, PlayerLevels);
        addButton(23, PlayerQuests);
        addButton(24, ServerEvents);
    }
}
