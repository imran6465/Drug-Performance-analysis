import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    // Database connection details
    String jdbcUrl = "<YOUR_DB_CONNECTION_DETAILS>";
    String dbUsername = "<YOUR_DB_USERNAME>";
    String dbPassword = "<YOUR_DB_PASSWORD>";

    try {
      // Load the JDBC driver
      Class.forName("oracle.jdbc.OracleDriver");

      // Establish the database connection
      Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

      // Prepare the SQL query
      String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, username);
      statement.setString(2, password);
      statement.setString(3, email);

      // Execute the query
      int rowsInserted = statement.executeUpdate();

      // Close the database resources
      statement.close();
      connection.close();

      // Send the response
      response.setContentType("text/html");
      response.getWriter().println("Sign Up successful!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
