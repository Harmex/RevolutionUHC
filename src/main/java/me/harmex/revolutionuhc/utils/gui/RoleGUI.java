package me.harmex.revolutionuhc.utils.gui;

import me.harmex.revolutionuhc.utils.items.GUIItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.harmex.revolutionuhc.utils.items.GUIItems.back;
import static me.harmex.revolutionuhc.utils.items.GUIItems.border;

public class RoleGUI {

    public static void openFor(Player player) {
        //Create the double chest sized inventory
        Inventory menu = Bukkit.createInventory(player, 36, "Choisis ton rôle !");

        ItemStack boss = GUIItems.boss();
        ItemStack miner = GUIItems.miner();
        ItemStack baker = GUIItems.baker();
        ItemStack butcher = GUIItems.butcher();
        ItemStack doctor = GUIItems.doctor();
        ItemStack guard = GUIItems.guard();
        ItemStack soldier = GUIItems.soldier();
        ItemStack archer = GUIItems.archer();

        //Init the contents for the menu
        ItemStack[] contents = new ItemStack[] {
                border, border, border, border, border, border, border, border, border,
                border, border, border, border, boss, border, border, border, border,
                border, miner, baker, butcher, doctor, guard, soldier, archer, border,
                border, border, border, border, back, border, border, border, border,
        };

        //Set the contents to the menu
        menu.setContents(contents);

        player.openInventory(menu);
    }
}
