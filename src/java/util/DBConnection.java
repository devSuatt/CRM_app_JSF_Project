package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String url = "jdbc:derby://localhost:1527/CRM_database";
    private final String user ="suat";
    private final String password ="1234";
    
    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(url, user, password);  
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }
}
