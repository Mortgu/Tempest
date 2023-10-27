package de.mortis.listeners.player;

import de.mortis.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class PlayerStatisticIncrementListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onPlayerStatisticsIncrement(PlayerStatisticIncrementEvent event) {
        /**
         * event.getPlayer().sendMessage(event.getMaterial().toString());
         *         event.getPlayer().sendMessage(event.getStatistic().getKey().toString());
         *         if (event.getStatistic().getKey().equals(NamespacedKey.minecraft("pickup"))) {
         *             event.getPlayer().sendMessage("item picked up");
         *         }
         *
         *         if (event.getStatistic().getType() == Statistic.Type.BLOCK) {
         *
         *         }
         */
    }

}
