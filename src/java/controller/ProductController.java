package controller;

import dao.ProductDAO;
import entity.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    private List<Product> product_list;
    private List<Product> product_list2;
    private ProductDAO product_dao;
    private Product product = new Product();
    private Product product2 = new Product();

    public ProductController() {
    }

    public List<Product> getProduct_list() {
        this.product_list = this.getProduct_dao().findAll();
        return product_list;
    }

    public void setProduct_list(List<Product> product_list) {
        this.product_list = product_list;
    }

    public List<Product> getProduct_list2() {
        this.product_list2 = this.getProduct_dao().sql();
        return product_list2;
    }

    public void setProduct_list2(List<Product> product_list2) {
        this.product_list2 = product_list2;
    }
    
    

    public ProductDAO getProduct_dao() {
        if (this.product_dao == null) {
            this.product_dao = new ProductDAO();
        }
        return product_dao;
    }

    public void setProduct_dao(ProductDAO product_dao) {
        this.product_dao = product_dao;
    }

    public Product getProduct() {
        if(this.product==null)
            this.product = new Product(); 
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Product getProduct2() {
        return product2;
    }

    public void setProduct2(Product product2) {
        this.product2 = product2;
    }

    public String add(){
        this.getProduct_dao().insert(this.product);
        this.product = null; // formları sıfırlamak için
        return "product";
    }
    
    public String delete(Product product){
        this.getProduct_dao().delete(product);
        return "product";
    }
    
    public String send_update(Product p){
        this.product2 = p;
        return "product_update";
    }
    
    public String update(){
        this.getProduct_dao().update(this.product2);
        return "product";
    }
    
}