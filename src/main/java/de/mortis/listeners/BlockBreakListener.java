package de.mortis.listeners;

import de.mortis.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
