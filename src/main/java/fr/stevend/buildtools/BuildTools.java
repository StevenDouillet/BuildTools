package fr.stevend.buildtools;

import org.bukkit.plugin.java.JavaPlugin;

public final class BuildTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bt").setExecutor(new BuildToolsCommands());
        getCommand("buildtools").setExecutor(new BuildToolsCommands());
        getServer().getPluginManager().registerEvents(new BuildToolsMenuHandler(), this);
    }

}
