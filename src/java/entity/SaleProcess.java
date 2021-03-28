
package entity;


public class SaleProcess {
    
    private String sale_process;

    public SaleProcess() {
    }

    public SaleProcess(String sale_process) {
        this.sale_process = sale_process;
    }

    @Override
    public String toString() {
        return "SaleProcess{" + "sale_process=" + sale_process + '}';
    }
    
}
