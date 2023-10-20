package de.mortis.commands.blueprint;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.gui.GraphicalUserInterface;
import de.mortis.items.ItemTypes;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

@CommandInfo(name = "blueprint", permission = "blueprint.*", requiresPlayer = true)
public class BlueprintCommand extends PluginCommand {

    private final Main plugin = Main.getInstance();

    @Override
    public void execute(Player player, String[] args) {

    }
}
