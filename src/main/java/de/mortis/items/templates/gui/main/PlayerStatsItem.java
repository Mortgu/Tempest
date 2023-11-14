package de.mortis.items.templates.gui.main;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter
@TempestItemInfo(originType = ItemOriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class PlayerStatsItem extends TempestItem {

    public PlayerStatsItem(Player player) {
        super(new ItemStackBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§aYour Tempest Profile")
                .setSimpleLore("§7View your equipment, stats, and more!")
                .setOwningPlayer(player)
                .build());

        super.buildItem();
    }
}
