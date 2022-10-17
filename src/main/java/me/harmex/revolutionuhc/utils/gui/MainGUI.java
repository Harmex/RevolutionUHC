package me.harmex.revolutionuhc.utils.gui;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.utils.items.GUIItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.harmex.revolutionuhc.utils.items.GUIItems.border;

public class MainGUI {
    private final RevolutionUHC plugin;

    public MainGUI(RevolutionUHC plugin) {
        this.plugin = plugin;
    }

    public void openFor(Player player) {
        //Create the double chest sized inventory
        Inventory menu = Bukkit.createInventory(player, 27, "Revolution UHC");

        GUIItems guiItems = new GUIItems(this.plugin);

        ItemStack role = guiItems.role(player);
        ItemStack team = guiItems.team(player);

        //Init the contents for the menu
        ItemStack[] contents = new ItemStack[] {
                border, border, border, border, border, border, border, border, border,
                border, border, border, role, border, team, border, border, border,
                border, border, border, border, border, border, border, border, border,
        };

        //Set the contents to the menu
        menu.setContents(contents);

        player.openInventory(menu);
    }
}
