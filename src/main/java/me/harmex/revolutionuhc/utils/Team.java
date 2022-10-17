package me.harmex.revolutionuhc.utils;

import org.bukkit.ChatColor;

public enum Team {
    NONE("Aucune", ChatColor.GRAY),
    WHITE("Blanche", ChatColor.WHITE),
    ORANGE("Orange", ChatColor.RED),
    MAGENTA("Magenta", ChatColor.DARK_PURPLE),
    LIGHT_BLUE("Bleu Clair", ChatColor.AQUA),
    YELLOW("Jaune", ChatColor.YELLOW),
    LIME("Vert Clair", ChatColor.GREEN),
    PINK("Rose", ChatColor.LIGHT_PURPLE),
    GRAY("Grise", ChatColor.DARK_GRAY),
    LIGHT_GRAY("Gris Clair", ChatColor.GRAY),
    CYAN("Cyan", ChatColor.BLUE),
    PURPLE("Violette", ChatColor.DARK_PURPLE),
    BLUE("Bleue", ChatColor.DARK_BLUE),
    BROWN("Marron", ChatColor.GOLD),
    GREEN("Verte", ChatColor.DARK_GREEN),
    RED("Rouge", ChatColor.DARK_RED),
    BLACK("Noire", ChatColor.BLACK);

    private final String name;
    private final ChatColor color;

    Team(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }
}
