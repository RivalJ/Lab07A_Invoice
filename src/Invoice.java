import java.util.List;

public class Invoice {
    double total;
    Customer customer;
    List<LineItem> lineItems;

    public Invoice(Customer customer, List<LineItem> lineItems) {
        this.customer = customer;
        this.lineItems = lineItems;
        total = 0;
    }
    public double GetTotal() {
        if( total == 0 ) {//only calculate the total if it hasn't been calculated yet
            for (LineItem item : lineItems) {
                total += item.GetSubtotal();
            }
        }
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
