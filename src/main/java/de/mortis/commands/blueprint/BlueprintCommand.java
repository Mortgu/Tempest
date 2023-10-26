package de.mortis.commands.blueprint;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import org.bukkit.entity.Player;

@CommandInfo(name = "blueprint", permission = "blueprint.*", requiresPlayer = true)
public class BlueprintCommand extends PluginCommand {

    private final Main plugin = Main.getInstance();

    @Override
    public void execute(Player player, String[] args) {

    }
}
