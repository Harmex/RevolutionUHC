package me.harmex.revolutionuhc.listeners;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;
import me.harmex.revolutionuhc.utils.constants.CustomModelData;
import me.harmex.revolutionuhc.utils.gui.MainGUI;
import me.harmex.revolutionuhc.utils.gui.RoleGUI;
import me.harmex.revolutionuhc.utils.gui.TeamGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.SQLException;

public class InventoryClickListener implements Listener {
    private final RevolutionUHC plugin;

    public InventoryClickListener(RevolutionUHC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        String uuid = player.getUniqueId().toString();
        ItemStack itemStack = event.getCurrentItem();
        MainGUI mainGUI = new MainGUI(this.plugin);

        //Main Menu
        if (title.equalsIgnoreCase("Revolution UHC")) {
            event.setCancelled(true);
            if (itemStack != null) {
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (itemMeta != null && itemMeta.hasCustomModelData()) {
                    if (itemMeta.getCustomModelData() == CustomModelData.role) {
                        RoleGUI.openFor(player);
                    }
                    if (itemMeta.getCustomModelData() == CustomModelData.team) {
                        TeamGUI.openFor(player);
                    }
                }
            }
        }

        //Role Menu
        try {
            if (title.equalsIgnoreCase("Choisis ton rôle !")) {
                event.setCancelled(true);
                if (itemStack != null) {
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta != null && itemMeta.hasCustomModelData()) {
                        if (itemMeta.getCustomModelData() == CustomModelData.back) {
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.boss) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.BOSS);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.miner) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.MINER);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.baker) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.BAKER);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.butcher) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.BUTCHER);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.doctor) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.DOCTOR);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.guard) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.GUARD);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.soldier) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.SOLDIER);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.archer) {
                            this.plugin.getDatabase().updatePlayerRole(uuid, Role.ARCHER);
                            mainGUI.openFor(player);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("[RevolutionUHC] Impossible de mettre à jour le rôle du joueur dans la base de données");
        }
        //Team Menu
        try {
            if (title.equalsIgnoreCase("Choisis ton équipe !")) {
                event.setCancelled(true);
                if (itemStack != null) {
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta != null && itemMeta.hasCustomModelData()) {
                        if (itemMeta.getCustomModelData() == CustomModelData.back) {
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.white) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.WHITE);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.orange) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.ORANGE);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.magenta) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.MAGENTA);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.lightBlue) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.LIGHT_BLUE);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.yellow) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.YELLOW);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.lime) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.LIME);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.pink) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.PINK);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.gray) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.GRAY);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.lightGray) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.LIGHT_GRAY);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.cyan) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.CYAN);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.purple) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.PURPLE);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.blue) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.BLUE);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.brown) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.BROWN);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.green) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.GREEN);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.red) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.RED);
                            mainGUI.openFor(player);
                        }
                        if (itemMeta.getCustomModelData() == CustomModelData.black) {
                            this.plugin.getDatabase().updatePlayerTeam(uuid, Team.BLACK);
                            mainGUI.openFor(player);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("[RevolutionUHC] Impossible de mettre à jour l'équipe du joueur dans la base de données");
        }
    }
}
