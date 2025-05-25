
<%@ page language="java" contentType="text/html; charset=UTF-8" session="true" %>
<%@ page import="com.trainbooking.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head><title>Home</title></head>
<body>
    <h2>Welcome, <%= user.getFullname() %>!</h2>
    <p>Your email: <%= user.getEmail() %></p>
    <p>Your phone: <%= user.getPhone() %></p>
    <a href="<%=request.getContextPath()%>/logout">Logout</a>
</body>
</html>
