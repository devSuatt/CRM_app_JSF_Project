
package dao;

import entity.SaleProcess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class SaleProcessDAO {
    
    public List<SaleProcess> findAll() { // database den nesneleri liste olarak döndürür
        List<SaleProcess> sp_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_PROCESS");
            while (rs.next()) {
                SaleProcess sp = new SaleProcess(rs.getString(1));
                sp_list.add(sp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sp_list;
    }
    
    public List<String> findAll2() { // database den nesneleri liste olarak döndürür
        List<String> sp_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_PROCESS");
            while (rs.next()) {
                String sp = rs.getString(1);
                sp_list.add(sp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sp_list;
    }
    
}
