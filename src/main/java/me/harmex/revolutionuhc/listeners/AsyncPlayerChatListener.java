package me.harmex.revolutionuhc.listeners;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.models.PlayerStats;
import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.sql.SQLException;

public class AsyncPlayerChatListener implements Listener {
    private final RevolutionUHC plugin;

    public AsyncPlayerChatListener(RevolutionUHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Role role = Role.NONE;
        Team team = Team.NONE;
        try {
            PlayerStats playerStats = this.plugin.getDatabase().findPlayerStatsByUUID(player.getUniqueId().toString());
            role = playerStats.getRole();
            team = playerStats.getTeam();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        event.setFormat(ChatColor.GRAY + "[" + team.getColor() + "" + team.getName() + ChatColor.GRAY + ""
                + ChatColor.RESET + " - "
                + ChatColor.GRAY + "" + role.getColor() + "" + role.getName() + ChatColor.GRAY + "]"
                + ChatColor.RESET + " %s : " + ChatColor.GRAY + "%s"
        );
    }
}
