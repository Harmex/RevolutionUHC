package me.harmex.revolutionuhc.commands;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.utils.gui.MainGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {
    private final RevolutionUHC plugin;

    public MenuCommand(RevolutionUHC plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            MainGUI mainGUI = new MainGUI(this.plugin);
            mainGUI.openFor(player);
        } else {
            System.out.println("Only players can use this command!");
        }
        return true;
    }
}
