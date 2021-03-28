
package dao;

import entity.UserList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class UserListDAO {
    
    public UserList findAll() { // database den nesneleri liste olarak döndürür
        UserList ul = new UserList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USER_LIST");
            while (rs.next()) {
                UserList ul2 = new UserList(rs.getString(1),rs.getString(2)); 
                ul = ul2;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ul;
    }
}
