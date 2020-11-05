package fr.stevend.buildtools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BuildToolsMenuHandler implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(player.getInventory().getItemInMainHand().getType() == Material.CARROT_ON_A_STICK){
            player.performCommand("bt");
        }
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "BuildTools")) {

            if(e.getCurrentItem().getType() != null) {

                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                Material currentItem = e.getCurrentItem().getType();

                switch(currentItem) {
                    case SHEARS:
                        player.performCommand("/cut");
                        player.sendMessage(ChatColor.RED + "Cutting in progress ...");
                        break;

                    case YELLOW_DYE:
                        player.performCommand("/copy");
                        player.sendMessage(ChatColor.YELLOW + "Copying in progress ...");
                        break;

                    case PURPLE_DYE:
                        player.performCommand("/paste");
                        player.sendMessage(ChatColor.DARK_PURPLE + "Pasting in progress ...");
                        break;

                    case COBWEB:
                        player.performCommand("/undo");
                        player.sendMessage(ChatColor.GREEN + "Undoing in progress ...");
                        break;
                }

                player.closeInventory();

            }

        }

    }

}
