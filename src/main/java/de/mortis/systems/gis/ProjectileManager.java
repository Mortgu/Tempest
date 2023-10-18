package de.mortis.systems.gis;

import de.mortis.Main;
import de.mortis.systems.gis.types.ProjectileTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Projectile;
import org.bukkit.persistence.PersistentDataType;

public class ProjectileManager {

    private final NamespacedKey customProjectileKey;

    public ProjectileManager(Main plugin) {
        this.customProjectileKey = new NamespacedKey(plugin, "custom-projectile-type");
    }

    public void setTypedProjectile(Projectile projectile, ProjectileTypes projectileTypes) {
        projectile.getPersistentDataContainer().set(customProjectileKey, PersistentDataType.STRING, customProjectileKey.toString());
    }

    public ProjectileTypes getTypeOfProjectile(Projectile projectile) {
        String typeValue = projectile.getPersistentDataContainer().get(customProjectileKey, PersistentDataType.STRING);

        if (typeValue == null)
            return null;

        return ProjectileTypes.valueOf(typeValue);
    }
}
