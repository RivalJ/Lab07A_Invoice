public class LineItem {
    Product product;
    int quantity;
    double subtotal;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public double GetSubtotal() {
        return product.GetPrice() * quantity;
    }
    public Product GetProduct() {
        return product;
    }
    public int GetQuantity() {
        return quantity;
    }
}
