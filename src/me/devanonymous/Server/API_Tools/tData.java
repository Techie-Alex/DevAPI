package me.devanonymous.Server.API_Tools;

import me.devanonymous.Server.main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class tData {
    public static File dataFolder() {
        return main.p.getDataFolder();
    }

    public static Boolean playerFolder() {
        File playerFolder = new File(dataFolder() + "//playerData//");
        return playerFolder.exists() || playerFolder.mkdir();
    }

    private static File playerFile(UUID who) {
        File f = new File(dataFolder() + "//playerData//" + who + ".yml");
        if (f.exists()) return f;
        try {
            if (f.createNewFile()) return f;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static YamlConfiguration playerData(UUID who) {
        return YamlConfiguration.loadConfiguration(playerFile(who));
    }

    public static Boolean saveData(UUID who, YamlConfiguration what) {
        try {
            what.save(playerFile(who));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean createPlayerData(UUID who) {
        YamlConfiguration y = playerData(who);
        y.set("DevAPI", "by DevAnonymous");
        saveData(who, y);
        return true;
    }
}
