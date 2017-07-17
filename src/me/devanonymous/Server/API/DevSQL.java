package me.devanonymous.Server.API;

import me.devanonymous.Server.main;
import org.bukkit.Bukkit;

import java.sql.*;

public final class DevSQL {
    public static Boolean sqlPost(DevAuth devAuth, String sql) {
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = devAuth.getConnection();
            c.setAutoCommit(false);
            p = c.prepareStatement(sql);
            p.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(main.prefix + "\u00a7c" + e.getMessage());
            return false;
        } finally {
            try {
                if (p != null) p.close();
                if (c != null) {
                    c.setAutoCommit(true);
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet sqlGet(DevAuth devAuth, String sql) {
        try {
            return devAuth.getConnection().createStatement().executeQuery(sql);
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(main.prefix + "\u00a7c" + e.getMessage());
            return null;
        }
    }

    public static class DevAuth {
        private String sqlIP;
        private Integer sqlPort;
        private String sqlDatabase;
        private String sqlUsername;
        private String sqlPassword;


        public DevAuth(String sqlIP, Integer sqlPort, String sqlDatabase, String sqlUsername, String sqlPassword) {
            this.sqlIP = sqlIP;
            this.sqlPort = sqlPort;
            this.sqlDatabase = sqlDatabase;
            this.sqlUsername = sqlUsername;
            this.sqlPassword = sqlPassword;

        }

        public String getIP() {
            return this.sqlIP;
        }

        public Integer getPort() {
            return this.sqlPort;
        }

        public String getDatabase() {
            return this.sqlDatabase;
        }

        public String getUsername() {
            return this.sqlUsername;
        }

        public Connection getConnection() {
            try {
                return DriverManager.getConnection("jdbc:mysql://" + sqlIP + ":" + sqlPort + "/" + sqlDatabase, sqlUsername, sqlPassword);
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage(main.prefix + "\u00a7c" + e.getMessage());
                return null;
            }
        }
    }
}
