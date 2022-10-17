package me.harmex.revolutionuhc.listeners;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.models.PlayerStats;
import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class PlayerJoinListener implements Listener {
    private final RevolutionUHC plugin;

    public PlayerJoinListener(RevolutionUHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName();
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "]" + " " + playerName);

        try {
            PlayerStats playerStats = this.plugin.getDatabase().findPlayerStatsByUUID(event.getPlayer().getUniqueId().toString());
            if (playerStats == null) {
                playerStats = new PlayerStats(event.getPlayer().getUniqueId().toString(), Role.NONE, Team.NONE);
                this.plugin.getDatabase().createPlayerStats(playerStats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
