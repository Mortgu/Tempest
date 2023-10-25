package de.mortis.gui;

import de.mortis.Main;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class UserInterfaceButton {

    private final Main plugin = Main.getInstance();
    private final ItemStack itemStack;

    public UserInterfaceButton(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public String targetInventoryId() {
        return "";
    }
}
