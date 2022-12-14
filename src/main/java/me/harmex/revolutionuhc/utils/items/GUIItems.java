package me.harmex.revolutionuhc.utils.items;

import me.harmex.revolutionuhc.RevolutionUHC;
import me.harmex.revolutionuhc.models.PlayerStats;
import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;
import me.harmex.revolutionuhc.utils.constants.CustomModelData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GUIItems {
    private final RevolutionUHC plugin;

    public GUIItems(RevolutionUHC plugin) {
        this.plugin = plugin;
    }

    public static ItemStack border;
    public static ItemStack back;

    public static void init() {
        border();
        back();
    }

    private static void border() {
        //create an item stack of 1 glass pane
        ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(" ");
        itemMeta.setCustomModelData(CustomModelData.border);

        //put the meta on the item stack
        itemStack.setItemMeta(itemMeta);

        border = itemStack;
    }
    private static void back() {
        //create an item stack of 1 glass pane
        ItemStack itemStack = new ItemStack(Material.ARROW);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.WHITE + "Retour");
        itemMeta.setCustomModelData(CustomModelData.back);

        //put the meta on the item stack
        itemStack.setItemMeta(itemMeta);

        back = itemStack;
    }

    public ItemStack role(Player player) {
        ItemStack itemStack = new ItemStack(Material.STONE);
        ItemMeta meta = itemStack.getItemMeta();
        try {
            PlayerStats playerStats = this.plugin.getDatabase().findPlayerStatsByUUID(player.getUniqueId().toString());
            Role role = playerStats.getRole();

            switch (role) {
                case BOSS -> itemStack = boss();
                case MINER -> itemStack = miner();
                case BAKER -> itemStack = baker();
                case BUTCHER -> itemStack = butcher();
                case DOCTOR -> itemStack = doctor();
                case GUARD -> itemStack = guard();
                case SOLDIER -> itemStack = soldier();
                case ARCHER -> itemStack = archer();
            }
            meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.GRAY + "Votre r??le : " + role.getColor() + role.getName());
            meta.setCustomModelData(CustomModelData.role);

            List<String> lore = meta.getLore();
            if (lore == null) {
                lore = new ArrayList<>();
            }
            lore.add("");
            lore.add(ChatColor.GRAY + "Cliquez pour changer votre r??le !");
            meta.setLore(lore);

            itemStack.setItemMeta(meta);

        } catch (SQLException e) {
            assert meta != null;
            meta.setDisplayName(ChatColor.RED + "Oh non !");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Impossible de se connecter");
            lore.add(ChatColor.GRAY + "?? la base de donn??es !");
            meta.setLore(lore);
            itemStack.setItemMeta(meta);
        }


        return itemStack;
    }
    public ItemStack team(Player player) {
        ItemStack itemStack = new ItemStack(Material.STONE);
        ItemMeta meta = itemStack.getItemMeta();
        try {
            PlayerStats playerStats = this.plugin.getDatabase().findPlayerStatsByUUID(player.getUniqueId().toString());
            Team team = playerStats.getTeam();

            switch (team) {
                case WHITE -> itemStack = white();
                case ORANGE -> itemStack = orange();
                case MAGENTA -> itemStack = magenta();
                case LIGHT_BLUE -> itemStack = lightBlue();
                case YELLOW -> itemStack = yellow();
                case LIME -> itemStack = lime();
                case PINK -> itemStack = pink();
                case GRAY -> itemStack = gray();
                case LIGHT_GRAY -> itemStack = lightGray();
                case CYAN -> itemStack = cyan();
                case PURPLE -> itemStack = purple();
                case BLUE -> itemStack = blue();
                case BROWN -> itemStack = brown();
                case GREEN -> itemStack = green();
                case RED -> itemStack = red();
                case BLACK -> itemStack = black();
            }
            meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.GRAY + "Votre ??quipe : " + team.getColor() + team.getName());
            meta.setCustomModelData(CustomModelData.team);

            List<String> lore = meta.getLore();
            if (lore == null) {
                lore = new ArrayList<>();
            }
            lore.add("");
            lore.add(ChatColor.GRAY + "Cliquez pour changer votre ??quipe !");
            meta.setLore(lore);

            itemStack.setItemMeta(meta);

        } catch (SQLException e) {
            assert meta != null;
            meta.setDisplayName(ChatColor.RED + "Oh non !");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Impossible de se connecter");
            lore.add(ChatColor.GRAY + "?? la base de donn??es !");
            meta.setLore(lore);
            itemStack.setItemMeta(meta);
        }

        return itemStack;
    }

    public static ItemStack boss() {
        //create an item stack of 1 potion
        ItemStack itemStack = new ItemStack(Material.TOTEM_OF_UNDYING);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.BOSS.getColor() + "Le r??le de Chef !");
        meta.setCustomModelData(CustomModelData.boss);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " - 2"
                + ChatColor.RED + " C??ur de vie"
                + ChatColor.GRAY + " en plus."
        );
        meta.setLore(lore);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack miner() {
        //create an item stack of 1 iron pickaxe
        ItemStack itemStack = new ItemStack(Material.IRON_PICKAXE);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.MINER.getColor() + "Le r??le de Mineur !");
        meta.setCustomModelData(CustomModelData.miner);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " -"
                + ChatColor.WHITE + " Pioche en fer"
                + ChatColor.GREEN + " incassable"
                + ChatColor.GRAY + " avec"
                + ChatColor.BLUE + " efficacit?? I"
                + ChatColor.GRAY + "."
        );
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack baker() {
        //create an item stack of 1 bread
        ItemStack itemStack = new ItemStack(Material.BREAD);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.BAKER.getColor() + "Le r??le de Boulanger !");
        meta.setCustomModelData(CustomModelData.baker);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " - 64 Pains.");
        meta.setLore(lore);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack butcher() {
        //create an item stack of 1 iron sword
        ItemStack itemStack = new ItemStack(Material.IRON_SWORD);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.BUTCHER.getColor() + "Le r??le de Boucher !");
        meta.setCustomModelData(CustomModelData.butcher);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " -"
                + ChatColor.WHITE + " ??p??e en fer"
                + ChatColor.GREEN + " incassable"
                + ChatColor.GRAY + " avec"
                + ChatColor.BLUE + " butin I"
                + ChatColor.GRAY + "."
        );
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack doctor() {
        //create an item stack of 1 potion
        ItemStack itemStack = new ItemStack(Material.POTION);

        //Modify the item's meta (name, lore, etc.)
        PotionMeta meta = (PotionMeta) itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.DOCTOR.getColor() + "Le r??le de M??decin !");
        meta.setCustomModelData(CustomModelData.doctor);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " - 2"
                + ChatColor.RED + " Potions de soin instantan?? I"
                + ChatColor.GRAY + "."
        );
        meta.setLore(lore);
        meta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack guard() {
        //create an item stack of 1 shield
        ItemStack itemStack = new ItemStack(Material.SHIELD);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.GUARD.getColor() + "Le r??le de Garde !");
        meta.setCustomModelData(CustomModelData.guard);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " - 1"
                + ChatColor.DARK_GRAY + " Bouclier"
                + ChatColor.GREEN + " incassable"
                + ChatColor.GRAY + "."
        );
        lore.add(ChatColor.GRAY + " - 2"
                + ChatColor.DARK_GRAY + " Armure inn??e"
                + ChatColor.GRAY + "."
        );
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack soldier() {
        //create an item stack of 1 shield
        ItemStack itemStack = new ItemStack(Material.IRON_AXE);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.SOLDIER.getColor() + "Le r??le de Soldat !");
        meta.setCustomModelData(CustomModelData.soldier);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " - 1"
                + ChatColor.WHITE + " Hache en fer"
                + ChatColor.GREEN + " incassable"
                + ChatColor.GRAY + "."
        );
        lore.add(ChatColor.GRAY + " - +10%"
                + ChatColor.AQUA + " Vitesse d'attaque inn??e"
                + ChatColor.GRAY + "."
        );
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack archer() {
        //create an item stack of 1 shield
        ItemStack itemStack = new ItemStack(Material.BOW);

        //Modify the item's meta (name, lore, etc.)
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Role.ARCHER.getColor() + "Le r??le d'Archer !");
        meta.setCustomModelData(CustomModelData.archer);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Les Bonus :");
        lore.add(ChatColor.GRAY + " - 1"
                + ChatColor.GOLD + " Arc"
                + ChatColor.GREEN + " incassable"
                + ChatColor.GRAY + "."
        );
        lore.add(ChatColor.GRAY + " - +10%"
                + ChatColor.WHITE + " Vitesse inn??e"
                + ChatColor.GRAY + "."
        );
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        //put the meta on the item stack
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public static ItemStack white() {
        ItemStack itemStack = new ItemStack(Material.WHITE_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.WHITE.getColor() + "L'??quipe Blanche");
        meta.setCustomModelData(CustomModelData.white);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack orange() {
        ItemStack itemStack = new ItemStack(Material.ORANGE_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.ORANGE.getColor() + "L'??quipe Orange");
        meta.setCustomModelData(CustomModelData.orange);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack magenta() {
        ItemStack itemStack = new ItemStack(Material.MAGENTA_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.MAGENTA.getColor() + "L'??quipe Magenta");
        meta.setCustomModelData(CustomModelData.magenta);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack lightBlue() {
        ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.LIGHT_BLUE.getColor() + "L'??quipe Bleu Clair");
        meta.setCustomModelData(CustomModelData.lightBlue);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack yellow() {
        ItemStack itemStack = new ItemStack(Material.YELLOW_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.YELLOW.getColor() + "L'??quipe Jaune");
        meta.setCustomModelData(CustomModelData.yellow);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack lime() {
        ItemStack itemStack = new ItemStack(Material.LIME_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.LIME.getColor() + "L'??quipe Vert Clair");
        meta.setCustomModelData(CustomModelData.lime);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack pink() {
        ItemStack itemStack = new ItemStack(Material.PINK_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.PINK.getColor() + "L'??quipe Rose");
        meta.setCustomModelData(CustomModelData.pink);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack gray() {
        ItemStack itemStack = new ItemStack(Material.GRAY_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.GRAY.getColor() + "L'??quipe Grise");
        meta.setCustomModelData(CustomModelData.gray);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack lightGray() {
        ItemStack itemStack = new ItemStack(Material.LIGHT_GRAY_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.LIGHT_GRAY.getColor() + "L'??quipe Gris Clair");
        meta.setCustomModelData(CustomModelData.lightGray);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack cyan() {
        ItemStack itemStack = new ItemStack(Material.CYAN_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.CYAN.getColor() + "L'??quipe Cyan");
        meta.setCustomModelData(CustomModelData.cyan);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack purple() {
        ItemStack itemStack = new ItemStack(Material.PURPLE_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.PURPLE.getColor() + "L'??quipe Violette");
        meta.setCustomModelData(CustomModelData.purple);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack blue() {
        ItemStack itemStack = new ItemStack(Material.BLUE_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.BLUE.getColor() + "L'??quipe Bleue");
        meta.setCustomModelData(CustomModelData.blue);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack brown() {
        ItemStack itemStack = new ItemStack(Material.BROWN_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.BROWN.getColor() + "L'??quipe Marron");
        meta.setCustomModelData(CustomModelData.brown);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack green() {
        ItemStack itemStack = new ItemStack(Material.GREEN_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.GREEN.getColor() + "L'??quipe Verte");
        meta.setCustomModelData(CustomModelData.green);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack red() {
        ItemStack itemStack = new ItemStack(Material.RED_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.RED.getColor() + "L'??quipe Rouge");
        meta.setCustomModelData(CustomModelData.red);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
    public static ItemStack black() {
        ItemStack itemStack = new ItemStack(Material.BLACK_CONCRETE);

        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(Team.BLACK.getColor() + "L'??quipe Noire");
        meta.setCustomModelData(CustomModelData.black);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
}
