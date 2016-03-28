<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="main.jsp" />
<h4> Entry </h4>
    <form method="Post" action="EntryServlet">
        Vehicle No (License Plate No.):<br>
        <input type="text" name="vehicle_id">
        <br>
        Vehicle Type:<br>
        <input type="radio" name="vehicle_type" value="ore"> Space Ore
        <input type="radio" name="vehicle_type" value="passenger"> Passenger/Military
        <br>
        InTime: <br><%=new java.util.Date() %>
        <!--  <input type="time" name="in_time">-->
        <br>
        Approximate Number of Hours:<br>
        <input type="radio" class="approx" name="approximate" value="1"> 1
        <input type="radio" class="approx" name="approximate" value="2"> 2
        <input type="radio" class="approx" name="approximate" value="3"> 3
        <input type="radio" class="approx" name="approximate" value="4"> 4
        <input type="radio" class="approx" name="approximate" value="5"> 5
        <input type="radio" class="approx" name="approximate" value="6"> 6
        <div id="service1"> Services: <br>
            <input type="checkbox" name="s1" value="1">Internal Wash<br>
        </div>
        <div id="service2"> Services: <br>
            <input type="checkbox" name="s1" value="1">Internal Wash<br>
            <input type="checkbox" name="s2" value="2">External Wash<br>
        </div>
        <div id="service3"> Services: <br>
            <input type="checkbox" name="s1" value="1">Internal Wash<br>
            <input type="checkbox" name="s2" value="2">External Wash<br>
            <input type="checkbox" name="s3" value="3">Wheel Alignment<br>
        </div>
        <div id="service4"> Services: <br>
            <input type="checkbox" name="s1" value="1">Internal Wash<br>
            <input type="checkbox" name="s2" value="2">External Wash<br>
            <input type="checkbox" name="s3" value="3">Wheel Alignment<br>
            <input type="checkbox" name="s4" value="4">Oil and Filter<br>
        </div>
        <div id="service5"> Services: <br>
            <input type="checkbox" name="s1" value="1">Internal Wash<br>
            <input type="checkbox" name="s2" value="2">External Wash<br>
            <input type="checkbox" name="s3" value="3">Wheel Alignment<br>
            <input type="checkbox" name="s4" value="4">Oil and Filter<br>
            <input type="checkbox" name="s5" value="5">Interim Service<br>
        </div>
        <div id="service6"> Services: <br>
            <input type="checkbox" name="s1" value="1">Internal Wash<br>
            <input type="checkbox" name="s2" value="2">External Wash<br>
            <input type="checkbox" name="s3" value="3">Wheel Alignment<br>
            <input type="checkbox" name="s4" value="4">Oil and Filter<br>
            <input type="checkbox" name="s5" value="5">Interim Service<br>
            <input type="checkbox" name="s6" value="6">Full Service<br>
        </div>
        <br>
        Mode of Authentication:<br>
        <input type="radio" class="authmode" name="authentication_mode" value="hologram"> Hologram
        <input type="radio" class="authmode" name="authentication_mode" value="permit"> Permit
        <div id="permit_no"> Permit number <input type="text" name="permit_number"> </div>
        <br><br><br>
        <input type="submit" class="submit" value="Submit">
    </form> 

<script>
    $(function() {
        $("#permit_no, #service1, #service2, #service3, #service4, #service5, #service6").hide();
        $(".approx").click(function () {
            if ($('input[name="approximate"]:checked').val() == "1") {
                $("#service1").show();
                $("#service2").hide();
                $("#service3").hide();
                $("#service4").hide();
                $("#service5").hide();
                $("#service6").hide();
            }
            else if ($('input[name="approximate"]:checked').val() == "2") {
                $("#service2").show();
                $("#service1").hide();
                $("#service3").hide();
                $("#service4").hide();
                $("#service5").hide();
                $("#service6").hide();
            }
            else if ($('input[name="approximate"]:checked').val() == "3"){
                $("#service3").show();
                $("#service1").hide();
                $("#service2").hide();
                $("#service4").hide();
                $("#service5").hide();
                $("#service6").hide();
            }
            else if ($('input[name="approximate"]:checked').val() == "4") {
                $("#service4").show();
                $("#service2").hide();
                $("#service3").hide();
                $("#service1").hide();
                $("#service5").hide();
                $("#service6").hide();
            }
            else if ($('input[name="approximate"]:checked').val() == "5"){
                $("#service5").show();
                $("#service2").hide();
                $("#service3").hide();
                $("#service4").hide();
                $("#service1").hide();
                $("#service6").hide();
            }
            else if ($('input[name="approximate"]:checked').val() == "6"){
                $("#service6").show();
                $("#service2").hide();
                $("#service3").hide();
                $("#service4").hide();
                $("#service5").hide();
                $("#service1").hide();
            }
         })
        $(".authmode").click(function() {
            if ($('input[name="authentication_mode"]:checked').val() == "permit")
                $("#permit_no").show();
            else if ($('input[name="authentication_mode"]:checked').val() == "hologram")
                $("#permit_no").hide();


        });
        $(".submit").click  (function () {
            alert("Submitted");
        })
    });
</script>
</body>
</html>