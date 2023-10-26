package de.mortis.utilities;

import de.mortis.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    public static List<String> lorifyString(String string) {
        if (string == null || string.isEmpty())
            return new ArrayList<>();

        List<String> substrings = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(string);

        StringBuilder currentSubstring = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (currentSubstring.length() + word.length() + 1 <= 25) {
                if (currentSubstring.length() > 0) {
                    currentSubstring.append(" ");
                }
                currentSubstring.append(word);
            } else {
                substrings.add("§7" + currentSubstring.toString());
                currentSubstring = new StringBuilder(word);
            }
        }

        if (currentSubstring.length() > 0) {
            substrings.add("§7" + currentSubstring.toString());
        }

        return substrings;
    }
}