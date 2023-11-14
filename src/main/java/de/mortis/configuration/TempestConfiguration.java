package de.mortis.configuration;

import de.mortis.Main;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

@Getter
public class TempestConfiguration {

    private final JavaPlugin plugin = Main.getInstance();

    private final FileConfiguration configuration;
    private final File configurationFile;

    public TempestConfiguration(String fileName) {
        configurationFile = new File(plugin.getDataFolder(), fileName);

        if (!plugin.getDataFolder().exists())
            plugin.getDataFolder().mkdir();

        if (!configurationFile.exists()) {
            Bukkit.getLogger().info(fileName);
            try {
                configurationFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        configuration = new YamlConfiguration();

        try {
            configuration.load(configurationFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save(File configurationFile) {
        try {
            configuration.save(new File(plugin.getDataFolder(), configurationFile.getName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public<T> TempestConfiguration set(String path, T value) {
        if (configuration.get(path) == null) {
            configuration.set(path, value);
            save(configurationFile);
        }
        return this;
    }

    public<T> T get(String path) {
        return (T) configuration.get(path);
    }
}
