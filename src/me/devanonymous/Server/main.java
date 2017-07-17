package me.devanonymous.Server;

import me.devanonymous.Server.API_Tools.tData;
import me.devanonymous.Server.API_Tools.tTimer;
import me.devanonymous.Server.Listeners.eventPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    public static String cp = "\u00a79";
    public static String cs = "\u00a7b";
    public static String ct = "\u00a77";
    public static String prefix = cp + "\u00a7lDevAPI \u00a7r" + ct;
    public static Plugin p;

    @Override
    public void onEnable() {
        p = this;
        getConfig().addDefault("DevAPI", "by DevAnonymous");
        getConfig().options().copyDefaults(true);
        getConfig().createSection("DevPermissions.default");
        saveConfig();
        if (!tData.playerFolder()) Bukkit.broadcastMessage(ct + "Failed to create " + cp + "playerFolder");
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getPluginManager().registerEvents(new eventPlayerJoin(), this);
        tTimer.r1s();
        Bukkit.getConsoleSender().sendMessage("\u00a78###########################################################");
        Bukkit.getConsoleSender().sendMessage("\u00a78#                                                         \u00a78#");
        Bukkit.getConsoleSender().sendMessage("\u00a78#             " + ct + "\u00a7lDevAPIServer Loaded! Version " + cs + "\u00a7l" + getDescription().getVersion() + "            \u00a78#");
        Bukkit.getConsoleSender().sendMessage("\u00a78#                                                         \u00a78#");
        Bukkit.getConsoleSender().sendMessage("\u00a78###########################################################");
    }


}
