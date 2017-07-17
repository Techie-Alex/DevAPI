package me.devanonymous.Server.API;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Collection;

public final class DevText {
    public static class Text {
        public static String centerText(String text, Integer outputWidth) {
            String nt = "";
            for (Integer i = 1; i <= (outputWidth - ChatColor.stripColor(text).length()) / 2; i++) {
                if (i % 2 == 0) {
                    nt = nt + " ";
                }
            }
            return nt + text;
        }
    }


    public static class Que {
        private static ArrayList<Object> a = new ArrayList<>();

        public static void addToTopQue(Object what) {
            a.add(0, what);
        }

        public static void addToQue(Integer where, Object what) {
            a.add(where, what);
        }

        public static void addToQue(Object what) {
            a.add(what);
        }

        public static void addAllToQue(Collection what) {
            a.addAll(what);
        }

        public static Boolean removeFromQue(Object what) {
            if (a.contains(what)) {
                a.remove(what);
                return true;
            }
            return false;
        }

        public static Boolean removeFromQue(Integer what) {
            if (a.contains(what)) {
                a.remove(what);
                return true;
            }
            return false;
        }

        public static Object getTopQue() {
            return a.get(0);
        }

        public static Object getLastQue() {
            return a.get(a.size() - 1);
        }

        public static Object[] getQue() {
            return a.toArray();
        }

    }
}