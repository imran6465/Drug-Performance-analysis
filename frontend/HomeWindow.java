import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomeWindow extends JFrame {
    private JButton loginButton;
    private JButton signUpButton;

    public HomeWindow() {
        super("Drug Performance Analysis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel introLabel = new JLabel("Welcome to Drug Performance Analysis!");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(introLabel, constraints);

        loginButton = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, constraints);

        signUpButton = new JButton("Sign Up");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(signUpButton, constraints);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpDialog();
            }
        });
    }

    private void showLoginDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (verifyLoginCredentials(username, password)) {
                // Handle successful login
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Update last login date in the database
                updateLastLoginDate(username);
            } else {
                // Handle incorrect login credentials
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean verifyLoginCredentials(String username, String password) {
        // Replace the following database connection details with your own
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String dbUsername = "sys as sysdba";
        String dbPassword = "vasavi";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            String query = "SELECT COUNT(*) FROM user_details WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            resultSet.close();
            statement.close();
            connection.close();

            return count > 0; // Return true if the count is greater than 0 (credentials are valid)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false; // Credentials do not match or an error occurred
    }

    private void showSignUpDialog() {
        JTextField usernameField = new JTextField();
        JTextField fullNameField = new JTextField();
        JTextField phoneField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Username:", usernameField,
                "Full Name:", fullNameField,
                "Phone:", phoneField,
                "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Sign Up", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String fullName = fullNameField.getText();
            String phone = phoneField.getText();
            String password = new String(passwordField.getPassword());

            if (saveUserDetails(username, fullName, phone, password)) {
                JOptionPane.showMessageDialog(this, "Sign up successful! Please login with your new account.", "Sign Up Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save user details. Please try again.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean saveUserDetails(String username, String fullName, String phone, String password) {
        // Replace the following database connection details with your own
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String dbUsername = "sys as sysdba";
        String dbPassword = "vasavi";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            String query = "INSERT INTO user_details (username, password, fullname, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, fullName);
            statement.setString(4, phone);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            return rowsAffected > 0; // Returns true if the user details were successfully saved
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false; // Failed to save user details
    }

    private void updateLastLoginDate(String username) {
        // Replace the following database connection details with your own
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String dbUsername = "sys as sysdba";
        String dbPassword = "vasavi";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            String query = "UPDATE user_details SET last_login = SYSDATE WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeWindow().setVisible(true);
            }
        });
    }
}
