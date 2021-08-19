package tools;

import config.YamlConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // touch the mysql driver
        } catch (ClassNotFoundException e) {
            System.out.println("[SEVERE] SQL Driver Not Found. Consider death by clams.");
            e.printStackTrace();
            return null;
        }
        try {
            return DriverManager.getConnection(YamlConfig.config.server.DB_URL, YamlConfig.config.server.DB_USER, YamlConfig.config.server.DB_PASS);
        } catch (SQLException e) {
            System.out.println("[SEVERE] Unable to make database connection.");
            e.printStackTrace();
            return null;
        }
    }
    
}
