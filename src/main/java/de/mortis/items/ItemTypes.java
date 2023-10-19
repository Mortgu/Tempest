package de.mortis.items;

import org.bukkit.event.block.BlockBreakEvent;
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

        @Override
        public void onBlockBreak(BlockBreakEvent event) {

        }
    },
    FARMING() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }

        @Override
        public void onBlockBreak(BlockBreakEvent event) {

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

        @Override
        public void onBlockBreak(BlockBreakEvent event) {

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

        @Override
        public void onBlockBreak(BlockBreakEvent event) {

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

        @Override
        public void onBlockBreak(BlockBreakEvent event) {

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

        @Override
        public void onBlockBreak(BlockBreakEvent event) {

        }
    },
    WORLD_ITEM() {
        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {

        }

        @Override
        public void onBlockBreak(BlockBreakEvent event) {
            event.setCancelled(true);
        }
    };

    public abstract void onInteract(PlayerInteractEvent event);
    public abstract void onInventoryClick(InventoryClickEvent event);
    public abstract void onBlockBreak(BlockBreakEvent event);
}
