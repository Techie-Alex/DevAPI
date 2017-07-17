package me.devanonymous.Server.API_Specific.vAesthetics.Messages;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class actionBar_1_8 {
    public static void a(Player player, String message) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(new ChatComponentText(ChatColor.translateAlternateColorCodes('&', message)), (byte) 2));
    }
}
