<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trainbooking.model.Train" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Train Search Results</title>
    <style>
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #999;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Available Trains</h2>
    <%
        List<Train> trains = (List<Train>) request.getAttribute("trainList");
        if (trains != null && !trains.isEmpty()) {
    %>
    <table>
        <tr>
            <th>Train Name</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>Journey Date</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
        </tr>
        <%
            for (Train train : trains) {
        %>
        <tr>
            <td><%= train.getTrainName() %></td>
            <td><%= train.getOrigin() %></td>
            <td><%= train.getDestination() %></td>
            <td><%= new SimpleDateFormat("yyyy-MM-dd").format(train.getJourneyDate()) %></td>
            <td><%= train.getDepartureTime() %></td>
            <td><%= train.getArrivalTime() %></td>
        </tr>
        <% } %>
    </table>
    <% } else { %>
        <p style="text-align:center;">No trains found for the given criteria.</p>
    <% } %>
    <div style="text-align:center;">
        <a href="<%=request.getContextPath()%>/customer/searchTrain.jsp">Back to Search</a>
    </div>
</body>
</html>
