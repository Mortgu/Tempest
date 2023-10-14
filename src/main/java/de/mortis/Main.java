package de.mortis;

import de.mortis.commands.PluginCommand;
import de.mortis.manager.BlueprintManager;
import de.mortis.manager.PluginManager;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Getter
public final class Main extends JavaPlugin {

    @Getter
    public static Main instance;

    @Getter
    public BlueprintManager blueprintManager;

    @Override
    public void onEnable() {
        instance = this;

        String packageName = getClass().getPackage().getName();
        this.registerListeners(packageName);
        this.registerCommands(packageName);

        blueprintManager = new BlueprintManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners(String packageName) {
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

    public void registerCommands(String packageName) {
        for (Class<? extends PluginCommand> clazz : new Reflections(packageName + ".commands").getSubTypesOf(PluginCommand.class)) {
            try {
                PluginCommand pluginCommand = clazz.getDeclaredConstructor().newInstance();
                getCommand(pluginCommand.getCommandInfo().name()).setExecutor(pluginCommand);
                getCommand(pluginCommand.getCommandInfo().name()).setTabCompleter(pluginCommand);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException exception) {
                throw new RuntimeException();
            }
        }
    }

    public void registerManagers(String packageName) {
        for (Class<? extends PluginManager> clazz : new Reflections(packageName + ".manager").getSubTypesOf(PluginManager.class)) {
            try {
                clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException exception) {
                throw new RuntimeException();
            }
        }
    }
}
