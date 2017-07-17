package me.devanonymous.Server.API;

import me.devanonymous.Server.API_Tools.tTimer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class DevTimer {
    public static void createTimer(String identifier, String what, Integer time) {
        tTimer.data.put(identifier + "|" + what, time);
    }

    public static Boolean deleteTimer(String identifier, String what) {
        if (tTimer.data.containsKey(identifier + "|" + what)) {
            tTimer.data.remove(identifier + "|" + what);
            return true;
        }
        return false;
    }

    public static Boolean addTime(String identifier, String what, Integer amount) {
        if (tTimer.data.containsKey(identifier + "|" + what)) {
            tTimer.data.replace(identifier + "|" + what, tTimer.data.get(identifier + "|" + what) + amount);
            return true;
        }
        return false;
    }

    public static Boolean setTime(String identifier, String what, Integer time) {
        if (tTimer.data.containsKey(identifier + "|" + what)) {
            tTimer.data.replace(identifier + "|" + what, time);
            return true;
        }
        return false;
    }

    public static Boolean hasTime(String identifier, String what) {
        return tTimer.data.containsKey(identifier + "|" + what);
    }

    public static Integer getTime(String identifier, String what) {
        return tTimer.data.getOrDefault(identifier + "|" + what, null);
    }

    public static class Tools {
        public static ArrayList<Map.Entry<String, Integer>> timers() {
            ArrayList<Map.Entry<String, Integer>> al = new ArrayList<>();
            for (Map.Entry<String, Integer> d : tTimer.data.entrySet()) al.add(d);
            return al;
        }

        public static Integer totalTimers() {
            return tTimer.data.size();
        }

        public static void deleteALLTimers() {
            tTimer.data.clear();
        }

        public static void addCustomTimer(String custom, Integer time) {
            tTimer.data.put(custom, time);
        }

        public static Collection<Integer> allTimes() {
            return tTimer.data.values();
        }
    }
}
