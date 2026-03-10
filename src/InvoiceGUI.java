import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InvoiceGUI extends JFrame {
    Invoice invoice;
    List<LineItem> lineItems = new ArrayList<>();
    Customer customer;

    JPanel mainPanel, lineItemInput, customerInput;
    JTextField name, streetAddress, city, state, country, zipcode;
    JTextField itemQuantity, itemName, itemPrice;
    JButton addLineItem, addCustomer, generateInvoice;


    public InvoiceGUI() {
        super("Invoice");
        Dimension baseScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        float applicationScaleFactorWidth = 1f/3f;
        float applicationScaleFactorHeight = 2f/5f;
        Dimension applicationSize = new Dimension(
                (int)(baseScreenSize.width * applicationScaleFactorWidth),
                (int)(baseScreenSize.height * applicationScaleFactorHeight)
        );

        setSize(applicationSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Setup();
    }

    private void Setup(){
        mainPanel = new JPanel();
        customerInput = new JPanel();
        lineItemInput = new JPanel();

        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        name = SetUpTextField("Name", name, customerInput);
        streetAddress = SetUpTextField("Street Address", streetAddress, customerInput);
        city = SetUpTextField("City", city, customerInput);
        state = SetUpTextField("State", state, customerInput);
        country = SetUpTextField("Country", country, customerInput);
        zipcode = SetUpTextField("Zip Code", zipcode, customerInput);
        itemName = SetUpTextField("Item Name", itemName, lineItemInput);
        itemPrice = SetUpTextField("Item Price", itemPrice, lineItemInput);
        itemQuantity = SetUpTextField("Item Quantity", itemQuantity, lineItemInput);

        addLineItem = new JButton("Add Line Item");
        addCustomer = new JButton("Add Customer");
        generateInvoice = new JButton("Generate Invoice");
        addLineItem.addActionListener(new ButtonListener());
        addCustomer.addActionListener(new ButtonListener());
        generateInvoice.addActionListener(new ButtonListener());

        mainPanel.add(addLineItem);
        mainPanel.add(addCustomer);
        mainPanel.add(generateInvoice);

        customerInput.setBorder(BorderFactory.createTitledBorder("Customer Information: "));
        lineItemInput.setBorder(BorderFactory.createTitledBorder("Line Item Information: "));

        customerInput.setLayout(new BoxLayout(customerInput, BoxLayout.Y_AXIS));
        lineItemInput.setLayout(new BoxLayout(lineItemInput, BoxLayout.Y_AXIS));

        mainPanel.add(customerInput);
        mainPanel.add(lineItemInput);

        super.add(mainPanel);
    }

    /**
     * Makes setting up each of the text entry fields easier and cleaner.
     * @param labelText the label that will go next to the text field
     * @param field the actual text field that will be used to store the text
     * @param panel the target panel that we want the text field to be stored in
     */
    private JTextField SetUpTextField(String labelText, JTextField field, JPanel panel){
        JPanel fieldPanel = new JPanel();

        fieldPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel(labelText + ": ");
        field = new JTextField();
        field.setPreferredSize(new Dimension(200, 20));
        fieldPanel.add(label, BorderLayout.WEST);
        fieldPanel.add(field, BorderLayout.EAST);


        panel.add(fieldPanel);
        return field;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == addLineItem){
                lineItems.add(
                        new LineItem(
                                new Product(
                                        itemName.getText(),
                                        Double.parseDouble(itemPrice.getText())),
                                Integer.parseInt(itemQuantity.getText()
                                )
                        )
                );
                System.out.println(lineItems);
            }
            else if(e.getSource() == addCustomer){
                customer = new Customer(
                        name.getText(),
                        streetAddress.getText(),
                        city.getText(),
                        state.getText(),
                        country.getText(),
                        zipcode.getText()
                );
                System.out.println(customer);
            }
            else if(e.getSource() == generateInvoice){
                if(customer != null && lineItems.size() > 0){
                    invoice = new Invoice(customer, lineItems);
                    System.out.println(invoice);
                }
            }
        }
    }
}
