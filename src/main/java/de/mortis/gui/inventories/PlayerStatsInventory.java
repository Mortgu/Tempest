package de.mortis.gui.inventories;

import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PlayerStatsInventory extends GraphicalUserInterface {

    private final ItemStack CombatStats = new ItemStackBuilder(Material.DIAMOND_SWORD)
            .setDisplayName("§cCombat Stats")
            .setSimpleLore("§7Gives you a better chance", "§7at fighting strong monsters.").build();

    private final ItemStack GatheringStats = new ItemStackBuilder(Material.IRON_PICKAXE)
            .setDisplayName("§eGathering Stats")
            .setSimpleLore("§7Lets you collect and harvest", "§7better items, or more of them").build();

    private final ItemStack WisdomStats = new ItemStackBuilder(Material.BOOK)
            .setDisplayName("§3Wisdom Stats")
            .setSimpleLore("§7Increases the §3XP §7 you gain on", "§7your skills").build();

    private final ItemStack MiscStats = new ItemStackBuilder(Material.CLOCK)
            .setDisplayName("§dMisc Stats")
            .setSimpleLore("§7Augments various aspects of your", "§7gameplay!").build();

    public PlayerStatsInventory() {
        super(54, "Tempest Stats", InventoryIdentifiers.TEST_MENU);
    }
}
