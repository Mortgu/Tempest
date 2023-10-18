package de.mortis.systems.gis.types;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.entity.ProjectileHitEvent;

public enum ProjectileTypes {

    EXPLOSION() {
        @Override
        void handleImpact(ProjectileHitEvent event) {
            World world = event.getEntity().getWorld();
            Location location = event.getEntity().getLocation();
            world.createExplosion(location, 3f);
        }
    },
    LIGHTNING() {
        @Override
        void handleImpact(ProjectileHitEvent event) {
            World world = event.getEntity().getWorld();
            Location location = event.getEntity().getLocation();
            world.strikeLightning(location);
        }
    };

    abstract void handleImpact(ProjectileHitEvent event);

}
