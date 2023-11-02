package de.mortis.gui.inventories;

import de.mortis.Main;
import de.mortis.gui.GraphicalUserInterface;
import de.mortis.gui.InventoryIdentifiers;
import de.mortis.utilities.ItemStackBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter
public class CreateBlueprintInventory extends GraphicalUserInterface {

    private final Main plugin = Main.getInstance();
    private Player player;

    public CreateBlueprintInventory() {
        super(54, "Create New Blueprint", InventoryIdentifiers.CREATE_BLUEPRINT);

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 9; i++) {
                addButton(i + (9*j), new ItemStackBuilder(Material.AIR).build());
            }
        }

        for (Material material : Material.values()) {

        }
    }
}
