package me.harmex.revolutionuhc.utils;

import org.bukkit.ChatColor;

public enum Role {
    NONE("Aucun", ChatColor.GRAY),
    BOSS("Chef", ChatColor.DARK_GREEN),
    MINER("Mineur", ChatColor.WHITE),
    BAKER("Boulanger", ChatColor.GOLD),
    BUTCHER("Boucher", ChatColor.DARK_RED),
    DOCTOR("Médecin", ChatColor.RED),
    GUARD("Garde", ChatColor.DARK_GRAY),
    SOLDIER("Soldat", ChatColor.GRAY),
    ARCHER("Archer", ChatColor.YELLOW);

    private final String name;
    private final ChatColor color;

    Role(String name, ChatColor color) {
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
