package de.mortis.items.templates.gui.blueprint;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = ItemOriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class CreateBlueprintItem extends TempestItem {

    public CreateBlueprintItem() {
        super(new ItemStackBuilder(Material.GOLD_BLOCK)
                .setDisplayName("§aCreate Blueprint")
                .setSimpleLore("§7Create a new blueprint")
                .build());

        super.buildItem();
    }
}
