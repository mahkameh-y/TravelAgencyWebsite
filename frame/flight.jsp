<%@ page import="com.agency.domain.Flight" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Time" %>
<html>

<head>
    <meta http-equiv="Content-Language" content="en-us">
    <meta name="GENERATOR" content="Microsoft FrontPage 5.0">
    <meta name="ProgId" content="FrontPage.Editor.Document">
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Plane</title>
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
<%
    boolean update = false;
    Flight flight = null;
    //int selectedIndex = -1;
    if (request.getAttribute("flight") != null) {
        update = true;
        flight = (Flight) request.getAttribute("flight");
        System.out.println("flight.getdate= " + flight.getDate());
        //selectedIndex = flight.getPlane().getId();
    }
%>

<form method="POST" action="flight.do">
    <%
        if (update) {
    %>
    <input type="hidden" name="flightNumber" value="<%=flight.getId()%>">
    <%
        }
    %>
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
           width="100%" id="AutoNumber1">
        <tr>
            <td width="31%">Plane</td>
            <td width="69%">
                <%@ include file="../lib/plane-select.jsp" %>
            </td>
        </tr>
        <tr>
            <td width="31%">Capacity</td>
            <td width="69%">
                <input type="text" name="capacity" size="20"
                <%
                    if (update) {
                %>
                       value="<%=flight.getCapacity()%>"
                <%
                    }
                %>></td>
        </tr>
        <tr>
            <td width="31%">Cost</td>
            <td width="69%">
                <input type="text" name="cost" size="20"
                <%
                    if (update) {
                %>
                       value="<%=flight.getCost()%>"
                <%
                    }
                %>></td>
        </tr>
        <tr>
            <td width="31%">Source</td>
            <td width="69%">
                <input type="text" name="source" size="20"
                <%
                    if (update) {
                %>
                       value="<%=flight.getSource()%>"
                <%
                    }
                %>></td>
        </tr>
        <tr>
            <td width="31%">Destination</td>
            <td width="69%">
                <input type="text" name="destination" size="20"
                <%
                    if (update) {
                %>
                       value="<%=flight.getDestination()%>"
                <%
                    }
                %>></td>
        </tr>
        <tr>
            <td width="31%">Date (YY-MM-DD)</td>
            <td width="69%">
                <%
                    /*Date selectedDate = null;
                    if (update)
                        selectedDate = flight.getDate();*/
                %>
                <%@ include file="../lib/date-select.jsp" %>
            </td>
        </tr>
        <tr>
            <td width="31%">Time (HH : MM)</td>
            <td width="69%">
                <%
                    /*Time selectedTime = null;
                    if (update)
                        selectedTime = flight.getTime();*/
                %>
                <%@ include file="../lib/time-select.jsp" %>
            </td>
        </tr>

        <tr>
            <td width="38%" colspan="3">
                <p align="center">
                    <input type="submit" value="Update Flight" name="update" style="float: right"></p></td>
            <td width="62%" colspan="2">
                <p align="center">
                    <input type="submit" value="Delete Flight" name="delete" style="float: left"></p></td>
        </tr>
    </table>
</form>

</body>

</html>
