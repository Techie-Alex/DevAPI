package me.devanonymous.Server.API.Listeners;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DevTimer_Finished extends Event {
    private static final HandlerList h = new HandlerList();
    private String s1;
    private String s2;

    public DevTimer_Finished(String s) {
        s1 = s.split("\\|")[0];
        s2 = s.split("\\|")[1];
    }

    public static HandlerList getHandlerList() {
        return h;
    }

    public HandlerList getHandlers() {
        return h;
    }

    public String getIdentifier() {
        return s1;
    }

    public String getWhat() {
        return s2;
    }
}
