package de.mortis.commands.map;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import org.bukkit.entity.Player;

@CommandInfo(name = "area", permission = "command.area", requiresPlayer = true)
public class AreaCommand extends PluginCommand {
    Main plugin = Main.getInstance();

    @Override
    public void execute(Player player, String[] args) {
        super.execute(player, args);
    }
}
