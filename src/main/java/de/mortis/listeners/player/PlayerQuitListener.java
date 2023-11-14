package de.mortis.listeners.player;

import de.mortis.Main;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Bukkit.getLogger().info(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.STONE)));

        event.setQuitMessage(null);

        Main.getInstance().getDatabaseManager().insert("players", new Document().append("_id", new ObjectId()));
    }
}
