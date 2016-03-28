<!DOCTYPE html>
<%@page import="com.iiit.parksys.service.ParkingAnalyzer"%>
<html>
<body>
<jsp:include page="main.jsp" />
    <h4>Status</h4>
    <p>Garage Occupancy : <%=ParkingAnalyzer.getInstance().getGarage().getOccupancy() %></p>
    <p> AirLock Occupancies:<%=ParkingAnalyzer.getInstance().getGarage().getAirLockOccupancy() %> </p>
    <!--  
    <p> Types of Vehicles: <br /> Passenger : x <br /> Military: x</p>
    <p> Garage Waiting Queue: x</p>
    <p> AirLock Waiting Queue: x</p>
    -->
</body>
</html>