package de.mortis.items.templates.gui.stats;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = ItemOriginTypes.GUI, guiTypes = GuiTypes.DISPLAY)
public class CombatStatItem extends TempestItem {

    public CombatStatItem() {
        super(new ItemStackBuilder(Material.NETHERITE_SWORD)
                .setDisplayName("§cCombat stats")
                .build());

        super.buildItem();
    }
}
