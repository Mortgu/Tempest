package de.mortis.items.templates.gui;

import de.mortis.gui.InventoryIdentifiers;
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
public class MenuControllerItem extends TempestItem {

    public MenuControllerItem() {
        super(new ItemStackBuilder(Material.BOOK)
                .setDisplayName("§aTempest Menu §8(Right Click)").build());

        super.addCtAction(ActionTypes.OPEN_INVENTORY, InventoryIdentifiers.GAME_MENU);

        super.buildItem();
    }
}
