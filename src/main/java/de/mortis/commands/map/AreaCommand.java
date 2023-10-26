package de.mortis.commands.map;

import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.items.templates.gui.MenuControllerItem;
import org.bukkit.entity.Player;

@CommandInfo(name = "area", permission = "command.area", requiresPlayer = true)
public class AreaCommand extends PluginCommand {

    @Override
    public void execute(Player player, String[] args) {
        player.getInventory().setItem(1, new MenuControllerItem().getItemStack());
    }
}
