<form action="AddTrainServlet" method="post">
    Train Name: <input type="text" name="trainName" required><br>
    Origin: <input type="text" name="origin" required><br>
    Destination: <input type="text" name="destination" required><br>
    Journey Date: <input type="date" name="journeyDate" required><br>

    
    Departure Time: <input type="text" name="departureTime" placeholder="HH:mm" required><br>
    Arrival Time: <input type="text" name="arrivalTime" placeholder="HH:mm" required><br>
    Available AC Seats: <input type="number" name="availableAcSeats" min="0" required><br>
    Available Sleeper Seats: <input type="number" name="availableSleeperSeats" min="0" required><br>
    <input type="submit" value="Add Train">
</form>
