package de.mortis.commands;

import de.mortis.Main;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.*;

public abstract class PluginCommand implements CommandExecutor, TabCompleter {
    @Getter
    private final CommandInfo commandInfo;

    private List<String> delayedPlayer = new ArrayList<>();
    private HashMap<Integer, List<String>> tabComplete = new HashMap<>();
    private HashMap<Command, String[]> commands = new HashMap<>();

    public String commandUsage;

    public PluginCommand() {
        commandInfo = getClass().getDeclaredAnnotation(CommandInfo.class);
        Objects.requireNonNull(commandInfo, "Commands must have CommandInfo annotations");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        commands.put(command, args);

        if (!commandInfo.permission().isEmpty()) {
            if (!sender.hasPermission(commandInfo.permission())) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
                return true;
            }
        }

        if (commandInfo.requiresPlayer()) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You must be a player to execute this command.");
                return true;
            }

            if (commandInfo.delay() > 0 && delayedPlayer.contains(player.getName())) {
                player.sendMessage(ChatColor.RED + "Please wait before using this command again!");
                return true;
            } else {
                execute((Player) sender, args);
                delayedPlayer.add(player.getName());
            }

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, () -> {
                delayedPlayer.remove(player.getName());
            }, 20L * commandInfo.delay());
        }

        execute(sender, args);

        return true;
    }

    public void execute(Player player, String[] args) {}
    public void execute(CommandSender sender, String[] args) {}

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        return null;
    }

    public List<String> getDelayedPlayer() {
        return delayedPlayer;
    }

    public HashMap<Integer, List<String>> getTabComplete() {
        return tabComplete;
    }
}