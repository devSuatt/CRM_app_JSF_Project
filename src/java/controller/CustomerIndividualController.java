package controller;

import dao.CustomerIndividualDAO;
import entity.CustomerIndividual;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "customerIndividualController")
@SessionScoped
public class CustomerIndividualController implements Serializable{

    private List<CustomerIndividual> ci_list;
    private List<CustomerIndividual> ci_list2;
    private CustomerIndividualDAO ci_dao;
    private CustomerIndividual ci  = new CustomerIndividual();
    private CustomerIndividual ci2 = new CustomerIndividual();    

    public CustomerIndividualController() {}

    public List<CustomerIndividual> getCi_list() {
        this.ci_list = this.getCi_dao().findAll();
        return ci_list;
    }

    public void setCi_list(List<CustomerIndividual> ci_list) {
        this.ci_list = ci_list;
    }

    public List<CustomerIndividual> getCi_list2() {
        this.ci_list2 = this.getCi_dao().sql();
        return ci_list2;
    }

    public void setCi_list2(List<CustomerIndividual> ci_list2) {
        this.ci_list2 = ci_list2;
    }
    
    public CustomerIndividualDAO getCi_dao() {
        if (this.ci_dao == null) {
            this.ci_dao = new CustomerIndividualDAO();
        }
        return ci_dao;
    }
    public void setCi_dao(CustomerIndividualDAO ci_dao) {
        this.ci_dao = ci_dao;
    }
    
    public CustomerIndividual getCi() {
        if(this.ci==null)
            this.ci = new CustomerIndividual();
        return ci;
    }

    public void setCi(CustomerIndividual ci) {
        this.ci = ci;
    }

    public CustomerIndividual getCi2() {
        return ci2;
    }

    public void setCi2(CustomerIndividual ci2) {
        this.ci2 = ci2;
    }
    
    public String add(){
        this.getCi_dao().insert(this.ci);
        this.ci = null; // formları sıfırlamak için
        return "customer_individual";
    }
    
    public String delete(CustomerIndividual ci){
        this.getCi_dao().delete(ci);
        return "customer_individual";
    }
    
    public String send_update(CustomerIndividual ci){
        this.ci2 = ci;
        return "customer_individual_update";
    }
    
    public String update(){
        this.getCi_dao().update(this.ci2);
        return "customer_individual";
    }
    
    
    
    
}
