package de.mortis.items.templates.gui;

import de.mortis.items.TempestPlugin;
import de.mortis.items.TempestPluginInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class InventoryFillerItem extends TempestPlugin {

    public InventoryFillerItem() {
        super(new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                .setDisplayName(" ").build());

        super.buildItem();
    }
}
