package controller;

import dao.CustomerCompanyDAO;
import entity.CustomerCompany;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "customerCompanyController")
@SessionScoped
public class CustomerCompanyController implements Serializable {

    private List<CustomerCompany> cc_list;
    private List<CustomerCompany> cc_list2;
    private CustomerCompanyDAO cc_dao;
    private CustomerCompany cc = new CustomerCompany();
    private CustomerCompany cc2 = new CustomerCompany();

    public CustomerCompanyController() {
    }

    public List<CustomerCompany> getCc_list() {
        this.cc_list = this.getCc_dao().findAll();
        return cc_list;
    }

    public void setCc_list(List<CustomerCompany> cc_list) {
        this.cc_list = cc_list;
    }

    public List<CustomerCompany> getCc_list2() {
        this.cc_list2 = this.getCc_dao().sql();
        return cc_list2;
    }

    public void setCc_list2(List<CustomerCompany> cc_list2) {
        this.cc_list2 = cc_list2;
    }

    
    public CustomerCompanyDAO getCc_dao() {
        if (this.cc_dao == null) {
            this.cc_dao = new CustomerCompanyDAO();
        }
        return cc_dao;
    }

    public void setCc_dao(CustomerCompanyDAO cc_dao) {
        this.cc_dao = cc_dao;
    }

    public CustomerCompany getCc() {
        if (this.cc == null) {
            this.cc = new CustomerCompany();
        }
        return cc;
    }

    public void setCc(CustomerCompany cc) {
        this.cc = cc;
    }

    public CustomerCompany getCc2() {
        return cc2;
    }

    public void setCc2(CustomerCompany cc2) {
        this.cc2 = cc2;
    }

    public String add() {
        this.getCc_dao().insert(this.cc);
        this.cc = null; // formları sıfırlamak için
        return "customer_company";
    }

    public String delete(CustomerCompany cc) {
        this.getCc_dao().delete(cc);
        return "customer_company";
    }
    
    public String send_update(CustomerCompany cc) {
        this.cc2 = cc;
        return "customer_company_update";
    }

    public String update() {
        this.getCc_dao().update(this.cc2);
        return "customer_company";
    }

}
