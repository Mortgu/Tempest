package de.mortis.commands.blueprint;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "blueprint", delay = 50)
public class BlueprintCommand extends PluginCommand {

    private final Main plugin = Main.getInstance();

    @Override
    public void execute(CommandSender sender, String[] args) {
        Bukkit.getLogger().info("used: /blueprint");
    }
}
