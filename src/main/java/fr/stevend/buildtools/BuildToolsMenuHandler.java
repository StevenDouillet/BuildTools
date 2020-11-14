package fr.stevend.buildtools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildToolsMenuHandler implements Listener {

    public Action action;

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(!player.isOp()) {
            player.sendMessage(ChatColor.RED +  "Vous n'avez pas la permission d'utiliser cet objet !");
            return;
        }
        if(player.getInventory().getItemInMainHand().getType() == Material.CARROT_ON_A_STICK
                && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Carotte magique")){
            player.performCommand("bt");
        }
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "BuildTools")) {

            e.setCancelled(true);
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {return;}

            switch(e.getCurrentItem().getType()) {
                case GREEN_GLAZED_TERRACOTTA:
                    player.closeInventory();
                    player.performCommand("/expand vert");
                    break;

                case MAGENTA_GLAZED_TERRACOTTA:
                    player.closeInventory();
                    player.performCommand("/undo");
                    break;

                case GOLD_NUGGET:
                    player.closeInventory();
                    player.performCommand("/pos1");
                    break;

                case GHAST_TEAR:
                    player.closeInventory();
                    player.performCommand("/pos2");
                    break;

                case SHEARS:
                    player.closeInventory();
                    player.performCommand("/cut");
                    break;

                case BOOKSHELF:
                    player.closeInventory();
                    player.performCommand("/copy");
                    break;

                case KNOWLEDGE_BOOK:
                    player.closeInventory();
                    player.performCommand("/paste");
                    break;

                case ENCHANTED_BOOK:
                    player.closeInventory();
                    player.performCommand("/paste -a");
                    break;

                case LEAD:
                    Inventory fixInv = Bukkit.createInventory(player, 27, ChatColor.DARK_GRAY + "Choix du fix");

                    ItemStack water = new ItemStack(Material.WATER_BUCKET, 1);
                    ItemMeta water_meta = water.getItemMeta();
                    water_meta.setDisplayName(ChatColor.GOLD + "Fix water");
                    water.setItemMeta(water_meta);

                    ItemStack light = new ItemStack(Material.LANTERN, 1);
                    ItemMeta light_meta = light.getItemMeta();
                    light_meta.setDisplayName(ChatColor.GOLD + "Fix lights");
                    light.setItemMeta(light_meta);

                    ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1);
                    ItemMeta lava_meta = lava.getItemMeta();
                    lava_meta.setDisplayName(ChatColor.GOLD + "Fix lava");
                    lava.setItemMeta(lava_meta);

                    fixInv.setItem(11, water);
                    fixInv.setItem(13, light);
                    fixInv.setItem(15, lava);

                    player.closeInventory();
                    player.openInventory(fixInv);
                    break;

                case COMPASS:
                    Inventory rotateInv = Bukkit.createInventory(player, 27, ChatColor.DARK_GRAY + "Choix de la rotation");

                    ItemStack rotate90 = new ItemStack(Material.YELLOW_WOOL, 1);
                    ItemMeta rotate90_meta = rotate90.getItemMeta();
                    rotate90_meta.setDisplayName(ChatColor.GOLD + "Rotate 90 degrees");
                    rotate90.setItemMeta(rotate90_meta);

                    ItemStack rotate180 = new ItemStack(Material.ORANGE_WOOL, 1);
                    ItemMeta rotate180_meta = rotate180.getItemMeta();
                    rotate180_meta.setDisplayName(ChatColor.GOLD + "Rotate 180 degrees");
                    rotate180.setItemMeta(rotate180_meta);

                    rotateInv.setItem(12, rotate90);
                    rotateInv.setItem(14, rotate180);

                    player.closeInventory();
                    player.openInventory(rotateInv);
                    break;

                case BEDROCK:
                case COBBLESTONE_WALL:
                    Inventory materialInv = Bukkit.createInventory(player, 54, ChatColor.DARK_GRAY + "Choix du matériaux");

                    ItemStack stone = new ItemStack(Material.STONE, 1);
                    ItemStack cobblestone = new ItemStack(Material.COBBLESTONE, 1);
                    ItemStack grassBlock = new ItemStack(Material.GRASS_BLOCK, 1);
                    ItemStack sand = new ItemStack(Material.SAND, 1);
                    ItemStack oak_planks = new ItemStack(Material.OAK_PLANKS, 1);
                    ItemStack spruce_planks = new ItemStack(Material.SPRUCE_PLANKS, 1);
                    ItemStack dark_oak_planks = new ItemStack(Material.DARK_OAK_PLANKS, 1);
                    ItemStack beach = new ItemStack(Material.SPONGE, 1);
                    ItemStack house_wall = new ItemStack(Material.CHISELED_STONE_BRICKS, 1);
                    ItemStack medieval_road = new ItemStack(Material.RAIL, 1);

                    materialInv.setItem(0, stone);
                    materialInv.setItem(1, cobblestone);
                    materialInv.setItem(2, grassBlock);
                    materialInv.setItem(3, sand);
                    materialInv.setItem(4, oak_planks);
                    materialInv.setItem(5, spruce_planks);
                    materialInv.setItem(6, dark_oak_planks);
                    materialInv.setItem(38, beach);
                    materialInv.setItem(40, house_wall);
                    materialInv.setItem(42, medieval_road);

                    Material material = e.getCurrentItem().getType();
                    if(material == Material.BEDROCK) {
                        this.action = Action.SET;
                    } else if(material == Material.COBBLESTONE_WALL) {
                        this.action = Action.WALLS;
                    }

                    player.closeInventory();
                    player.openInventory(materialInv);
                    break;

            }

        }

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Choix du matériaux")) {

            e.setCancelled(true);
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {return;}

            switch(e.getCurrentItem().getType()) {
                case STONE:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " stone");
                    break;

                case COBBLESTONE:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " cobblestone");
                    break;

                case GRASS_BLOCK:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " 2");
                    break;

                case SAND:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " sand");
                    break;

                case OAK_PLANKS:
                    player.closeInventory();
                    player.performCommand("" + this.action.toString().toLowerCase() + " minecraft:oak_planks");
                    break;

                case SPRUCE_PLANKS:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " minecraft:spruce_planks");
                    break;

                case DARK_OAK_PLANKS:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " minecraft:dark_oak_planks");
                    break;

                case SPONGE:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " 10%minecraft:dead_tube_coral_block,60%sand,5%minecraft:dead_horn_coral_block,1%minecraft:brain_coral_block,1%minecraft:tube_coral_block,1%minecraft:horn_coral_block,1%minecraft:bubble_coral_block,20%minecraft:gravel");
                    break;

                case CHISELED_STONE_BRICKS:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " 6%minecraft:dead_bubble_coral_block,6%minecraft:dead_tube_coral_block,35%minecraft:stone,20%minecraft:cobblestone,16%minecraft:dead_brain_coral_block");
                    break;

                case RAIL:
                    player.closeInventory();
                    player.performCommand("/" + this.action.toString().toLowerCase() + " 30%cobblestone,30%andesite,30%gravel");
                    break;
            }
        }

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Choix du fix")) {

            e.setCancelled(true);
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {return;}

            switch(e.getCurrentItem().getType()) {
                case WATER_BUCKET:
                    player.closeInventory();
                    player.performCommand("/fixwater 100");
                    break;

                case LANTERN:
                    player.closeInventory();
                    player.performCommand("/fixlighting");
                    break;

                case LAVA_BUCKET:
                    player.closeInventory();
                    player.performCommand("/fixlava 100");
                    break;
            }
        }

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Choix de la rotation")) {

            e.setCancelled(true);
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {return;}

            switch(e.getCurrentItem().getType()) {
                case YELLOW_WOOL:
                    player.closeInventory();
                    player.performCommand("/rotate 90");
                    break;

                case ORANGE_WOOL:
                    player.closeInventory();
                    player.performCommand("/rotate 180");
                    break;
            }
        }

    }

}
