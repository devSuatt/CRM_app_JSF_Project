package controller;

import dao.CustomerIndividualDAO;
import dao.ProductDAO;
import dao.SaleListIndividualDAO;
import dao.SaleProcessDAO;
import entity.SaleListIndividual;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "saleListIndividualController")
@SessionScoped
public class SaleListIndividualController implements Serializable {

    private List<SaleListIndividual> sli_list;
    private List<SaleListIndividual> sli_list2;
    private List<SaleListIndividual> sli_list3;
    private List<SaleListIndividual> sli_list4;
    private List<SaleListIndividual> sli_list5;
    private SaleListIndividualDAO sli_dao;
    private SaleListIndividual sli;
    private SaleListIndividual sli2;
    private SaleProcessDAO sp_dao = new SaleProcessDAO();
    private CustomerIndividualDAO ci_dao = new CustomerIndividualDAO();
    private ProductDAO p_dao = new ProductDAO();

    public SaleListIndividualController() {
    }

    public List<SaleListIndividual> getSli_list() {
        this.sli_list = this.getSli_dao().findAll();
        return sli_list;
    }

    public void setSli_list(List<SaleListIndividual> sli_list) {
        this.sli_list = sli_list;
    }

    public List<SaleListIndividual> getSli_list2() {
        this.sli_list2 = this.getSli_dao().sqlOffer();
        return sli_list2;
    }

    public void setSli_list2(List<SaleListIndividual> sli_list2) {
        this.sli_list2 = sli_list2;
    }

    public List<SaleListIndividual> getSli_list3() {
        this.sli_list3 = this.getSli_dao().sqlNegotiation();
        return sli_list3;
    }

    public void setSli_list3(List<SaleListIndividual> sli_list3) {
        this.sli_list3 = sli_list3;
    }

    public List<SaleListIndividual> getSli_list4() {
        this.sli_list4 = this.getSli_dao().sqlOrder();
        return sli_list4;
    }

    public void setSli_list4(List<SaleListIndividual> sli_list4) {
        this.sli_list4 = sli_list4;
    }

    public List<SaleListIndividual> getSli_list5() {
        this.sli_list5 = this.getSli_dao().sqlPayment();
        return sli_list5;
    }

    public void setSli_list5(List<SaleListIndividual> sli_list5) {
        this.sli_list5 = sli_list5;
    }

    
    
    public SaleListIndividualDAO getSli_dao() {
        if (this.sli_dao == null) {
            this.sli_dao = new SaleListIndividualDAO();
        }
        return sli_dao;
    }

    public void setSli_dao(SaleListIndividualDAO sli_dao) {
        this.sli_dao = sli_dao;
    }

    public SaleListIndividual getSli() {
        if (this.sli == null) {
            this.sli = new SaleListIndividual();
        }
        return sli;
    }

    public void setSli(SaleListIndividual sli) {
        this.sli = sli;
    }

    public SaleListIndividual getSli2() {
        return sli2;
    }

    public void setSli2(SaleListIndividual sli2) {
        this.sli2 = sli2;
    }
    
    public String add(){
        this.getSli_dao().insert(this.sli);
        this.sli = null; // formları sıfırlamak için
        return "sale_list_individual";
    }
    
    public String delete(SaleListIndividual s){
        this.getSli_dao().delete(s);
        return "sale_list_individual";
    }
    
    public String send_update(SaleListIndividual s){
        this.sli2 = s;
        return "sale_list_individual_update";
    }
    
    public String update(){
        this.getSli_dao().update(this.sli2);
        return "sale_list_individual";
    }
    
    public List<String> processList(){
        List<String> lst = new ArrayList();
        for(String sp :sp_dao.findAll2()){
            lst.add(sp);
        }
        return lst;
    }
    
    public List<String> customerNameList(){
        List<String> lst = new ArrayList();
        for(String cn :ci_dao.findAll2()){
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
}
