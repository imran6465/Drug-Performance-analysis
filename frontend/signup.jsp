<!DOCTYPE html>
<html>
<head>
  <title>Sign Up</title>
</head>
<body>
  <h2>Sign Up</h2>
  <form action="SignupServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <input type="submit" value="Sign Up">
  </form>
</body>
</html>
