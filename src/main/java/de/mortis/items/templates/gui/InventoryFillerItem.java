package de.mortis.items.templates.gui;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = ItemOriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class InventoryFillerItem extends TempestItem {

    public InventoryFillerItem() {
        super(new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayName("§r").build());

        super.buildItem();
    }
}
