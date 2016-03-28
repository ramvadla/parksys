<!DOCTYPE html>
<%@page import="com.iiit.parksys.dao.VehicleDAO"%>
<%@page import="java.util.*"%>
<%@page import="com.iiit.parksys.vo.*"%>
<%@page import="com.iiit.parksys.util.*"%>
<%@page import="com.iiit.parksys.reports.*"%>
<html>
<body>
<jsp:include page="main.jsp" />
<%
	ReportDirector director = new ReportDirector();
%>
<h4>Reports</h4>
<form method="GET" action="DownloadServlet">
    Payments Made:  <%=director.getTotalPayments() %> <br/> <br />
    Amounts Due:  <%=director.getDueAmount() %><br /> <br />
    Peak Hours:  <%=director.getPeakGarageHours() %><br /> <br />
    Permits Used: <%=director.getPermitsCount() %> <br /> <br />
    Download:
    <input type="submit" value="XML" name="xmlbtn"/>  <input type="submit" value="TXT" name="xmlbtn"/>
 </form>   
</body>
</html>