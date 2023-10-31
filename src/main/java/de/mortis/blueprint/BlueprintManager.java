package de.mortis.blueprint;

import de.mortis.Main;
import de.mortis.configuration.TempestConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BlueprintManager {

    private final Main plugin = Main.getInstance();

    private final File blueprintFolder;
    private TempestConfiguration tempestConfiguration;

    private ArrayList<File> registeredBlueprints;

    private String unnamedBlueprintName = "unnamed.blueprint";

    public BlueprintManager() {
        blueprintFolder = new File(plugin.getDataFolder(), "blueprints");
        registeredBlueprints = new ArrayList<>();

        if (!blueprintFolder.exists())
            blueprintFolder.mkdir();

        loadBlueprints();
    }

    public void loadBlueprints() {
        for (File file : blueprintFolder.listFiles()) {
            if (!file.getName().endsWith(".blueprint")) {
                continue;
            }

            registeredBlueprints.add(file);
        }
    }

    int repeats = 0;
    public BlueprintManager create(String defaultName) {
        File blueprint = new File(blueprintFolder, defaultName + ".blueprint");
        if (blueprint.exists()) {
            repeats++;
            create("unnamed_" + String.valueOf(repeats));
        }

        try {
            blueprint.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        registeredBlueprints.add(blueprint);
        return this;
    }

    public ArrayList list() {
        return registeredBlueprints;
    }

    public ArrayList list(String filter) {
        return registeredBlueprints;
    }
}
