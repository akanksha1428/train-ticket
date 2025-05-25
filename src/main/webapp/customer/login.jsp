
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%
    String error = (String) request.getAttribute("errorMessage");
%>
<html>
<head><title>Login</title></head>
<body>
    <h2>Login</h2>
    <% if (error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } %>
  <form action="${pageContext.request.contextPath}/login" method="post">
    
        User name: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
