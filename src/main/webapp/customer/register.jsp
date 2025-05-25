<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>Register</h2>
    <form action="<%=request.getContextPath()%>/register" method="post">
        Full Name: <input type="text" name="fullname" required><br>
        User Name: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        Email: <input type="email" name="email" required><br>
        Phone: <input type="text" name="phone" required><br>
        <input type="submit" value="Register">
    </form>
    <p>Already registered? <a href="<%=request.getContextPath()%>/customer/login.jsp">Login here</a></p>
</body>
</html>
