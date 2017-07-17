package me.devanonymous.Host.API_Tools;

import me.devanonymous.Host.API.DeSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class tSQL {
    public static Connection connect(DeSQL.DeAuth devAuth, String databaseName) {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + devAuth.getIP() + ":3306/" + databaseName, devAuth.getUsername(), devAuth.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
