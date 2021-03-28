package dao;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class ProductDAO {

    public List<Product> findAll() { // database den nesneleri liste olarak döndürür
        List<Product> product_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                product_list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product_list;
    }
    
    public List<String> findAll2() { // database den nesneleri liste olarak döndürür
        List<String> product_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT PRODUCT_NAME FROM PRODUCT");
            while (rs.next()) {
                String product = rs.getString(1);
                product_list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product_list;
    }

    public void insert(Product product) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "INSERT INTO PRODUCT (PRODUCT_NAME,LIST_PRICE,QUANTITY_ON_HAND,DESCRIPTION) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProduct_name());
            ps.setDouble(2, product.getList_price());
            ps.setInt(3, product.getQuantity_on_hand());
            ps.setString(4, product.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Product product) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product.getProduct_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Product product) {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        String sql = "UPDATE PRODUCT SET PRODUCT_NAME = ?, LIST_PRICE = ?, QUANTITY_ON_HAND = ?, DESCRIPTION = ? WHERE PRODUCT_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProduct_name());
            ps.setDouble(2, product.getList_price());
            ps.setInt(3, product.getQuantity_on_hand());
            ps.setString(4, product.getDescription());
            ps.setInt(5, product.getProduct_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Product findPrice(String s) {
        Product p = new Product();
        
        List<Product> product_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                product_list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        for(Product i: product_list){
            if(i.getProduct_name().equals(s)){
                p=i;
            }
        }
       
        return p;
    }
    
    
    
    public List<Product> sql() { // database den nesneleri liste olarak döndürür
        List<Product> product_list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT ORDER BY QUANTITY_ON_HAND DESC");
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                product_list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product_list;
    }
}
