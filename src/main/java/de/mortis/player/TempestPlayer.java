package de.mortis.player;

import de.mortis.Main;
import de.mortis.items.templates.gui.MenuControllerItem;
import de.mortis.player.types.PlayerAttributes;
import lombok.Getter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class TempestPlayer {

    private final Main plugin = Main.getInstance();

    private final UUID uuid;
    private final String name;
    private PlayerAttributes[] playerAttributes;
    private Inventory inventory;

    private static HashMap<Integer, ?> unlockedLevel;

    public TempestPlayer(Player player) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();

        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c10❤10     §7300 §fW §7-1500     §b100☀100"));
        }, 5L, 5L);

        player.getInventory().setItem(8, new MenuControllerItem().getItemStack());
    }

    public void savePlayerLocation() {

    }
}
