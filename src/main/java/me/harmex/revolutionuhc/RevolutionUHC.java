package me.harmex.revolutionuhc;

import me.harmex.revolutionuhc.commands.MenuCommand;
import me.harmex.revolutionuhc.listeners.AsyncPlayerChatListener;
import me.harmex.revolutionuhc.listeners.InventoryClickListener;
import me.harmex.revolutionuhc.listeners.PlayerJoinListener;
import me.harmex.revolutionuhc.listeners.PlayerQuitListener;
import me.harmex.revolutionuhc.utils.commands.SimpleCommand;
import me.harmex.revolutionuhc.utils.database.Database;
import me.harmex.revolutionuhc.utils.items.GUIItems;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class RevolutionUHC extends JavaPlugin {
    private Database database;

    @Override
    public void onEnable() {
        //Connect to database
        try {
            this.database = new Database();
            this.database.initializeDatabase();
            System.out.println("[RevolutionUHC] Base de données initialisée");
        } catch (SQLException e) {
            System.out.println("[RevolutionUHC] Initialisation de la base de données échoué");
            e.printStackTrace();
        }

        //Items
        GUIItems.init();

        //Listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);
        //Commands
        createCommand(new SimpleCommand(
                "revolution",
                "Ouvre le menu principal",
                new MenuCommand(this),
                "rev", "r")
        );

        System.out.println("[RevolutionUHC] Plugin activé");
    }

    @Override
    public void onDisable() {
        //Disconnect to the database

        System.out.println("[RevolutionUHC] Plugin désactivé");
    }

    private void createCommand(SimpleCommand command) {
        CraftServer server = (CraftServer) getServer();
        server.getCommandMap().register(getName(), command);
    }

    public Database getDatabase() {
        return database;
    }
}
