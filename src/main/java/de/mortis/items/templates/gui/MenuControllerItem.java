package de.mortis.items.templates.gui;

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
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class MenuControllerItem extends TempestPlugin {

    public MenuControllerItem() {
        super(new ItemStackBuilder(Material.NETHER_STAR)
                .setDisplayName("§aTempest Menu §8(Right Click)").build());

        super.addCtAction(ActionTypes.OPEN_INVENTORY, InventoryIdentifiers.GAME_MENU);

        super.buildItem();
    }
}