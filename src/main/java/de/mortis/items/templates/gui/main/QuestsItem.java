package de.mortis.items.templates.gui.main;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.ItemOriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = ItemOriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class QuestsItem extends TempestItem {

    public QuestsItem() {
        super(new ItemStackBuilder(Material.WRITABLE_BOOK)
                .setDisplayName("§aQuests")
                .build());

        super.buildItem();
    }
}
