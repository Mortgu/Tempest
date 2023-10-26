package de.mortis.items.templates.gui.main;

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
public class SkillTreeItem extends TempestPlugin {

    public SkillTreeItem() {
        super(new ItemStackBuilder(Material.NETHERITE_SWORD)
                .setDisplayName("§aSkill-tree")
                .build());

        super.buildItem();
    }
}
