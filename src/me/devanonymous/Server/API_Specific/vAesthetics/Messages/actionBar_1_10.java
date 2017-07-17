package me.devanonymous.Server.API_Specific.vAesthetics.Messages;

import net.minecraft.server.v1_10_R1.ChatComponentText;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class actionBar_1_10 {
    public static void a(Player player, String message) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(new ChatComponentText(ChatColor.translateAlternateColorCodes('&', message)), (byte) 2));
    }
}
