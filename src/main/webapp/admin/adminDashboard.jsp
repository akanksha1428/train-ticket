<%@ page session="true" %>
<%
    String adminEmail = (String) session.getAttribute("adminEmail");
    if (adminEmail == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head><title>Admin Dashboard</title></head>
<body>
    <h2>Welcome, Admin!</h2>
    <ul>
        <li><a href="addTrain.jsp">Add Train</a></li>
        <li><a href="updateTrain.jsp">Update Train</a></li>
        <li><a href="deleteTrain.jsp">Delete Train</a></li>
        <li><a href="<%= request.getContextPath() %>/logout">Logout</a> 
        </li>
    </ul>
</body>
</html>
