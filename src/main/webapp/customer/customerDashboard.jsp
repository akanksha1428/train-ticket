<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session == null || session.getAttribute("fullName") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String fullName = (String) session.getAttribute("fullName");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Dash board</title>
    <!-- Optional: Bootstrap CSS for styling -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body style="background-color: #f2f2f2;">
    <div class="container mt-5">
        <div class="card shadow p-4">
            <h2 class="mb-4 text-primary">Welcome, <%= fullName %>!</h2>

            <ul class="list-group">
                <li class="list-group-item"><a href="searchTrain.jsp">Book Tickets</a></li>
                <li class="list-group-item"><a href="viewBookings.jsp">View My Ticket Bookings</a></li>
                <li class="list-group-item"><a href="updateDetails.jsp">Update My Details</a></li>
                <li class="list-group-item"><a href="logout.jsp">Logout</a></li>
            </ul>
        </div>
    </div>
</body>
</html>
