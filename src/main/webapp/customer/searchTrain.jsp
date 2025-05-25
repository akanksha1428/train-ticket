<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session == null || session.getAttribute("fullName") == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
    String fullName = (String) session.getAttribute("fullName");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Train</title>
</head>
<body>
    <h2>Welcome, <%= fullName %></h2>
    <h3>Search for trains</h3>
    <form action="<%=request.getContextPath()%>/searchTrain" method="post">
        <label>Origin: </label>
        <input type="text" name="origin" required /><br/><br/>
        <label>Destination: </label>
        <input type="text" name="destination" required /><br/><br/>
        <label>Journey Date: </label>
        <input type="date" name="journeyDate" required /><br/><br/>
        <input type="submit" value="Search" />
    </form>
    <br/>
    <a href="customerDashboard.jsp">Back to Dashboard</a>
</body>
</html>
