package de.mortis.utilities;

import de.mortis.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class MessageHandler {
    public static Main plugin = Main.getInstance();

    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void send(Player player, String message) {
        File file = new File(plugin.getDataFolder() + "/", "configuration.yml");
        player.sendMessage(translate(message));
    }

    public static void send(Player player, List<String> messages) {
        messages.forEach(message -> {
            player.sendMessage(translate(message));
        });
    }

    public static void debug(String message) {
        File file = new File(plugin.getDataFolder() + "/", "configuration.yml");
        Bukkit.getConsoleSender().sendMessage(translate(message));
    }

    public static void debug(Player player, String message) {
        player.sendMessage(plugin.getConfig().getString("DEBUG_PREFIX") + translate(message));
    }
}