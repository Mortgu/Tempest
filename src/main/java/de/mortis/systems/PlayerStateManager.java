package de.mortis.systems;

import de.mortis.Main;
import de.mortis.player.types.PlayerModes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerStateManager {

    private final NamespacedKey playerNamespaceKey;

    public PlayerStateManager(Main plugin) {
        this.playerNamespaceKey = new NamespacedKey(plugin, "player-mode");
    }

    public void setPlayerMode(Player player, PlayerModes playerMode) {
        PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
        persistentDataContainer.set(this.playerNamespaceKey, PersistentDataType.STRING, playerMode.toString());
    }

    public PlayerModes getPlayerMode(Player player) {
        String typeValue = player.getPersistentDataContainer().get(this.playerNamespaceKey, PersistentDataType.STRING);

        if (typeValue == null)
            return null;

        return PlayerModes.valueOf(typeValue);
    }
}
