package me.devanonymous.Server.API;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.devanonymous.Server.main;
import org.bukkit.entity.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public final class DevBungee {
    public static void sendPlayer(String serverName, Player who) {
        ByteArrayDataOutput o = ByteStreams.newDataOutput();
        o.writeUTF("Connect");
        o.writeUTF(serverName);
        who.sendPluginMessage(main.p, "BungeeCord", o.toByteArray());
    }

    public static String serverMOTD(String serverIP, Integer serverPort) {
        try {
            Socket s = new Socket(serverIP, serverPort);
            new DataOutputStream(s.getOutputStream()).write(0xFE);
            int i;
            StringBuilder str = new StringBuilder();
            while ((i = new DataInputStream(s.getInputStream()).read()) != -1)
                if (i != 0 && i > 16 && i != 255 && i != 23 && i != 24) str.append((char) i);
            return String.valueOf(str.toString().split("§")[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer[] serverCount(String serverIP, Integer serverPort) {
        try {
            Socket s = new Socket(serverIP, serverPort);
            new DataOutputStream(s.getOutputStream()).write(0xFE);
            int i;
            StringBuilder str = new StringBuilder();
            while ((i = new DataInputStream(s.getInputStream()).read()) != -1)
                if (i != 0 && i > 16 && i != 255 && i != 23 && i != 24) str.append((char) i);
            return new Integer[]{Integer.parseInt(str.toString().split("§")[1]), Integer.parseInt(str.toString().split("§")[2])};
        } catch (IOException e) {
            return new Integer[]{null, null};
        }
    }

    public static Boolean serverOnline(String serverIP, Integer serverPort, Integer timeout) {
        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress(serverIP, serverPort), timeout);
            s.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

