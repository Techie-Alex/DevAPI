package me.devanonymous.Server.Listeners;

import me.devanonymous.Server.API.DevPermissions;
import me.devanonymous.Server.API_Tools.tData;
import me.devanonymous.Server.main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class eventPlayerJoin implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void jE(PlayerJoinEvent e) {
        if (!tData.createPlayerData(e.getPlayer().getUniqueId()))
            Bukkit.broadcastMessage(main.ct + "Failed to create " + main.cp + e.getPlayer().getUniqueId());
        for (String s : DevPermissions.Users.getPermissions(e.getPlayer().getUniqueId()))
            e.getPlayer().addAttachment(main.p).setPermission(s, true);
    }
}
