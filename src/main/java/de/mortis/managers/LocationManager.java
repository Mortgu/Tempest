package de.mortis.managers;

import de.mortis.Main;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class LocationManager extends PluginManager {

    @Getter
    private FileConfiguration fileConfiguration;

    public LocationManager(Main plugin) {
        super(plugin);

        File file = new File(plugin.getDataFolder(), "player_locations.yml");
    }
}
