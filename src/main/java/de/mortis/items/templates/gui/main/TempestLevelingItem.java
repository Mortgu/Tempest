package de.mortis.items.templates.gui.main;

import de.mortis.items.TempestPlugin;
import de.mortis.items.TempestPluginInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class TempestLevelingItem extends TempestPlugin {

    public TempestLevelingItem() {
        super(new ItemStackBuilder(Material.EMERALD)
                .setDisplayName("§aTempest Leveling").build());

        super.buildItem();
    }
}
