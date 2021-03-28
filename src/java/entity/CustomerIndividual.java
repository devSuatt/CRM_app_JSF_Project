package entity;

public class CustomerIndividual {
    
    private int customer_id;
    private String customer_name;
    private String address;
    private String phone_number; 
    private String email;

    public CustomerIndividual() {
    }

    public CustomerIndividual(int customer_id, String customer_name, String address, String phone_number, String email) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
