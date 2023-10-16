package de.mortis.managers;

import de.mortis.Main;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class PluginManager {

    @Getter
    protected Main plugin;
}
