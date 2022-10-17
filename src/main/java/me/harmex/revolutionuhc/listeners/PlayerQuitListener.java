package me.harmex.revolutionuhc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    private static void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getDisplayName();
        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "]" + " " + playerName);
    }
}
