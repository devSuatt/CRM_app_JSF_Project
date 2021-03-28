
package entity;

public class SaleListCompany {
    
    private int slc_id;
    private String company_name;
    private String product_name;
    private double price;
    private String process;

    public SaleListCompany() {
    }

    public SaleListCompany(int slc_id, String company_name, String product_name, double price, String process) {
        this.slc_id = slc_id;
        this.company_name = company_name;
        this.product_name = product_name;
        this.price = price;
        this.process = process;
    }

    public int getSlc_id() {
        return slc_id;
    }

    public void setSlc_id(int slc_id) {
        this.slc_id = slc_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "SaleListCompany{" + "slc_id=" + slc_id + ", company_name=" + company_name + ", product_name=" + product_name + ", price=" + price + ", process=" + process + '}';
    }
    
}
