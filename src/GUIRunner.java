import javax.swing.*;

public class GUIRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            InvoiceGUI gui = new InvoiceGUI();
            gui.setVisible(true);
        });
    }
}
