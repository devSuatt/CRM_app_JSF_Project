
package entity;

public class SaleListIndividual {
    
    private int sli_id;
    private String customer_name;
    private String product_name;
    private double price;
    private String process;

    public SaleListIndividual() {
    }

    public SaleListIndividual(int sli_id, String customer_name, String product_name, double price, String process) {
        this.sli_id = sli_id;
        this.customer_name = customer_name;
        this.product_name = product_name;
        this.price = price;
        this.process = process;
    }

    public int getSli_id() {
        return sli_id;
    }

    public void setSli_id(int sli_id) {
        this.sli_id = sli_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
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
        return "SaleListIndividual{" + "sli_id=" + sli_id + ", customer_name=" + customer_name + ", product_name=" + product_name + ", price=" + price + ", process=" + process + '}';
    }
    
}
