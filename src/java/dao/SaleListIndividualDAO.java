
package dao;

import entity.SaleListIndividual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class SaleListIndividualDAO {
    
    public List<SaleListIndividual> findAll() { // database den nesneleri liste olarak döndürür
        List<SaleListIndividual> sli_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_INDIVIDUAL");
            while (rs.next()) {
                SaleListIndividual sli = new SaleListIndividual(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                sli_list.add(sli);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sli_list;
    }

    public void insert(SaleListIndividual sli) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "INSERT INTO SALE_LIST_INDIVIDUAL (CUSTOMER_NAME,PRODUCT_NAME,PRICE,PROCESS) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sli.getCustomer_name());
            ps.setString(2, sli.getProduct_name());
            ps.setDouble(3, sli.getPrice());
            ps.setString(4, sli.getProcess());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(SaleListIndividual sli) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "DELETE FROM SALE_LIST_INDIVIDUAL WHERE SLI_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sli.getSli_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(SaleListIndividual sli) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "UPDATE SALE_LIST_INDIVIDUAL SET CUSTOMER_NAME = ?, PRODUCT_NAME = ?, PRICE = ?, PROCESS = ? WHERE SLI_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sli.getCustomer_name());
            ps.setString(2, sli.getProduct_name());
            ps.setDouble(3, sli.getPrice());
            ps.setString(4, sli.getProcess());
            ps.setInt(5, sli.getSli_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<SaleListIndividual> sqlOffer() { // database den nesneleri liste olarak döndürür
        List<SaleListIndividual> sli_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_INDIVIDUAL WHERE PROCESS = 'OFFER'");
            while (rs.next()) {
                SaleListIndividual sli = new SaleListIndividual(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                sli_list.add(sli);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sli_list;
    }
    
    public List<SaleListIndividual> sqlNegotiation() { // database den nesneleri liste olarak döndürür
        List<SaleListIndividual> sli_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_INDIVIDUAL WHERE PROCESS = 'NEGOTIATION'");
            while (rs.next()) {
                SaleListIndividual sli = new SaleListIndividual(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                sli_list.add(sli);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sli_list;
    }
    
    public List<SaleListIndividual> sqlOrder() { // database den nesneleri liste olarak döndürür
        List<SaleListIndividual> sli_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_INDIVIDUAL WHERE PROCESS = 'ORDER'");
            while (rs.next()) {
                SaleListIndividual sli = new SaleListIndividual(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                sli_list.add(sli);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sli_list;
    }
    
    public List<SaleListIndividual> sqlPayment() { // database den nesneleri liste olarak döndürür
        List<SaleListIndividual> sli_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_INDIVIDUAL WHERE PROCESS = 'PAYMENT'");
            while (rs.next()) {
                SaleListIndividual sli = new SaleListIndividual(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                sli_list.add(sli);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sli_list;
    }
}
