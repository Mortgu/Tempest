package de.mortis.items;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public enum ItemTypes {
    WEAPON() {
        @Override
        public void onInventoryDrag(InventoryMoveItemEvent event) {

        }

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
        public void onInventoryDrag(InventoryMoveItemEvent event) {

        }

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
        public void onInventoryDrag(InventoryMoveItemEvent event) {

        }

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
        public void onInventoryDrag(InventoryMoveItemEvent event) {

        }

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
        public void onInventoryDrag(InventoryMoveItemEvent event) {

        }

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
        public void onInventoryDrag(InventoryMoveItemEvent event) {
            event.setCancelled(true);
        }

        @Override
        public void onInteract(PlayerInteractEvent event) {

        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.setCancelled(true);
        }

        @Override
        public void onBlockBreak(BlockBreakEvent event) {
            event.setCancelled(true);
        }
    },
    WORLD_ITEM() {
        @Override
        public void onInventoryDrag(InventoryMoveItemEvent event) {

        }

        @Override
        public void onInteract(PlayerInteractEvent event) {
            event.getPlayer().sendMessage("Interaction with a world item");
        }

        @Override
        public void onInventoryClick(InventoryClickEvent event) {
            event.getWhoClicked().sendMessage("Inventory click with a world item");
        }

        @Override
        public void onBlockBreak(BlockBreakEvent event) {
            event.getPlayer().sendMessage("BlockBreak with a world item");
            event.setCancelled(true);
        }
    };

    public abstract void onInventoryDrag(InventoryMoveItemEvent event);
    public abstract void onInteract(PlayerInteractEvent event);
    public abstract void onInventoryClick(InventoryClickEvent event);
    public abstract void onBlockBreak(BlockBreakEvent event);
}
