package de.mortis.items.templates.gui;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class InventoryCloseItem extends TempestItem {

    public InventoryCloseItem() {
        super(new ItemStackBuilder(Material.BARRIER)
                .setDisplayName("§cClose").build());

        super.addCtAction(ActionTypes.CLOSE_INVENTORY);

        super.buildItem();
    }
}
