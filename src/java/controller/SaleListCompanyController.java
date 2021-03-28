package controller;

import dao.CustomerCompanyDAO;
import dao.ProductDAO;
import dao.SaleListCompanyDAO;
import dao.SaleProcessDAO;
import entity.Product;
import entity.SaleListCompany;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "saleListCompanyController")
@SessionScoped
public class SaleListCompanyController implements Serializable {

    private List<SaleListCompany> slc_list;
    private List<SaleListCompany> slc_list2;
    private List<SaleListCompany> slc_list3;
    private List<SaleListCompany> slc_list4;
    private List<SaleListCompany> slc_list5;
    private SaleListCompanyDAO slc_dao;
    private SaleListCompany slc;
    private SaleListCompany slc2;
    private SaleProcessDAO sp_dao = new SaleProcessDAO();
    private CustomerCompanyDAO cc_dao = new CustomerCompanyDAO();
    private ProductDAO p_dao = new ProductDAO();
    private Product p = new Product();

    public SaleListCompanyController() {
    }

    public List<SaleListCompany> getSlc_list() {
        this.slc_list = this.getSlc_dao().findAll();
        return slc_list;
    }

    public void setSlc_list(List<SaleListCompany> slc_list) {
        this.slc_list = slc_list;
    }

    public List<SaleListCompany> getSlc_list2() {
        this.slc_list2 = this.getSlc_dao().sqlOffer();
        return slc_list2;
    }

    public void setSlc_list2(List<SaleListCompany> slc_list2) {
        this.slc_list2 = slc_list2;
    }

    public List<SaleListCompany> getSlc_list3() {
        this.slc_list3 = this.getSlc_dao().sqlNegotiation();
        return slc_list3;
    }

    public void setSlc_list3(List<SaleListCompany> slc_list3) {
        this.slc_list3 = slc_list3;
    }

    public List<SaleListCompany> getSlc_list4() {
        this.slc_list4 = this.getSlc_dao().sqlOrder();
        return slc_list4;
    }

    public void setSlc_list4(List<SaleListCompany> slc_list4) {
        this.slc_list4 = slc_list4;
    }

    public List<SaleListCompany> getSlc_list5() {
        this.slc_list5 = this.getSlc_dao().sqlPayment();
        return slc_list5;
    }

    public void setSlc_list5(List<SaleListCompany> slc_list5) {
        this.slc_list5 = slc_list5;
    }
    
    

    public SaleListCompanyDAO getSlc_dao() {
        if (this.slc_dao == null) {
            this.slc_dao = new SaleListCompanyDAO();
        }
        return slc_dao;
    }

    public void setSlc_dao(SaleListCompanyDAO slc_dao) {
        this.slc_dao = slc_dao;
    }

    public SaleListCompany getSlc() {
        if (this.slc == null) {
            this.slc = new SaleListCompany();
        }
        return slc;
    }

    public void setSlc(SaleListCompany slc) {
        this.slc = slc;
    }

    public SaleListCompany getSlc2() {
        return slc2;
    }

    public void setSlc2(SaleListCompany slc2) {
        this.slc2 = slc2;
    }

    public String add() {
        this.getSlc_dao().insert(this.slc);
        this.slc = null; // formları sıfırlamak için
        return "sale_list_company";
    }

    public String delete(SaleListCompany s) {
        this.getSlc_dao().delete(s);
        return "sale_list_company";
    }

    public String send_update(SaleListCompany s) {
        this.slc2 = s;
        return "sale_list_company_update";
    }

    public String update() {
        this.getSlc_dao().update(this.slc2);
        return "sale_list_company";
    }
    
    public List<String> processList(){
        List<String> lst = new ArrayList();
        for(String sp :sp_dao.findAll2()){
            lst.add(sp);
        }
        return lst;
    }
    
    public List<String> companyNameList(){
        List<String> lst = new ArrayList();
        for(String cn :cc_dao.findAll2()){
            lst.add(cn);
        }
        return lst;
    }
    
    public List<String> productList(){
        List<String> lst = new ArrayList();
        for(String p :p_dao.findAll2()){
            lst.add(p);
        }
        return lst;
    }
    
    public double productPrice(String s){
        this.p = p_dao.findPrice(s);
        return this.p.getList_price();
    }
    
    
}
