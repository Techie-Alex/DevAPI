package me.devanonymous.Server.API_Tools;

import me.devanonymous.Server.API.Listeners.DevTimer_Counting;
import me.devanonymous.Server.API.Listeners.DevTimer_Finished;
import me.devanonymous.Server.main;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

public class tTimer {
    public static HashMap<String, Integer> data = new HashMap<>();

    private static void sFinish(Map.Entry<String, Integer> d) {
        Bukkit.getPluginManager().callEvent(new DevTimer_Finished(d.getKey()));
    }

    private static void sCountdown(Map.Entry<String, Integer> d) {
        Bukkit.getPluginManager().callEvent(new DevTimer_Counting(d.getKey(), d.getValue()));
    }

    public static void r1s() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(main.p, () -> {
            if (!data.isEmpty())
                for (Map.Entry<String, Integer> d : data.entrySet()) {
                    sCountdown(d);
                    if (d.getValue() <= 0) {
                        sFinish(d);
                        data.remove(d.getKey());
                        break;
                    }
                    d.setValue(d.getValue() - 1);
                }
        }, 0L, 20L);
    }
}
