package de.mortis.listeners;

import de.mortis.Main;
import de.mortis.items.ItemTypes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BlockBreakListener implements Listener {

    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
