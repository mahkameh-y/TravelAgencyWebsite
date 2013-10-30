<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Nautica2.2 Liquid</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description"
          content="Studio7designs - Professional Photography and Graphic Designs, Victoria BC Canada"/>
    <meta name="keywords" content="Studio7designs"/>
    <meta name="author" content="Aran / Original design: Aran Down - http://www.studio7designs.com"/>
    <link rel="stylesheet" type="text/css" href="../../style.css"/>
    <script >
        <!--
        function showFlightInfo(){
                         document.flight.location = "flight.do?flightNumber=" + document.forms[0].flight.value;
                         document.passenger.location = "reservation.do?flightNumber=" + document.forms[0].flight.value;
                         document.plane.location = "plane.do?flightNumber=" + document.forms[0].flight.value;
                       }
        //-->
    </script>
</head>

<body
<%
if (request.getAttribute("error") != null) {
	String error = (String)request.getAttribute("error");
%>
	onload="alert('<%=error%>');"
<%
}
%>
>
<form action="flight.do" method="post" >
<%@ include file="../../header.jsp" %>

<div id="wrapper-content">
    <%@ include file="menu.jsp" %>
    <p>&nbsp;</p>
    <tr width="100%">
    <td width="40%" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%@include file="../../lib/flight-select.jsp"%></td>
    <td width="60%"><input type="button" name="b1" value="Show Info" onclick="showFlightInfo()"></td>
    </tr>
    <p>&nbsp;</p>
    <div id="content">

        <iframe name="flight" src="../../frame/flight.jsp" width=500 height=400 scrolling=auto frameborder=2>
        </iframe>
        <iframe name="passenger" src="../../frame/passenger.jsp" width=500 height=400 scrolling=auto frameborder=2>
        </iframe>
        <iframe name="plane" src="../../frame/plane.jsp" width=500 height=400 scrolling=auto frameborder=2>
        </iframe>

    </div>
</div>

<%@ include file="../../footer.jsp" %>
</form>

</body>
</html>