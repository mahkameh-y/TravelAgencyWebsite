<%@ page import="com.agency.domain.Passenger" %>
<%@ page import="java.util.Vector"%>
<%@ page import="com.agency.domain.Flight"%>
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
    <script>
        <!--
        function deleteFlight(){
            document.forms[0].action = "reservation.do?deleteFlight=";
            document.forms[0].submit();
       }
       function insertFlight(){
             document.forms[0].action = "reservation.do?insertFlight=";
             document.forms[0].submit();
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
<%
    boolean update = false;
    Passenger passenger = null;
    Vector<Flight> passengerFlights = new Vector<Flight>();
    if (request.getAttribute("passenger") != null) {
        passenger = (Passenger) request.getAttribute("passenger");
        update = true;
    }
    if (request.getAttribute("passengerFlights") != null)
        passengerFlights = (Vector<Flight>) request.getAttribute("passengerFlights");
%>
<%@ include file="../../header.jsp" %>

<div id="wrapper-content">
<%@ include file="menu.jsp" %>
<div id="content">

<form method="POST" action="passenger.do">
<%
    if (update) {
%>
        <input type="hidden" name="passengerID" value="<%=passenger.getId()%>">
<%
    }
%>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
       width="100%" id="AutoNumber1" height="469">
<tr>
    <td width="100%" height="196" colspan="2">
        <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
               width="100%" id="AutoNumber2" height="109">
            <tr>
                <td width="16%" height="19">National Code</td>
                <td width="35%" height="19">
                    <input type="text" name="nationalCode" size="20"
                    <%
                            if (update) {
                        %>
                           value="<%=passenger.getNationalCode()%>"
                    <%
                            }
                        %>>

                </td>
                <td width="24%" height="19">Name</td>
                <td width="25%" height="19">
                    <input type="text" name="name" size="20"
                    <%
                            if (update) {
                        %>
                           value="<%=passenger.getName()%>"
                    <%
                            }
                        %>>

                </td>
            </tr>
            <tr>
                <td width="16%" height="19">Last Name</td>
                <td width="35%" height="19">
                    <input type="text" name="lastName" size="20"
                    <%
                            if (update) {
                        %>
                           value="<%=passenger.getLastName()%>"
                    <%
                            }
                        %>>

                </td>
                <td width="24%" height="19">Telephone</td>
                <td width="25%" height="19">
                    <input type="text" name="telephone" size="20"
                    <%
                            if (update) {
                        %>
                           value="<%=passenger.getTelephone()%>"
                    <%
                            }
                        %>>

                </td>
            </tr>
            <tr>
                <td width="100%" colspan="4" height="52">Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <textarea rows="2" name="address" cols="38"><%
                        if (update) {
                    %><%=passenger.getAddress()%><%
                        }
                    %></textarea></td>
            </tr>

            <tr>
                <td width="16%" height="19">&nbsp;</td>
                <td width="35%" height="19">
                    <p align="center"><input type="submit" value="update" name="update"></p></td>
                <td width="24%" height="19"><input type="reset" value="Cancel" name="B2"></td>
                <td width="25%" height="19">&nbsp;</td>
            </tr>
        </table>

    </td>
</tr>
<tr>
    <td width="100%" height="79" colspan="2">
        -------------------------------------------------------</td>
</tr>
<tr>
    <td width="100%" height="19" colspan="2">
        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse"
               bordercolor="#111111" width="100%" id="AutoNumber3">
            <tr>
                <td width="7%" align="center">&nbsp;</td>
                <td width="19%" align="center">Flight Number</td>
                <td width="36%" align="center">Source</td>
                <td width="72%" align="center">Destination</td>
            </tr>
            <%
                for (int i = 0; i < passengerFlights.size(); i++) {
                    Flight flight = passengerFlights.elementAt(i);
            %>
            <tr>
                <td width="7%" align="center">
                    <input type="checkbox" name="selectedFlights" value="<%=flight.getId()%>"></td>
                <td width="19%" align="center"><%=flight.getNumber()%></td>
                <td width="36%" align="center"><%=flight.getSource()%></td>
                <td width="72%" align="center"><%=flight.getDestination()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </td>
</tr>
<tr>
    <td width="100%" height="19" colspan="2">&nbsp;</td>
</tr>
<tr>
    <td width="100%" height="78" colspan="2">

    <!--<input type="button"  onClick="deleteFlight();" value="Delete Traveller from the Specified Flight Lists" name="deleteFlight" >-->
    <a href="javascript:deleteFlight()">Delete Traveller from the Specified Flight Lists</a>
    </td>
</tr>
<tr>
    <td width="100%" height="19" colspan="2">
        --------------------------------------------------------</td>
</tr>
<tr>
    <td width="18%" height="40">Flight Number</td>
    <td width="82%" height="40">
        <%@include file="../../lib/flight-select.jsp"%></td>
</tr>
<tr>
    <td width="100%" height="19" colspan="2">
        <!--<input type="button" onClick="insertFlight();" value="Register Traveller in the Specified Flight" name="insertFlight" >-->
        <a href="javascript:insertFlight()">Register Traveller in the Specified Flight</a>
        </td>
</tr>
<tr>
    <td width="100%" height="19" colspan="2">&nbsp;</td>
</tr>
</table>
</form>

</div>
</div>

<%@ include file="../../footer.jsp" %>


</body>
</html>