package de.mortis.items.weapons;

import de.mortis.Main;
import de.mortis.items.CustomItem;
import de.mortis.items.ItemTypes;
import de.mortis.items.PluginItem;
import lombok.Getter;
import org.bukkit.Material;

@Getter
@PluginItem(name="§7Test Weapon", itemType = ItemTypes.WEAPON, material = Material.DIAMOND_SWORD)
public class TestWeapon extends CustomItem {

    private final Main plugin = Main.getInstance();

    public TestWeapon() { }

    @Override
    public void onPlayerInteract() {

    }

    @Override
    public void onInventoryClick() {

    }
}
