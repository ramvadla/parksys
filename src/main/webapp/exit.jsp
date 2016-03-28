<!DOCTYPE html>
<%@page import="com.iiit.parksys.dao.VehicleDAO"%>
<%@page import="java.util.*"%>
<%@page import="com.iiit.parksys.vo.*"%>
<%@page import="com.iiit.parksys.util.*"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="main.jsp" />
	<h4>Exit</h4>
	<form method="Post" action="ExitServlet">

		<%
			List<Vehicle> vehicles = VehicleDAO.getVehicles();
				if (vehicles != null) {
					for (int i = 0; i < vehicles.size(); i++) {
						Vehicle v = vehicles.get(i);
		%>
		<input type="hidden" name="dt<%=v.getId()%>" id="dt<%=v.getId()%>"
			value="<%=Utils.calculateAmountDue(v.getInTime())%>">
		<%
			}
				}
		%>
		Vehicle No (License Plate No.):<br> 
		<select name="vehicle_id" id="vehicle_id" onchange="updateVehicle(this.value)">
			<option value="-1" selected="selected">Select Vehicle</option>
			<%
				//List<Vehicle> vehicles = VehicleDAO.getVehicles(); 
									if(vehicles!=null){
										for(int i=0;i<vehicles.size();i++){
											Vehicle v = vehicles.get(i);
			%>

			<option value="<%=vehicles.get(i).getId()%>"><%=vehicles.get(i).getVehicleNumber()%></option>
			<%
				}
								}
			%>
		</select> <br> OutTime:<%=new java.util.Date()%>
		<!--  <br> <input type="time" name="out_time">-->
		<br> Mode Of Payment:<br /> <select name="payment_type"
			id="payment_type">
			<option value="-1" selected="selected">Select Mode</option>
			<option value="cash">Cash</option>
			<option value="credit">Credit</option>
			<option value="debit">Debit</option>
			<option value="mobilewallet">Mobile Wallet</option>
		</select> Services Used: <br /> Amount Due: <br /> <span id="amount"></span> 
		<input type="hidden" name="paid_amount" id="paid_amount"/>
		<br> <input type="submit"
			class="submit" value="Submit">
	</form>
	<script>
		function updateVehicle(value) {
			var x = document.getElementById("dt"+value).value;
			document.getElementById("paid_amount").value=x;
			document.getElementById("amount").innerHTML=x;
			alert(x);
		}
		$(function() {
			$(".submit").click(function() {
				alert("Submitted");
			})
		});
	</script>
</body>
</html>