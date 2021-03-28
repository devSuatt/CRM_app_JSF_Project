package entity;

public class CustomerCompany {
    
    private int company_id;
    private String company_name;
    private String representer;
    private String address;
    private String phone_number; 
    private String email;
    
    public CustomerCompany() {
    }

    public CustomerCompany(int company_id, String company_name, String representer, String address, String phone_number, String email) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.representer = representer;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }
    

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getRepresenter() {
        return representer;
    }

    public void setRepresenter(String representer) {
        this.representer = representer;
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
    

    @Override
    public String toString() {
        return "CustomerCompany{" + "company_id=" + company_id + ", company_name=" + company_name + ", representer=" + representer + ", address=" + address + ", phone_number=" + phone_number + ", email=" + email + '}';
    }
    
    
}
