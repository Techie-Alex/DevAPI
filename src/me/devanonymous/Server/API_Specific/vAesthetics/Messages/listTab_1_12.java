package me.devanonymous.Server.API_Specific.vAesthetics.Messages;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class listTab_1_12 {
    public static void a(Player player, String header, String footer) {
        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
        try {
            Field a = packet.getClass().getDeclaredField("a");
            a.setAccessible(true);
            a.set(packet, IChatBaseComponent.ChatSerializer.a("{text:\"" + ChatColor.translateAlternateColorCodes('&', header) + "\"}"));
            Field b = packet.getClass().getDeclaredField("b");
            b.setAccessible(true);
            b.set(packet, IChatBaseComponent.ChatSerializer.a("{text:\"" + ChatColor.translateAlternateColorCodes('&', footer) + "\"}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
