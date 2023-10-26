package de.mortis.items.templates.gui.stats;

import de.mortis.gui.InventoryIdentifiers;
import de.mortis.items.TempestPlugin;
import de.mortis.items.TempestPluginInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.DISPLAY)
public class CombatStatItem extends TempestPlugin {

    public CombatStatItem() {
        super(new ItemStackBuilder(Material.NETHERITE_SWORD)
                .setDisplayName("§cCombat stats")
                .build());

        super.buildItem();
    }
}
