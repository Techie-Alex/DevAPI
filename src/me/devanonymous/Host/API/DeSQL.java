package me.devanonymous.Host.API;


import me.devanonymous.Host.API_Tools.tSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DeSQL {
    private static Connection c;

    public static Boolean sqlCreate(DeAuth deAuth, String dbName, String sql) {
        c = tSQL.connect(deAuth, dbName);
        try {
            if (c == null) return false;
            c.createStatement().executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet sqlGet(DeAuth deAuth, String dbName, String sql) {
        c = tSQL.connect(deAuth, dbName);
        try {
            if (c == null) return null;
            return c.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean sqlClose() {
        try {
            c.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static class DeAuth {
        private String sqlIP;
        private String sqlUsername;
        private String sqlPassword;

        public DeAuth(String sqlIP, String sqlUsername, String sqlPassword) {
            this.sqlIP = sqlIP;
            this.sqlUsername = sqlUsername;
            this.sqlPassword = sqlPassword;
        }

        public String getIP() {
            return this.sqlIP;
        }

        public String getUsername() {
            return this.sqlUsername;
        }

        public String getPassword() {
            return this.sqlPassword;
        }
    }
}
