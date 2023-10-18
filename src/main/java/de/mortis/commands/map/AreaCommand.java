package de.mortis.commands.map;

import de.mortis.Main;
import de.mortis.commands.CommandInfo;
import de.mortis.commands.PluginCommand;
import de.mortis.items.CustomItemManager;
import de.mortis.items.ItemAttributes;
import de.mortis.items.weapons.WeaponAttributes;
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

        new CustomItemManager(plugin).setItemStack(itemStack)
                .addItemAttribute(
                        new ItemAttributes(WeaponAttributes.DAMAGE, 20, 50),
                        new ItemAttributes(WeaponAttributes.STRENGTH, 25)
                );

        plugin.getItemManager().setTypeOfItem(itemStack, ItemTypes.WORLD_ITEM);
        plugin.getItemManager().addItemAttribute(itemStack,
                new AttributeInformation(ItemAttributeTypes.DAMAGE, 20),
                new AttributeInformation(ItemAttributeTypes.STRENGTH, 45)
        );

        player.getInventory().addItem(itemStack);
        player.sendMessage("> You have created a custom item. Changed PlayerMode to " + plugin.getPlayerStateManager().getPlayerMode(player));
    }
}
