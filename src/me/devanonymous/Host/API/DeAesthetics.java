package me.devanonymous.Host.API;

import com.google.common.collect.Lists;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.protocol.packet.ScoreboardDisplay;
import net.md_5.bungee.protocol.packet.ScoreboardObjective;
import net.md_5.bungee.protocol.packet.ScoreboardScore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class DeAesthetics {
    public static class Animation {
        private static HashMap<String, Integer> h = new HashMap<>();

        public static class s {
            public static String a(String animationIdentifier, ArrayList<String> animationList) {
                h.put(animationIdentifier, h.getOrDefault(animationIdentifier, 0) + 1);
                if (h.get(animationIdentifier) >= animationList.size())
                    h.put(animationIdentifier, 0);
                return animationList.get(h.get(animationIdentifier));
            }

            public static Integer acounter(String animationIdentifier, ArrayList<String> animationList) {
                h.put(animationIdentifier, h.getOrDefault(animationIdentifier, 0) + 1);
                if (h.get(animationIdentifier) >= animationList.size())
                    h.put(animationIdentifier, 0);
                return h.get(animationIdentifier);
            }

            public static String astring(String animationIdentifier, ArrayList<String> animationList) {
                return animationList.get(h.get(animationIdentifier));
            }
        }

        public static class o {
            public static Object a(String animationIdentifier, ArrayList<Object> animationList) {
                h.put(animationIdentifier, h.getOrDefault(animationIdentifier, 0) + 1);
                if (h.get(animationIdentifier) >= animationList.size())
                    h.put(animationIdentifier, 0);
                return animationList.get(h.get(animationIdentifier));
            }

            public static Integer acounter(String animationIdentifier, ArrayList<Object> animationList) {
                h.put(animationIdentifier, h.getOrDefault(animationIdentifier, 0) + 1);
                if (h.get(animationIdentifier) >= animationList.size())
                    h.put(animationIdentifier, 0);
                return h.get(animationIdentifier);
            }

            public static Object aobject(String animationIdentifier, ArrayList<Object> animationList) {
                return animationList.get(h.get(animationIdentifier));
            }
        }

    }

    public static class Scoreboard {
        public static void packetScoreboard(ProxiedPlayer proxiedPlayer, String header, List<String> content) {
            String hHeader;
            if (header.length() > 32) hHeader = header.substring(0, 32);
            else hHeader = header;
            ScoreboardObjective objective = new ScoreboardObjective("dev", ChatColor.translateAlternateColorCodes('&', hHeader), "integer", (byte) 0);
            ScoreboardDisplay display = new ScoreboardDisplay((byte) 1, "dev");
            proxiedPlayer.unsafe().sendPacket(objective);
            proxiedPlayer.unsafe().sendPacket(display);
            Integer i = 1;
            for (String string : Lists.reverse(content)) {
                ScoreboardScore score = new ScoreboardScore(ChatColor.translateAlternateColorCodes('&', string), (byte) 0, "dev", i);
                proxiedPlayer.unsafe().sendPacket(score);
                i++;
            }
        }
    }

    public static class Messages {
        public static void serverMOTD(ProxyPingEvent event, Integer players, Integer maxPlayers, String line_1, String line_2, ArrayList<String> playerList) {
            ServerPing sp = event.getResponse();
            ArrayList<ServerPing.PlayerInfo> l = new ArrayList<>();
            Integer i = 1;
            for (String s : playerList) {
                l.add(new ServerPing.PlayerInfo(ChatColor.translateAlternateColorCodes('&', s), String.valueOf(i)));
                i++;
            }
            ServerPing.PlayerInfo[] f = new ServerPing.PlayerInfo[l.size()];
            sp.setPlayers(new ServerPing.Players(maxPlayers, players, l.toArray(f)));
            sp.setDescriptionComponent(new TextComponent(ChatColor.translateAlternateColorCodes('&', line_1 + "\n" + line_2)));
            event.setResponse(sp);
        }

        public static void serverMOTD(ProxyPingEvent event, Integer players, Integer maxPlayers, String line_1, String line_2) {
            ServerPing sp = event.getResponse();
            ArrayList<ServerPing.PlayerInfo> l = new ArrayList<>();
            sp.setPlayers(new ServerPing.Players(maxPlayers, players, null));
            sp.setDescriptionComponent(new TextComponent(ChatColor.translateAlternateColorCodes('&', line_1 + "\n" + line_2)));
            event.setResponse(sp);
        }
    }
}
