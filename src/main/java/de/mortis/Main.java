package de.mortis;

import de.mortis.commands.PluginCommand;
import de.mortis.gui.GraphicalUserInterfaceManager;
import de.mortis.items.TempestItemManager;
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
    public PlayerStateManager playerStateManager;
    public DatabaseManager databaseManager;
    public GraphicalUserInterfaceManager graphicalUserInterfaceManager;
    public TempestItemManager tempestItemManager;

    @Override
    public void onEnable() {
        instance = this;
        databaseManager = new DatabaseManager(this);
        graphicalUserInterfaceManager = new GraphicalUserInterfaceManager(this);
        tempestItemManager = new TempestItemManager();
        playerStateManager = new PlayerStateManager(this);

        String packageName = getClass().getPackage().getName();
        this.registerListeners(packageName);
        this.registerCommands(packageName);

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
}
