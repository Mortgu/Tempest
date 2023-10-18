package de.mortis.commands.map;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.player.types.PlayerModes;
import de.mortis.systems.gis.types.AttributeInformation;
import de.mortis.systems.gis.types.ItemAttributeTypes;
import de.mortis.systems.gis.types.ItemTypes;
import de.mortis.utilities.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandInfo(name = "area", permission = "command.area", requiresPlayer = true)
public class AreaCommand extends PluginCommand {
    Main plugin = Main.getInstance();

    @Override
    public void execute(Player player, String[] args) {
        plugin.getPlayerStateManager().setPlayerMode(player, PlayerModes.BUILDING);

        ItemStack itemStack = new ItemStackBuilder(Material.WOODEN_AXE)
                .setDisplayName("§cArea Axe")
                .build();

        plugin.getItemManager().setTypeOfItem(itemStack, ItemTypes.WORLD_ITEM);

        player.getInventory().addItem(itemStack);
        player.sendMessage("> You have created a custom item. Changed PlayerMode to " + plugin.getPlayerStateManager().getPlayerMode(player));
    }
}
