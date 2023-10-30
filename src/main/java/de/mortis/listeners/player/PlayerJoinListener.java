package de.mortis.listeners.player;

import de.mortis.Main;
import de.mortis.items.templates.gui.MenuControllerItem;
import de.mortis.player.TempestPlayer;
import lombok.Getter;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final Main plugin = Main.getInstance();

    @Getter
    private static TempestPlayer player;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        player = new TempestPlayer(event.getPlayer());
    }
}
