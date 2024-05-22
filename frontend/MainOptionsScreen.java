package project;
import javax.swing.*;

public class MainOptionsScreen extends JFrame {
    public MainOptionsScreen() {
        initComponents();
    }

    private void initComponents() {
        // Add your code to create the main options screen components
        // Example:
        JPanel panel = new JPanel();
        panel.add(new JLabel("Main Options Screen"));

        add(panel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainOptionsScreen mainOptionsScreen = new MainOptionsScreen();
            mainOptionsScreen.setVisible(true);
        });
    }
}
