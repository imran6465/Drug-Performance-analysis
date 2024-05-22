import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Database connection details
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    String dbUsername = "sys as sysdba";
    String dbPassword = "vasavi";

    try {
      // Load the JDBC driver
      Class.forName("oracle.jdbc.OracleDriver");

      // Establish the database connection
      Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

      // Prepare the SQL query
      String sql = "SELECT COUNT(*) AS count FROM users_details WHERE username = ? AND password = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, username);
      statement.setString(2, password);

      // Execute the query
      ResultSet result = statement.executeQuery();
      result.next();
      int count = result.getInt("count");

      // Close the database resources
      result.close();
      statement.close();
      connection.close();

      // Send the login status response
      response.setContentType("text/html");
      if (count == 1) {
        response.getWriter().println("Login successful!");
      } else {
        response.getWriter().println("Login failed. Invalid username or password.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
