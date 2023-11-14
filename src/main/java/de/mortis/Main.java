package de.mortis;

import de.mortis.blueprint.BlueprintManager;
import de.mortis.commands.PluginCommand;
import de.mortis.configuration.TempestConfiguration;
import de.mortis.inventories.InventoryManager;
import de.mortis.items.TempestItemManager;
import de.mortis.mongo.DatabaseManager;
import de.mortis.player.PlayerLevelManager;
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

    private DatabaseManager databaseManager;

    public PlayerStateManager playerStateManager;
    private PlayerLevelManager playerLevelManager;

    public TempestItemManager tempestItemManager;
    private BlueprintManager blueprintManager;

    private TempestConfiguration mainConfiguration;

    private InventoryManager inventoryManager;

    @Override
    public void onEnable() {
        instance = this;

        databaseManager = new DatabaseManager();

        blueprintManager = new BlueprintManager();
        tempestItemManager = new TempestItemManager();
        playerStateManager = new PlayerStateManager(this);
        inventoryManager = new InventoryManager();

        playerLevelManager = new PlayerLevelManager();

        String packageName = getClass().getPackage().getName();
        this.registerListeners(packageName);
        this.registerCommands(packageName);

        mainConfiguration = new TempestConfiguration("config.yaml");
        mainConfiguration.set("blueprint_prefix", "§bBlueprints §7> §r");
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
