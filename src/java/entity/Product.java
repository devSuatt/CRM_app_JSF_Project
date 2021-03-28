
package entity;

public class Product {
    
    private int product_id;
    private String product_name;
    private double list_price;
    private int quantity_on_hand;
    private String description;

    public Product() {
    }

    public Product(int product_id, String product_name, double list_price, int quantity_on_hand, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.list_price = list_price;
        this.quantity_on_hand = quantity_on_hand;
        this.description = description;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(int quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_name=" + product_name + ", list_price=" + list_price + ", quantity_on_hand=" + quantity_on_hand + ", description=" + description + '}';
    }
    
}
