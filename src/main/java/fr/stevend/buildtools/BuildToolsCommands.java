package fr.stevend.buildtools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BuildToolsCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.LIGHT_PURPLE + "BuildTools");

            ItemStack cut = new ItemStack(Material.SHEARS, 1);
            ItemMeta cut_meta = cut.getItemMeta();
            cut_meta.setDisplayName(ChatColor.RED + "Cut");
            ArrayList<String> cut_lore = null;
            cut_lore.add("This will cut your last world edit selection");
            cut_meta.setLore(cut_lore);
            cut.setItemMeta(cut_meta);

            ItemStack copy = new ItemStack(Material.YELLOW_DYE, 1);
            ItemMeta copy_meta = copy.getItemMeta();
            copy_meta.setDisplayName(ChatColor.YELLOW + "Copy");
            ArrayList<String> copy_lore = null;
            copy_lore.add("This will copy your last world edit selection");
            copy_meta.setLore(copy_lore);
            copy.setItemMeta(copy_meta);

            ItemStack paste = new ItemStack(Material.PURPLE_DYE, 1);
            ItemMeta paste_meta = paste.getItemMeta();
            paste_meta.setDisplayName(ChatColor.DARK_PURPLE + "Paste");
            ArrayList<String> paste_lore = null;
            paste_lore.add("This will paste your last clipboard item");
            paste_meta.setLore(paste_lore);
            paste.setItemMeta(paste_meta);

            ItemStack undo = new ItemStack(Material.WRITTEN_BOOK, 1);
            ItemMeta undo_meta = undo.getItemMeta();
            undo_meta.setDisplayName(ChatColor.GREEN + "Undo");
            ArrayList<String> undo_lore = null;
            undo_lore.add("This will Undo your last world edit action");
            undo_meta.setLore(undo_lore);
            undo.setItemMeta(undo_meta);

            inventory.setItem(2, cut);
            inventory.setItem(4, copy);
            inventory.setItem(6, paste);
            inventory.setItem(8, undo);
            player.openInventory(inventory);
        }

        return true;
    }
}
