package main.java.com.magdezis.inversiones.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataBaseConection {

    private static Connection conn;

    private DataBaseConection() {
    }

    public static Connection getConnectionDataBase() throws SQLException {
        if (conn == null || conn.isClosed()) {
            DriverManager.getConnection(Credentials.URL_DB, Credentials.USER_DB, Credentials.PASS_DB);
        }
        return conn;
    }
}
