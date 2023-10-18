package de.mortis;

import de.mortis.commands.PluginCommand;
import de.mortis.managers.BlueprintManager;
import de.mortis.managers.PluginManager;
import de.mortis.systems.PlayerStateManager;
import de.mortis.systems.gis.CustomItemManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

@Getter
public final class Main extends JavaPlugin {

    @Getter
    public static Main instance;

    @Getter
    public BlueprintManager blueprintManager;

    @Getter
    public CustomItemManager customItemManager;

    @Getter
    public PlayerStateManager playerStateManager;

    @Override
    public void onEnable() {
        instance = this;
        playerStateManager = new PlayerStateManager(this);
        customItemManager = new CustomItemManager(this);

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
}
