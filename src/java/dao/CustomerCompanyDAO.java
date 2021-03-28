package dao;

import entity.CustomerCompany;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CustomerCompanyDAO {
    
    public List<CustomerCompany> findAll() { 
        List<CustomerCompany> cc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER_COMPANY");
            while (rs.next()) {
                CustomerCompany cc = new CustomerCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                cc_list.add(cc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cc_list;
    }
    
    public List<String> findAll2() { 
        List<String> cc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COMPANY_NAME FROM CUSTOMER_COMPANY");
            while (rs.next()) {
                String cc = rs.getString(1);
                cc_list.add(cc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cc_list;
    }
    
    public void insert(CustomerCompany cc) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "INSERT INTO CUSTOMER_COMPANY (COMPANY_NAME,REPRESENTER,ADDRESS,PHONE_NUMBER,E_MAIL) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cc.getCompany_name());
            ps.setString(2, cc.getRepresenter());
            ps.setString(3, cc.getAddress());
            ps.setString(4, cc.getPhone_number());
            ps.setString(5, cc.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(CustomerCompany cc) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "DELETE FROM CUSTOMER_COMPANY WHERE COMPANY_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cc.getCompany_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(CustomerCompany cc) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "UPDATE CUSTOMER_COMPANY SET COMPANY_NAME = ?, REPRESENTER = ?, ADDRESS = ?, PHONE_NUMBER = ?, E_MAIL = ? WHERE COMPANY_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cc.getCompany_name());
            ps.setString(2, cc.getRepresenter());
            ps.setString(3, cc.getAddress());
            ps.setString(4, cc.getPhone_number());
            ps.setString(5, cc.getEmail());
            ps.setInt(6, cc.getCompany_id());      
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public List<CustomerCompany> sql() { 
        List<CustomerCompany> cc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER_COMPANY WHERE ADDRESS IN ('TURKEY')");
            while (rs.next()) {
                CustomerCompany cc = new CustomerCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                cc_list.add(cc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cc_list;
    }
    
}
