import java.sql.*;
public class test {
    public static void main(String[] args) {
        try {
            // Register the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl",
                    "sys as sysdba",
                    "vasavi"
            );

            // Perform database operations
            // ...
            // ...
            System.out.println("successfull");

// Create a statement
Statement statement = connection.createStatement();

// Execute the query
ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");

// Process the result set
while (resultSet.next()) {
    int id = resultSet.getInt("id");
    String ename = resultSet.getString("ename");
    // Retrieve other columns as needed
    
    // Do something with the data...
    System.out.println(id+""+ename);
}

// ...

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
