package de.mortis.gui.inventories;

import de.mortis.Main;
import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.items.templates.gui.InventoryBackItem;
import de.mortis.items.templates.gui.blueprint.CreateBlueprintItem;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter
public class BlueprintInventory extends GraphicalUserInterface {

    private final Main plugin = Main.getInstance();
    private Player player;

    public BlueprintInventory() {
        super(54, "Tempest Blueprints", InventoryIdentifiers.BLUEPRINT);

        for (int i = 0; i < 45; i++) {
            addButton(i, new ItemStackBuilder(Material.AIR).build());
        }

        for (int i = 0; i < plugin.getBlueprintManager().getRegisteredBlueprints().size(); i++) {
            addButton(i, new ItemStackBuilder(Material.GRASS_BLOCK)
                    .setDisplayName("§bBlueprint")
                    .setSimpleLore("§6" +
                                    plugin.getBlueprintManager().getRegisteredBlueprints().get(i).getName())
                    .build()
            );
        }

        addButton(46, new ItemStackBuilder(Material.CLAY_BALL).setDisplayName("§eMode").build());
        addButton(47, new ItemStackBuilder(Material.OAK_SIGN).setDisplayName("§eSearch").build());
        addButton(48, new InventoryBackItem().getItemStack());
        addButton(50, new ItemStackBuilder(Material.ARROW).setDisplayName("§bNext").build());
        addButton(51, new ItemStackBuilder(Material.HOPPER).setDisplayName("§eFilter").build());
        addButton(52, new CreateBlueprintItem().getItemStack());
    }
}
