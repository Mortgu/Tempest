package de.mortis;

import de.mortis.commands.PluginCommand;
import de.mortis.gui.GraphicalUserInterfaceManager;
import de.mortis.items.CustomItem;
import de.mortis.items.CustomItemManager;
import de.mortis.managers.DatabaseManager;
import de.mortis.managers.items.BlueprintManager;
import de.mortis.managers.PluginManager;
import de.mortis.player.PlayerStateManager;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

@Getter
public final class Main extends JavaPlugin {

    @Getter
    public static Main instance;

    public BlueprintManager blueprintManager;
    public CustomItemManager customItemManager;
    public PlayerStateManager playerStateManager;
    public DatabaseManager databaseManager;
    public GraphicalUserInterfaceManager graphicalUserInterfaceManager;

    @Override
    public void onEnable() {
        instance = this;
        databaseManager = new DatabaseManager(this);
        playerStateManager = new PlayerStateManager(this);
        customItemManager = new CustomItemManager(this);
        graphicalUserInterfaceManager = new GraphicalUserInterfaceManager(this);

        String packageName = getClass().getPackage().getName();
        this.registerListeners(packageName);
        this.registerCommands(packageName);
        this.registerCustomItems(packageName);

        blueprintManager = new BlueprintManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners(String packageName) {
        for (Class<?> clazz : new Reflections(packageName + ".listeners").getSubTypesOf(Listener.class)) {
            try {
                Listener listener = (Listener) clazz.getDeclaredConstructor().newInstance();
                getServer().getPluginManager().registerEvents(listener, this);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException exception) {
                throw new RuntimeException();
            }
        }
    }

    private void registerCommands(String packageName) {
        for (Class<? extends PluginCommand> clazz : new Reflections(packageName + ".commands").getSubTypesOf(PluginCommand.class)) {
            try {
                PluginCommand pluginCommand = clazz.getDeclaredConstructor().newInstance();
                getCommand(pluginCommand.getCommandInfo().name()).setExecutor(pluginCommand);
                getCommand(pluginCommand.getCommandInfo().name()).setTabCompleter(pluginCommand);

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    private void registerManagers(String packageName) {
        for (Class<? extends PluginManager> clazz : new Reflections(packageName + ".managers").getSubTypesOf(PluginManager.class)) {
            try {
                clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException exception) {
                throw new RuntimeException();
            }
        }
    }

    private void registerCustomItems(String packageName) {
        for (Class<? extends CustomItem> clazz : new Reflections(packageName + ".items").getSubTypesOf(CustomItem.class)) {
            try {
                clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException exception) {
                throw new RuntimeException();
            }
        }
    }
}
