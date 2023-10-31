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
public class CalendarEventsItem extends TempestItem {

    public CalendarEventsItem() {
        super(new ItemStackBuilder(Material.CLOCK)
                .setDisplayName("§aCalendar and Events")
                .build());

        super.buildItem();
    }
}
