package de.mortis.systems.gis.types;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public enum ItemTypes {
    WEAPON() {
        @Override
        public void onInteract(PlayerInteractEvent event) {
            event.getPlayer().sendMessage("Interaction with Weapon#");
        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {}
    },
    FARMING() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }
    },
    FISHING() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }
    },
    MINING() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }
    },
    BUILDING() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }
    },
    MENU_ITEM() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }
    },
    WORLD_ITEM() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {

        }
    };

    public String displayName;
    public abstract void onInteract(PlayerInteractEvent event);
    public abstract void onInventoryClick(InventoryClickEvent event);
}
