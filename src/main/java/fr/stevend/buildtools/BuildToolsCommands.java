package fr.stevend.buildtools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BuildToolsCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory inventory = Bukkit.createInventory(player, 54, ChatColor.LIGHT_PURPLE + "BuildTools");

            ItemStack expand = new ItemStack(Material.GREEN_GLAZED_TERRACOTTA, 1);
            ItemMeta expand_meta = expand.getItemMeta();
            expand_meta.setDisplayName(ChatColor.RED + "Expand");
            ArrayList<String> expand_lore = new ArrayList<String>() {{
                add("Expanding your selection");
            }};
            expand_meta.setLore(expand_lore);
            expand.setItemMeta(expand_meta);

            /* PLAYER HEAD */
            /*ItemStack expand = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta expand_meta = expand.getItemMeta();
            expand_meta.setDisplayName(ChatColor.GREEN + "Expand");
            ArrayList<String> expand_lore = new ArrayList<String>() {{
                add("Expanding your selection");
            }};
            expand_meta.setLore(expand_lore);
            expand.setItemMeta(expand_meta);*/

            ItemStack undo = new ItemStack(Material.MAGENTA_GLAZED_TERRACOTTA, 1);
            ItemMeta undo_meta = undo.getItemMeta();
            undo_meta.setDisplayName(ChatColor.RED + "Undo");
            ArrayList<String> undo_lore = new ArrayList<String>() {{
                add("Undo your last action");
            }};
            undo_meta.setLore(undo_lore);
            undo.setItemMeta(undo_meta);

            ItemStack pos1 = new ItemStack(Material.GOLD_NUGGET, 1);
            ItemMeta pos1_meta = pos1.getItemMeta();
            pos1_meta.setDisplayName(ChatColor.YELLOW + "First position");
            ArrayList<String> pos1_lore = new ArrayList<String>() {{
                add("Set the first position of your selection");
            }};
            pos1_meta.setLore(pos1_lore);
            pos1.setItemMeta(pos1_meta);

            ItemStack pos2 = new ItemStack(Material.GHAST_TEAR, 1);
            ItemMeta pos2_meta = pos2.getItemMeta();
            pos2_meta.setDisplayName(ChatColor.YELLOW + "Second position");
            ArrayList<String> pos2_lore = new ArrayList<String>() {{
                add("Set the second position of your selection");
            }};
            pos2_meta.setLore(pos2_lore);
            pos2.setItemMeta(pos2_meta);

            ItemStack set = new ItemStack(Material.BEDROCK, 1);
            ItemMeta set_meta = set.getItemMeta();
            set_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Set");
            ArrayList<String> set_lore = new ArrayList<String>() {{
                add("Fill the last selection");
            }};
            set_meta.setLore(set_lore);
            set.setItemMeta(set_meta);

            ItemStack replace = new ItemStack(Material.STICKY_PISTON, 1);
            ItemMeta replace_meta = replace.getItemMeta();
            replace_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Replace");
            ArrayList<String> replace_lore = new ArrayList<String>() {{
                add("Replace selection content");
            }};
            replace_meta.setLore(replace_lore);
            replace.setItemMeta(replace_meta);

            ItemStack wall = new ItemStack(Material.COBBLESTONE_WALL, 1);
            ItemMeta wall_meta = wall.getItemMeta();
            wall_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Wall");
            ArrayList<String> wall_lore = new ArrayList<String>() {{
                add("Fill the last selection with empty content");
            }};
            wall_meta.setLore(wall_lore);
            wall.setItemMeta(wall_meta);

            ItemStack cut = new ItemStack(Material.SHEARS, 1);
            ItemMeta cut_meta = cut.getItemMeta();
            cut_meta.setDisplayName(ChatColor.GOLD + "Cut");
            ArrayList<String> cut_lore = new ArrayList<String>() {{
                add("Cut your last selection");
            }};
            cut_meta.setLore(cut_lore);
            cut.setItemMeta(cut_meta);

            ItemStack rotate = new ItemStack(Material.COMPASS, 1);
            ItemMeta rotate_meta = rotate.getItemMeta();
            rotate_meta.setDisplayName(ChatColor.GOLD + "Rotate");
            ArrayList<String> rotate_lore = new ArrayList<String>() {{
                add("Cut your last selection");
            }};
            rotate_meta.setLore(rotate_lore);
            rotate.setItemMeta(rotate_meta);

            ItemStack copy = new ItemStack(Material.BOOKSHELF, 1);
            ItemMeta copy_meta = copy.getItemMeta();
            copy_meta.setDisplayName(ChatColor.GOLD + "Copy");
            ArrayList<String> copy_lore = new ArrayList<String>() {{
                add("Copy your last selection");
            }};
            copy_meta.setLore(copy_lore);
            copy.setItemMeta(copy_meta);

            ItemStack fix = new ItemStack(Material.LEAD, 1);
            ItemMeta fix_meta = fix.getItemMeta();
            fix_meta.setDisplayName(ChatColor.GOLD + "Fix");
            ArrayList<String> fix_lore = new ArrayList<String>() {{
                add("Fix your selection (water, lava or light)");
            }};
            fix_meta.setLore(fix_lore);
            fix.setItemMeta(fix_meta);

            ItemStack paste = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
            ItemMeta paste_meta = paste.getItemMeta();
            paste_meta.setDisplayName(ChatColor.BLUE + "Paste");
            ArrayList<String> paste_lore = new ArrayList<String>() {{
                add("Paste your last clipboard item");
            }};
            paste_meta.setLore(paste_lore);
            paste.setItemMeta(paste_meta);

            ItemStack pasta = new ItemStack(Material.ENCHANTED_BOOK, 1);
            ItemMeta pasta_meta = pasta.getItemMeta();
            pasta_meta.setDisplayName(ChatColor.BLUE + "Paste -a");
            ArrayList<String> pasta_lore = new ArrayList<String>() {{
                add("Paste your last clipboard item without air");
            }};
            pasta_meta.setLore(pasta_lore);
            pasta.setItemMeta(pasta_meta);

            inventory.setItem(0, expand);
            /*inventory.setItem(4, head);*/
            inventory.setItem(8, undo);

            inventory.setItem(12, pos1);
            inventory.setItem(14, pos2);

            inventory.setItem(20, set);
            inventory.setItem(22, replace);
            inventory.setItem(24, wall);

            inventory.setItem(28, cut);
            inventory.setItem(30, rotate);
            inventory.setItem(32, copy);
            inventory.setItem(34, fix);

            inventory.setItem(39, paste);
            inventory.setItem(41, pasta);

            player.openInventory(inventory);
        }

        return true;
    }
}
