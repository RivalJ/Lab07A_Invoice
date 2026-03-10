import java.util.List;

public class Invoice {
    double total;
    Customer customer;
    List<LineItem> lineItems;

    public Invoice(Customer customer, List<LineItem> lineItems) {
        this.customer = customer;
        this.lineItems = lineItems;
    }
    public double GetTotal() {
        return total;
    }
    public Customer GetCustomer() {
        return customer;
    }
    public List<LineItem> GetLineItems() {
        return lineItems;
    }
    public void SetLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
