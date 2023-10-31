package de.mortis.commands;

import de.mortis.Main;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.*;

@Getter
public abstract class PluginCommand implements CommandExecutor, TabCompleter {
    private final CommandInfo commandInfo;

    private final List<String> delayedPlayer = new ArrayList<>();
    private final HashMap<Integer, List<String>> tabComplete = new HashMap<>();
    private final HashMap<Command, String[]> commands = new HashMap<>();

    public String commandUsage;

    public PluginCommand() {
        commandInfo = getClass().getDeclaredAnnotation(CommandInfo.class);
        Objects.requireNonNull(commandInfo, "Commands must have CommandInfo annotations");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (commandInfo.requiresPlayer() && !(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to execute this command.");
            return true;
        }

        Player player = (Player) sender;

        commands.put(command, args);

        if (!commandInfo.permission().isEmpty()) {
            if (!sender.hasPermission(commandInfo.permission())) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
                return true;
            }
        }

        if (commandInfo.requiresPlayer()) {
            if (sender == null) {
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

    /**
     *
     *
     public CommandMap getCommandMap() throws NoSuchFieldException, IllegalAccessException {
     if (!(Bukkit.getPluginManager() instanceof SimplePluginManager)) {
     return null;
     }

     Field field = SimplePluginManager.class.getDeclaredField("commandMap");
     field.setAccessible(true);

     return (CommandMap) field.get(Bukkit.getPluginManager());
     }
     * @param player
     * @param args
     */

    public void execute(Player player, String[] args) {}
    public void execute(CommandSender sender, String[] args) {}

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        return null;
    }
}