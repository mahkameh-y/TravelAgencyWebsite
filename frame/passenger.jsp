<%@ page import="java.util.Vector" %>
<%@ page import="com.agency.domain.Passenger" %>
<html>

<head>
    <meta http-equiv="Content-Language" content="en-us">
    <meta name="GENERATOR" content="Microsoft FrontPage 5.0">
    <meta name="ProgId" content="FrontPage.Editor.Document">
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Name</title>
    <script >
        <!--
        function deleteTraveller(){
             document.forms[0].action = "flight.do?deleteTraveller=&flightNumber=" + parent.document.forms[0].flight.value;
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
    Vector<Passenger> passengers = new Vector<Passenger>();
    if (request.getAttribute("passengers") != null) {
        passengers = (Vector<Passenger>) request.getAttribute("passengers");
    }
%>
<form method="POST" action="flight.do">
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
           width="70%" id="AutoNumber1" height="121">
        <tr>
            <td width="100%" height="102">
                <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse"
                       bordercolor="#111111" width="60%" id="AutoNumber2">
                    <tr>
                        <td width="33%" align="center">&nbsp;</td>
                        <td width="33%" align="center">Name</td>
                        <td width="34%" align="center">Last Name</td>
                    </tr>
                    <%
                        for (int i = 0; i < passengers.size(); i++) {
                            Passenger passenger = passengers.elementAt(i);
                    %>
                    <tr>
                        <td width="33%" align="center">
                            <input type="checkbox" name="selectedPassenger" value="<%=passenger.getId()%>"></td>
                        <td width="33%" align="center"><%=passenger.getName()%></td>
                        <td width="34%" align="center"><%=passenger.getLastName()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </td>
        </tr>
        <tr>
            <td width="100%" height="19">
                <p align="center">
                    <!--<input type="button" value="Delete Selected Items from Flight List" name="deleteTraveller" onclick="deleteTraveller()">-->
                    <a href="javascript:deleteTraveller()">Delete Selected Items from Flight List</a>
                 </p>
            </td>
        </tr>
    </table>
</form>

</body>

</html>
