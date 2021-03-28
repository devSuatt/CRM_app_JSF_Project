package dao;

import entity.CustomerIndividual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CustomerIndividualDAO {
    
    public List<CustomerIndividual> findAll() { 
        List<CustomerIndividual> ci_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER_INDIVIDUAL");
            while (rs.next()) {
                CustomerIndividual ci = new CustomerIndividual(rs.getInt(1),  rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                ci_list.add(ci);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ci_list;
    }
    
    public List<String> findAll2() { 
        List<String> ci_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT CUSTOMER_NAME FROM CUSTOMER_INDIVIDUAL");
            while (rs.next()) {
                String ci = rs.getString(1);
                ci_list.add(ci);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ci_list;
    }
    
    public void insert(CustomerIndividual ci) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "INSERT INTO CUSTOMER_INDIVIDUAL (CUSTOMER_NAME,ADDRESS,PHONE_NUMBER,E_MAIL) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ci.getCustomer_name());
            ps.setString(2, ci.getAddress());
            ps.setString(3, ci.getPhone_number());
            ps.setString(4, ci.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(CustomerIndividual ci) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "DELETE FROM CUSTOMER_INDIVIDUAL WHERE CUSTOMER_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ci.getCustomer_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(CustomerIndividual ci) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "UPDATE CUSTOMER_INDIVIDUAL SET CUSTOMER_NAME = ?, ADDRESS = ?, PHONE_NUMBER = ?, E_MAIL = ? WHERE CUSTOMER_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ci.getCustomer_name());
            ps.setString(2, ci.getAddress());
            ps.setString(3, ci.getPhone_number());
            ps.setString(4, ci.getEmail());
            ps.setInt(5, ci.getCustomer_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<CustomerIndividual> sql() { 
        List<CustomerIndividual> ci_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER_INDIVIDUAL WHERE ADDRESS IN ('USA')");
            while (rs.next()) {
                CustomerIndividual ci = new CustomerIndividual(rs.getInt(1),  rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                ci_list.add(ci);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ci_list;
    }
    
    
    
    
    
}
