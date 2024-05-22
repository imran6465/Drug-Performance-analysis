import java.sql.*;

public class UserDetailsTest {
    public static void main(String[] args) {
        // Replace the following database connection details with your own
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String dbUsername = "sys as sysdba";
        String dbPassword = "vasavi";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user_details";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                String fullName = resultSet.getString("FULLNAME");
                String phone = resultSet.getString("PHONE");
                Date lastLogin = resultSet.getDate("LAST_LOGIN");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Full Name: " + fullName);
                System.out.println("Phone: " + phone);
                System.out.println("Last Login: " + lastLogin);
                System.out.println("------------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
