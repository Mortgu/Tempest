package de.mortis.items.templates.gui;

import de.mortis.items.TempestPlugin;
import de.mortis.items.TempestPluginInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class TempestCollectionItem extends TempestPlugin {

    public TempestCollectionItem() {
        super(new ItemStackBuilder(Material.ITEM_FRAME)
                .setDisplayName("§aCollection").build());

        super.buildItem();
    }
}
