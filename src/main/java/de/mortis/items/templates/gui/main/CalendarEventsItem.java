package de.mortis.items.templates.gui.main;

import de.mortis.items.TempestPlugin;
import de.mortis.items.TempestPluginInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestPluginInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class CalendarEventsItem extends TempestPlugin {

    public CalendarEventsItem() {
        super(new ItemStackBuilder(Material.CLOCK)
                .setDisplayName("§aCalendar and Events")
                .build());

        super.buildItem();
    }
}
