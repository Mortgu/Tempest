package de.mortis.items.templates.gui.main;

import de.mortis.items.TempestItem;
import de.mortis.items.TempestItemInfo;
import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@TempestItemInfo(originType = OriginTypes.GUI, guiTypes = GuiTypes.ACTION)
public class SkillTreeItem extends TempestItem {

    public SkillTreeItem() {
        super(new ItemStackBuilder(Material.NETHERITE_SWORD)
                .setDisplayName("§aSkill-tree")
                .build());

        super.buildItem();
    }
}
