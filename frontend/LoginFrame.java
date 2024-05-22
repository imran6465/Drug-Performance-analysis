import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public LoginFrame() {
        super("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton signInButton = new JButton("Sign In");
        JButton loginButton = new JButton("Login");

        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(signInButton);
        panel.add(loginButton);
        panel.add(errorLabel);

        add(panel);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (checkCredentials(username, password)) {
                    // Handle successful sign in
                    JOptionPane.showMessageDialog(LoginFrame.this, "Sign in successful!");
                } else {
                    // Handle incorrect sign in credentials
                    errorLabel.setText("Invalid username or password.");
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (checkCredentials(username, password)) {
                    // Handle successful login
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                } else {
                    // Handle incorrect login credentials
                    errorLabel.setText("Invalid username or password.");
                }
            }
        });
    }

    private boolean checkCredentials(String username, String password) {
        // Replace the following database connection details with your own
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String dbUsername = "your_username";
        String dbPassword = "your_password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            String query = "SELECT * FROM user_details WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultSet.close();
                statement.close();
                connection.close();
                return true; // Credentials match
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false; // Credentials do not match
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
