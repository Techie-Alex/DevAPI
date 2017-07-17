package me.devanonymous.Server.API;

import me.devanonymous.Server.main;
import org.bukkit.Bukkit;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class DevPermissions {
    public static class Users {
        public static Boolean inGroup(UUID player, String group) {
            return DevData.Player_Data.getData(player).isSet("DevPermissions.group") && DevData.Player_Data.getData(player).getString("DevPermissions.group").equals(group);
        }

        public static Boolean setGroup(UUID player, String group) {
            if (DevPermissions.Groups.allGroups().contains(group)) {
                DevData.Player_Data.setData(player, "DevPermissions.group", group);
                return true;
            }
            return false;
        }

        public static String getGroup(UUID player) {
            if (DevData.Player_Data.getData(player).isSet("DevPermissions.group"))
                return DevData.Player_Data.getData(player).getString("DevPermissions.group");
            return "";
        }

        public static Boolean setPrefix(UUID player, String prefix) {
            return DevData.Player_Data.setData(player, "DevPermissions.prefix", prefix);
        }

        public static Boolean setSuffix(UUID player, String suffix) {
            return DevData.Player_Data.setData(player, "DevPermissions.suffix", suffix);
        }

        public static String getPrefix(UUID player) {
            if (DevData.Player_Data.getData(player).getString("DevPermissions.prefix") != null) return DevData.Player_Data.getData(player).getString("DevPermissions.prefix");
            if (getGroup(player) != null) return Groups.getGroupPrefix(getGroup(player));
            return Groups.getGroupPrefix("default");
        }

        public static String getSuffix(UUID player) {
            if (DevData.Player_Data.getData(player).getString("DevPermissions.suffix") != null) return DevData.Player_Data.getData(player).getString("DevPermissions.suffix");
            if (getGroup(player) != null) return Groups.getGroupSuffix(getGroup(player));
            return Groups.getGroupSuffix("default");
        }

        public static Boolean hasPermission(UUID player, String permission) {
            return DevData.Player_Data.getData(player).getStringList("DevPermissions.permissions").contains(permission.toLowerCase());
        }

        public static Boolean addPermission(UUID player, String permission) {
            List<String> a = DevData.Player_Data.getData(player).getStringList("DevPermissions.permissions");
            if (!a.contains(permission.toLowerCase())) {
                Bukkit.getPlayer(player).addAttachment(main.p).setPermission(permission, true);
                DevData.Player_Data.List_Tools.addStringToList(player, "DevPermissions.permissions", permission.toLowerCase());
                return true;
            }
            return false;
        }

        public static Boolean removePermission(UUID player, String permission) {
            List<String> a = DevData.Player_Data.getData(player).getStringList("DevPermissions.permissions");
            if (a.contains(permission.toLowerCase())) {
                a.remove(permission.toLowerCase());
                Bukkit.getPlayer(player).addAttachment(main.p).unsetPermission(permission);
                DevData.Player_Data.setData(player, "DevPermissions.permissions", a);
                return true;
            }
            return false;
        }

        public static List<String> getPermissions(UUID player) {
            List<String> permissions = new ArrayList<>();
            if (!getGroup(player).equals("") && Groups.getGroupPermissions(getGroup(player)) != null)
                permissions.addAll(Groups.getGroupPermissions(getGroup(player)));
            permissions.addAll(Groups.getGroupPermissions("default"));
            for (String uPerm : DevData.Player_Data.getData(player).getStringList("DevPermissions.permissions")) permissions.add(uPerm);
            return permissions;
        }
        public static List<String> getRegisteredPermissions(UUID player) {
            List<String> a = new ArrayList<>();
            for (PermissionAttachmentInfo s : Bukkit.getPlayer(player).getEffectivePermissions()) a.add(s.getPermission());
            return a;
        }
    }

    public static class Groups {
        public static Boolean addGroup(String group) {
            if (!DevData.Config_Data.config().isSet("DevPermissions." + group)) {
                DevData.Config_Data.config().createSection("DevPermissions." + group);
                DevData.Config_Data.saveconfig();
                return true;
            }
            return false;
        }

        public static Boolean removeGroup(String group) {
            if (DevData.Config_Data.config().isSet("DevPermissions." + group)) {
                DevData.Config_Data.config().set("DevPermissions." + group, null);
                DevData.Config_Data.saveconfig();
                return true;
            }
            return false;
        }
        public static Boolean groupValid(String group) {
            return DevData.Config_Data.config().isSet("DevPermissions." + group);
        }
        public static String getGroupPrefix(String group) {
            if (DevData.Config_Data.config().getString("DevPermissions." + group + ".prefix") != null) return DevData.Config_Data.config().getString("DevPermissions." + group + ".prefix");
            return "";
        }

        public static String getGroupSuffix(String group) {
            if (DevData.Config_Data.config().getString("DevPermissions." + group + ".suffix") != null) return DevData.Config_Data.config().getString("DevPermissions." + group + ".suffix");
            return "";
        }

        public static Boolean setGroupPrefix(String group, String prefix) {
            if (DevData.Config_Data.config().isSet("DevPermissions." + group)) {
                DevData.Config_Data.config().set("DevPermissions." + group + ".prefix", prefix);
                DevData.Config_Data.saveconfig();
                return true;
            }
            return false;
        }

        public static Boolean setGroupSuffix(String group, String suffix) {
            if (DevData.Config_Data.config().isSet("DevPermissions." + group)) {
                DevData.Config_Data.config().set("DevPermissions." + group + ".suffix", suffix);
                DevData.Config_Data.saveconfig();
                return true;
            }
            return false;
        }

        public static Boolean addGroupPermission(String group, String permission) {
            if (DevData.Config_Data.config().isSet("DevPermissions." + group)) {
                List<String> a = DevData.Config_Data.config().getStringList("DevPermissions." + group + ".permissions");
                if (!a.contains(permission.toLowerCase())) {
                    a.add(permission.toLowerCase());
                    DevData.Config_Data.config().set("DevPermissions." + group + ".permissions", a);
                    DevData.Config_Data.saveconfig();
                    return true;
                }
            }
            return false;
        }

        public static Boolean removeGroupPermission(String group, String permission) {
            if (DevData.Config_Data.config().isSet("DevPermissions." + group)) {
                List<String> a = DevData.Config_Data.config().getStringList("DevPermissions." + group + ".permissions");
                if (a.contains(permission.toLowerCase())) {
                    a.remove(permission.toLowerCase());
                    DevData.Config_Data.config().set("DevPermissions." + group + ".permissions", a);
                    DevData.Config_Data.saveconfig();
                    return true;
                }
            }
            return false;
        }

        public static List<String> getGroupPermissions(String group) {
            if (DevData.Config_Data.config().isSet("DevPermissions." + group))
                return DevData.Config_Data.config().getStringList("DevPermissions." + group + ".permissions");
            return Collections.emptyList();
        }
        public static List<String> allGroups() {
            List<String> a = new ArrayList<>();
            for(String group : DevData.Config_Data.config().getConfigurationSection("DevPermissions").getKeys(false))
                a.add(group);
            return a;
        }
    }
}
