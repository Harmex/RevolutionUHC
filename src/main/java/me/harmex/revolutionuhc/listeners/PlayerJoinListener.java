package me.harmex.revolutionuhc.listeners;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.models.PlayerStats;
import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
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
        Player player = event.getPlayer();
        String playerName = player.getDisplayName();
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "]" + " " + playerName);

        PlayerStats playerStats = null;

        try {
            playerStats = this.plugin.getDatabase().findPlayerStatsByUUID(event.getPlayer().getUniqueId().toString());
            player.setPlayerListName(ChatColor.GRAY + "[" + playerStats.getTeam().getColor() + "" + playerStats.getTeam().getName() + ChatColor.GRAY + "]"
                    + " " + playerName);
        } catch (SQLException e) {
            System.out.println("[RevolutionUHC] Impossible de récuperer les informations du joueur dans la base de données");
        }
        try {
            if (playerStats == null) {
                playerStats = new PlayerStats(event.getPlayer().getUniqueId().toString(), Role.NONE, Team.NONE);
                this.plugin.getDatabase().createPlayerStats(playerStats);
            }
        } catch (SQLException e) {
            System.out.println("[RevolutionUHC] Impossible de créer une entrée avec les informations du joueur dans la base de données");
        }
    }
}
