package me.harmex.revolutionuhc.models;

import me.harmex.revolutionuhc.utils.Role;
import me.harmex.revolutionuhc.utils.Team;

public class PlayerStats {
    private String uuid;
    private Role role;
    private Team team;

    public PlayerStats(String uuid, Role role, Team team) {
        this.uuid = uuid;
        this.role = role;
        this.team = team;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
