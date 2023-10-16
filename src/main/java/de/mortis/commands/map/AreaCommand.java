package de.mortis.commands.map;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.systems.gis.types.ItemTypes;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandInfo(name = "area", permission = "command.area", requiresPlayer = true)
public class AreaCommand extends PluginCommand {
    Main plugin = Main.getInstance();

    @Override
    public void execute(Player player, String[] args) {
        ItemStack itemStack = new ItemStack(Material.WOODEN_AXE);
        plugin.getCustomItemManager().setTypeOfItem(itemStack, ItemTypes.WEAPON);
        player.getInventory().addItem(itemStack);
        player.sendMessage("> You have created a custom item.");
    }
}
