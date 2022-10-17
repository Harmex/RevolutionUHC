package me.harmex.revolutionuhc.utils.database;

import me.harmex.revolutionuhc.models.PlayerStats;
import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;

import java.sql.*;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (this.connection != null) {
            return this.connection;
        }
        //String url = "jdbc:mysql://25.56.37.98/revolutionuhc";
        String url = "jdbc:mysql://localhost/revolutionuhc";
        String user = "Harmex";
        String password = "";
        this.connection = DriverManager.getConnection(url, user, password);

        System.out.println("[RevolutionUHC] Connecté à la base de données");
        return this.connection;
    }

    public void initializeDatabase() throws SQLException {
            Statement statement = getConnection().createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(36) primary key, role varchar(16) NOT NULL DEFAULT 'NONE', team varchar(16) NOT NULL DEFAULT 'NONE')";
            statement.execute(sql);
            statement.close();

            System.out.println("[RevolutionUHC] Table créée dans la base de données, ou déjà existante");
    }

    public PlayerStats findPlayerStatsByUUID(String uuid) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT role, team FROM player_stats WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet results = statement.executeQuery();

        if (results.next()) {
            Role role = Role.valueOf(results.getString("role"));
            Team team = Team.valueOf(results.getString("team"));
            return new PlayerStats(uuid, role, team);
        }
        statement.close();
        return null;
    }

    public void createPlayerStats(PlayerStats playerStats) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("INSERT INTO player_stats(uuid, role, team) VALUES (?, ?, ?)");
        statement.setString(1, playerStats.getUuid());
        statement.setString(2, playerStats.getRole().name());
        statement.setString(3, playerStats.getTeam().name());

        statement.executeUpdate();
        System.out.println("[RevolutionUHC] Nouveau joueur, création d'une nouvelle entrée dans la table");
        statement.close();
    }

    public void updatePlayerRole(String uuid, Role role) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET role = ? WHERE uuid = ?");
        statement.setString(1, role.name());
        statement.setString(2, uuid);

        statement.executeUpdate();
        System.out.println("[RevolutionUHC] Rôle mis à jour pour : " + uuid + ", avec le rôle " + role.getName());
        statement.close();
    }

    public void updatePlayerTeam(String uuid, Team team) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET team = ? WHERE uuid = ?");
        statement.setString(1, team.name());
        statement.setString(2, uuid);

        statement.executeUpdate();
        System.out.println("[RevolutionUHC] Équipe mise à jour pour : " + uuid + ", avec l'équipe " + team.getName());
        statement.close();
    }
}
