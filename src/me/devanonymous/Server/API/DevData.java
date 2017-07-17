package me.devanonymous.Server.API;

import me.devanonymous.Server.API_Tools.tData;
import me.devanonymous.Server.main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class DevData {
    public static class Player_Data {
        public static FileConfiguration getData(UUID who) {
            return tData.playerData(who);
        }

        public static Boolean setData(UUID who, String where, Object what) {
            if (Data_Tools.hasPlayer(who)) {
                YamlConfiguration y = tData.playerData(who);
                y.set(where, what);
                return tData.saveData(who, y);
            } return false;
        }

        public static class Data_Tools {
            public static Boolean hasPlayer(UUID who) {
                return new File(tData.dataFolder() + "//playerData//" + who + ".yml").exists();
            }
            public static String[] playerList() {
                return new File(String.valueOf(tData.dataFolder()) + "//playerData//").list();
            }

            public static Integer playerListSize() {
                String[] f = new File(String.valueOf(tData.dataFolder()) + "//playerData//").list();
                assert f != null;
                return f.length;
            }
        }

        public static class Count_Tools {
            public static Boolean plusOne(UUID who, String where) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    y.set(where, y.getInt(where) + 1);
                    return tData.saveData(who, y);
                } return null;
            }

            public static Boolean plusSpecify(UUID who, String where, Integer howMuch) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    y.set(where, y.getInt(where) + howMuch);
                    return tData.saveData(who, y);
                } return null;
            }
        }

        public static class List_Tools {
            public static Integer listSize(UUID who, String where) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    if (y.getList(where) != null) return y.getList(where).size(); else return null;
                } return null;
            }

            public static Boolean addStringToList(UUID who, String where, String what) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    List<String> l = y.getStringList(where);
                    l.add(what);
                    y.set(where, l);
                    return tData.saveData(who, y);
                } return false;
            }

            public static Boolean addIntegerToList(UUID who, String where, Integer what) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    List<Integer> l = y.getIntegerList(where);
                    l.add(what);
                    y.set(where, l);
                    return tData.saveData(who, y);
                } return false;
            }

            public static Boolean addMapToList(UUID who, String where, Map what) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    List<Map<?, ?>> l = y.getMapList(where);
                    l.add(what);
                    y.set(where, l);
                    return tData.saveData(who, y);
                } return false;
            }

            public static Boolean addBooleanToList(UUID who, String where, Boolean what) {
                if (Data_Tools.hasPlayer(who)) {
                    YamlConfiguration y = tData.playerData(who);
                    List<Boolean> l = y.getBooleanList(where);
                    l.add(what);
                    y.set(where, l);
                    return tData.saveData(who, y);
                } return false;
            }
        }
    }

    public static class Config_Data {
        public static FileConfiguration config() {
            return main.p.getConfig();
        }

        public static void saveconfig() {main.p.saveConfig();
        }
    }
}
