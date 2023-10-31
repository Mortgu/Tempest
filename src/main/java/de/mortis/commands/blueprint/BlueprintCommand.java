package de.mortis.commands.blueprint;

import de.mortis.Main;
import de.mortis.blueprint.BlueprintManager;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.gui.InventoryIdentifiers;
import org.bukkit.entity.Player;

@CommandInfo(name = "blueprint", permission = "blueprint.*", requiresPlayer = true)
public class BlueprintCommand extends PluginCommand {

    private final Main plugin = Main.getInstance();

    private BlueprintManager blueprintManager;
    @Override
    public void execute(Player player, String[] args) {
        blueprintManager = new BlueprintManager();

        if (args.length <= 0) {
            plugin.getGraphicalUserInterfaceManager().openByIdentifier(player, InventoryIdentifiers.BLUEPRINT);
            return;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("create")) {
            player.sendMessage(plugin.getMainConfiguration().get("blueprint_prefix") + "Creating new item blueprint");
            blueprintManager.create("unnamed");
            plugin.getGraphicalUserInterfaceManager().openByIdentifier(player, InventoryIdentifiers.CREATE_BLUEPRINT);
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
            player.sendMessage(plugin.getMainConfiguration().get("blueprint_prefix") + "§7There are currently §a" + blueprintManager.list().size() + " §7blueprint registered.");
        }
    }
}
