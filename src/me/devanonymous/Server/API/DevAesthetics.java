package me.devanonymous.Server.API;

import com.google.common.collect.Lists;
import me.devanonymous.Server.API_Specific.vAesthetics.Messages.*;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public final class DevAesthetics {
    public static class Animation {
        public static class newType {
            private static HashMap<String, Integer> h = new HashMap<>();
            public static String a(String name, ArrayList<String> animations) {
                h.put(name, h.getOrDefault(name, 0) + 1);
                if (h.get(name) >= animations.size())
                    h.put(name, 0);
                return animations.get(h.get(name));
            }
        }
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
        public static void setSideBar(Player player, String header, List<String> content) {
            org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective(player.getName(), "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', header));
            Integer i = 0;
            for (String st : Lists.reverse(content)) {
                i++;
                objective.getScore(ChatColor.translateAlternateColorCodes('&', st)).setScore(i);
            }
            player.setScoreboard(scoreboard);
        }
        public static void setSideBarPacket(Player player, String header, List<String> content) {

        }

        public static class Teams {
            public static void addTeams(org.bukkit.scoreboard.Scoreboard scoreboard, List<String> teams) {
                for (String t : teams) scoreboard.registerNewTeam(t);
            }

            public static void addPlayer(org.bukkit.scoreboard.Scoreboard scoreboard, String teamName, Player player) { // Not 1.7.10
                scoreboard.getTeam(teamName).addEntry(player.getName());
            }

            @Deprecated
            public static void addPlayer(org.bukkit.scoreboard.Scoreboard scoreboard, String teamName, OfflinePlayer player) {
                scoreboard.getTeam(teamName).addPlayer(player);
            }

            public static void setPrefix(org.bukkit.scoreboard.Scoreboard scoreboard, String teamName, String prefix) {
                scoreboard.getTeam(teamName).setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
            }

            public static void setSuffix(org.bukkit.scoreboard.Scoreboard scoreboard, String teamName, String suffix) {
                scoreboard.getTeam(teamName).setSuffix(ChatColor.translateAlternateColorCodes('&', suffix));
            }
        }
    }

    public static class Messages {
        public static void actionBar(Player player, String message) { // Not 1.7.10
            if (Bukkit.getVersion().contains("1.8")) actionBar_1_8.a(player, message);
            else if (Bukkit.getVersion().contains("1.9")) actionBar_1_9.a(player, message);
            else if (Bukkit.getVersion().contains("1.10")) actionBar_1_10.a(player, message);
            else if (Bukkit.getVersion().contains("1.11")) actionBar_1_11.a(player, message);
            else if (Bukkit.getVersion().contains("1.12")) actionBar_1_12.a(player, message);
            else Bukkit.getLogger().log(Level.WARNING, "Server version not found for 'DevAesthetics -> Messages -> actionBar'! Please use 1.8 - 1.12 (!) 1.12 is beta");
        }
        public static void listTab(Player player, String header, String footer) { // Not 1.7.10
            if (Bukkit.getVersion().contains("1.8")) listTab_1_8.a(player, header, footer);
            else if (Bukkit.getVersion().contains("1.9")) listTab_1_9.a(player, header, footer);
            else if (Bukkit.getVersion().contains("1.10")) listTab_1_10.a(player, header, footer);
            else if (Bukkit.getVersion().contains("1.11")) listTab_1_11.a(player, header, footer);
            else if (Bukkit.getVersion().contains("1.12")) listTab_1_12.a(player, header, footer);
            else Bukkit.getLogger().log(Level.WARNING, "Server version not found for 'DevAesthetics -> Messages -> listTab'! Please use 1.8 - 1.12");
        }
        public static void setMOTD(ServerListPingEvent event, Integer maxPlayers, String line_1, String line_2) {
            event.setMaxPlayers(maxPlayers);
            event.setMotd(ChatColor.translateAlternateColorCodes('&', line_1 + "\n" + line_2));
        }
        public static void setMOTD(ServerListPingEvent event, String line_1, String line_2) {
            event.setMotd(ChatColor.translateAlternateColorCodes('&', line_1 + "\n" + line_2));
        }
    }

    public static class Blocks {
        public static class ArmorStands { // Not 1.7.10
            public static ArrayList<UUID> spawnHolo(Location location, List<String> content) {
                Integer l = 0;
                ArrayList<java.util.UUID> al = new ArrayList<>();
                for (String s : content) {
                    Double y = l * 0.22;
                    ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location.subtract(0, y, 0), EntityType.ARMOR_STAND);
                    as.setGravity(false);
                    as.setVisible(false);
                    as.setSmall(true);
                    as.setCustomNameVisible(true);
                    as.setCustomName(ChatColor.translateAlternateColorCodes('&', s));
                    al.add(as.getUniqueId());
                    l++;
                }
                return al;
            }
        }

        public static class Characters {
            public static boolean charMakerPositiveZ(Location location, Long number, Material material) {
                String nc = String.valueOf(number);
                if (nc.startsWith("4") && nc.length() == 16) nc = nc.replaceFirst("4", "");
                else return false;
                Location[] ls = new Location[]{new Location(location.getWorld(), location.getX() - 1, location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 5, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 5, location.getZ())};
                String[] ss = nc.split("");
                for (Integer i = 0; i < 15; i++)
                    if (ss[i].equals(String.valueOf(1))) ls[i].getBlock().setType(material);
                    else ls[i].getBlock().setType(Material.AIR);
                return true;
            }

            public static boolean charMakerNegativeX(Location location, Long number, Material material) {
                String nc = String.valueOf(number);
                if (nc.startsWith("4") && nc.length() == 16) nc = nc.replaceFirst("4", "");
                else return false;
                Location[] ls = new Location[]{new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ() + 1)};
                String[] ss = nc.split("");
                for (Integer i = 0; i < 15; i++)
                    if (ss[i].equals(String.valueOf(1))) ls[i].getBlock().setType(material);
                    else ls[i].getBlock().setType(Material.AIR);
                return true;
            }

            public static boolean charMakerNegativeZ(Location location, Long number, Material material) {
                String nc = String.valueOf(number);
                if (nc.startsWith("4") && nc.length() == 16) nc = nc.replaceFirst("4", "");
                else return false;
                String[] temp = nc.split("(?<=\\G...)");
                for (Integer i = 0; i < 5; i++) temp[i] = new StringBuilder(temp[i]).reverse().toString();
                nc = String.join("", temp);
                Location[] ls = new Location[]{new Location(location.getWorld(), location.getX() - 1, location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX() - 1, location.getY() - 5, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ()), new Location(location.getWorld(), location.getX() + 1, location.getY() - 5, location.getZ())};
                String[] ss = nc.split("");
                for (Integer i = 0; i < 15; i++)
                    if (ss[i].equals(String.valueOf(1))) ls[i].getBlock().setType(material);
                    else ls[i].getBlock().setType(Material.AIR);
                return true;
            }

            public static boolean charMakerPositiveX(Location location, Long number, Material material) {
                String nc = String.valueOf(number);
                if (nc.startsWith("4") && nc.length() == 16) nc = nc.replaceFirst("4", "");
                else return false;
                String[] temp = nc.split("(?<=\\G...)");
                for (Integer i = 0; i < 5; i++) temp[i] = new StringBuilder(temp[i]).reverse().toString();
                nc = String.join("", temp);
                Location[] ls = new Location[]{new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 2, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 3, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 4, location.getZ() + 1), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ() - 1), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ()), new Location(location.getWorld(), location.getX(), location.getY() - 5, location.getZ() + 1)};
                String[] ss = nc.split("");
                for (Integer i = 0; i < 15; i++)
                    if (ss[i].equals(String.valueOf(1))) ls[i].getBlock().setType(material);
                    else ls[i].getBlock().setType(Material.AIR);
                return true;
            }
        }
    }
}
