import javax.swing.*;
import java.util.List;

public class Invoice {
    double total;
    Customer customer;
    List<LineItem> lineItems;

    public Invoice(Customer customer, List<LineItem> lineItems) {
        this.customer = customer;
        this.lineItems = lineItems;
        total = 0;
        GetTotal();
    }
    public double GetTotal() {
        for (LineItem item : lineItems) {
            total += item.GetSubtotal();
        }
        return total;
    }
    public void PrintInvoice(JTextArea textArea) {
        textArea.setText("");
        textArea.append("Invoice for " + customer.GetName() + "\n");
        textArea.append("Address: " + customer.GetFullAddress() + "\n");
        textArea.append(String.format("%-20s%8s%10s%10s%n",
                "Name", "Qty", "Price", "Subtotal"));
        PrintLineItems(textArea);
        textArea.append("Total: $" + total + "\n");
    }
    public void PrintLineItems(JTextArea textArea) {
        for (LineItem item : lineItems) {
            String name = item.GetProduct().GetName();
            int qty = item.GetQuantity();
            double price = item.GetProduct().GetPrice();
            double subtotal = item.GetSubtotal();

            textArea.append(String.format("%-20s%8d%10.2f%10.2f%n", name, qty, price, subtotal));
        }
    }

    /**
     * Prints a formatted line (copied from pizza lab)
     * @param title name of the option that is being printed, left aligned
     * @param option name of the choice that is being printed, left aligned
     * @param price price of the option being printed, right aligned
     */
    private void PrintLine(JTextArea textArea,String title, String option, Double price){
        String formatString = "%-"+ 100 +"s%10.2f%n";
        textArea.append(String.format(formatString, title + option, price));
    }

    /**
     * Prints a formatted line with an indent (copied from pizza lab)
     * @param title name of the option that is being printed, left aligned
     * @param option name of the choice that is being printed, left aligned
     * @param price price of the option being printed, right aligned
     * @param indent number of spaces to indent the line
     */
    private void PrintLine(JTextArea textArea, String title, String option, Double price, int indent){
        String formatString = " ".repeat(indent) + "%-"+(100 - indent)+"s%10.2f%n";
        textArea.append(String.format(formatString, title + option, price));
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
