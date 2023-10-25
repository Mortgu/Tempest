package de.mortis.items.templates.gui;

import de.mortis.items.TempestPlugin;
import de.mortis.items.TempestPluginInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class PlayerStatsItem extends TempestPlugin {

    public PlayerStatsItem() {
        super(new ItemStackBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§aYour Tempest Profile")
                .setSimpleLore("§7View your equipment, stats,", "§7and more!")
                .build());

        super.buildItem();
    }
}
