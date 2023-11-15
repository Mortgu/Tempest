package de.mortis.items.templates.gui;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.gui.specifications.ActionTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = ItemOriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class MenuControllerItem extends TempestItem {

    public MenuControllerItem() {
        super(new ItemStackBuilder(Material.BOOK)
                .setDisplayName("§aTempest Menu").build());

        super.addCallToAction(ActionTypes.OPEN_INVENTORY, "PLAYER_LEVELS");


        super.buildItem();
    }
}
