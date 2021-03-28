
package dao;

import entity.SaleListCompany;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class SaleListCompanyDAO {
    
    public List<SaleListCompany> findAll() { // database den nesneleri liste olarak döndürür
        List<SaleListCompany> slc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_COMPANY");
            while (rs.next()) {
                SaleListCompany slc = new SaleListCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                slc_list.add(slc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return slc_list;
    }

    public void insert(SaleListCompany slc) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "INSERT INTO SALE_LIST_COMPANY (COMPANY_NAME,PRODUCT_NAME,PRICE,PROCESS) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, slc.getCompany_name());
            ps.setString(2, slc.getProduct_name());
            ps.setDouble(3, slc.getPrice());
            ps.setString(4, slc.getProcess());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(SaleListCompany slc) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "DELETE FROM SALE_LIST_COMPANY WHERE SLC_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, slc.getSlc_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(SaleListCompany slc) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "UPDATE SALE_LIST_COMPANY SET COMPANY_NAME = ?, PRODUCT_NAME = ?, PRICE = ?, PROCESS = ? WHERE SLC_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, slc.getCompany_name());
            ps.setString(2, slc.getProduct_name());
            ps.setDouble(3, slc.getPrice());
            ps.setString(4, slc.getProcess());
            ps.setInt(5, slc.getSlc_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<SaleListCompany> sqlOffer() { // database den nesneleri liste olarak döndürür
        List<SaleListCompany> slc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_COMPANY WHERE PROCESS = 'OFFER'");
            while (rs.next()) {
                SaleListCompany slc = new SaleListCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                slc_list.add(slc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return slc_list;
    }
    
    public List<SaleListCompany> sqlNegotiation() { // database den nesneleri liste olarak döndürür
        List<SaleListCompany> slc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_COMPANY WHERE PROCESS = 'NEGOTIATION'");
            while (rs.next()) {
                SaleListCompany slc = new SaleListCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                slc_list.add(slc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return slc_list;
    }
    
    public List<SaleListCompany> sqlOrder() { // database den nesneleri liste olarak döndürür
        List<SaleListCompany> slc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_COMPANY WHERE PROCESS = 'ORDER'");
            while (rs.next()) {
                SaleListCompany slc = new SaleListCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                slc_list.add(slc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return slc_list;
    }
    
    public List<SaleListCompany> sqlPayment() { // database den nesneleri liste olarak döndürür
        List<SaleListCompany> slc_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALE_LIST_COMPANY WHERE PROCESS = 'PAYMENT'");
            while (rs.next()) {
                SaleListCompany slc = new SaleListCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                slc_list.add(slc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return slc_list;
    }
}
