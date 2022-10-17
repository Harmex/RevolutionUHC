package me.harmex.revolutionuhc.utils.gui;

import me.harmex.revolutionuhc.utils.items.GUIItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.harmex.revolutionuhc.utils.items.GUIItems.back;
import static me.harmex.revolutionuhc.utils.items.GUIItems.border;

public class TeamGUI {

    public static void openFor(Player player) {
        //Create the double chest sized inventory
        Inventory menu = Bukkit.createInventory(player, 54, "Choisis ton équipe !");

        ItemStack white = GUIItems.white();
        ItemStack orange = GUIItems.orange();
        ItemStack magenta = GUIItems.magenta();
        ItemStack lightBlue = GUIItems.lightBlue();
        ItemStack yellow = GUIItems.yellow();
        ItemStack lime = GUIItems.lime();
        ItemStack pink = GUIItems.pink();
        ItemStack gray = GUIItems.gray();
        ItemStack lightGray = GUIItems.lightGray();
        ItemStack cyan = GUIItems.cyan();
        ItemStack purple = GUIItems.purple();
        ItemStack blue = GUIItems.blue();
        ItemStack brown = GUIItems.brown();
        ItemStack green = GUIItems.green();
        ItemStack red = GUIItems.red();
        ItemStack black = GUIItems.black();

        //Init the contents for the menu
        ItemStack[] contents = new ItemStack[] {
                border, border, border, border, border, border, border, border, border,
                border, border, white, orange, border, lightGray, cyan, border, border,
                border, border, magenta, lightBlue, border, purple, blue, border, border,
                border, border, yellow, lime, border, brown, green, border, border,
                border, border, pink, gray, border, red, black, border, border,
                border, border, border, border, back, border, border, border, border,
        };

        //Set the contents to the menu
        menu.setContents(contents);

        player.openInventory(menu);
    }
}
