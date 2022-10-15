package me.harmex.revolutionuhc;

import org.bukkit.plugin.java.JavaPlugin;

public class RevolutionUHC extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("[RevolutionUHC] Enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("[RevolutionUHC] Disabled");
    }
}
