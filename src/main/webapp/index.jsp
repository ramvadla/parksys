<html>
<head>
<title>Parking System</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/RevenueNexus.css">

<style>
a:hover {
	color: #076CC0;
}
</style>
</head>

<body>
	<div id="box1">
		<header>

			<center>
				<h1>Parking System</h1>
			</center>
		</header>
	</div>

	<div id="box2">
		<center>

			<form method="Post" action="EntryServlet">
				<br> <br> <br> Vehicle Number&nbsp;<input type="text"
					name="vnumber" /><br>
				<!-- select datetime date picker -->
				<br> CheckinTime&nbsp;<input type="text" name="vdate" /><br>
				<br>Authentication Type&nbsp; <select align="center"
					name="authType" id="authType">
					<option value="CardReader">CardReader</option>
					<option value="Hologram">Hologram</option>
				</select> <br> 
				<!-- Add the backend logic to get the details based on the airlocks availability -->
				<br>Available AirLocks&nbsp; <select align="center"
					name="airLockNum" id="airLockNum">
					<option value="AirLock1">AirLock1</option>
					<option value="AirLock2">AirLock2</option>
					<option value="AirLock3">AirLock3</option>
				</select> <br> 
				
				<br> <input type="submit" id="lg" value="Submit"
					style="color: white; background-color: #5AAEF9; margin-top: 2%; margin-right: -3%;" /><br>


			</form>
		</center>
	</div>


</body>
</html>