package de.mortis.utilities;

import de.mortis.Main;
import org.bukkit.Bukkit;

public class MousePatternDetector {

    private final Main plugin = Main.getInstance();

    public MousePatternDetector() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.getLogger().info("test");
            }
        }, 0, 1500);
    }
}
