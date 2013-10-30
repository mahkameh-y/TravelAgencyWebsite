<%@ page import="com.agency.domain.Plane" %>
<html>

<head>
    <meta http-equiv="Content-Language" content="en-us">
    <meta name="GENERATOR" content="Microsoft FrontPage 5.0">
    <meta name="ProgId" content="FrontPage.Editor.Document">
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Number</title>
    
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
    Plane plane = null;
    if (request.getAttribute("plane") != null) {
        update = true;
        plane = (Plane) request.getAttribute("plane");
    }
%>

<form method="POST" action="plane.do">
    <%
        if (update) {
    %>
            <input type="hidden" name="planeID" value="<%=plane.getId()%>">
    <%
        }
    %>
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
           width="70%" id="AutoNumber1">
        <tr>
            <td width="17%">Number</td>
            <td width="83%">
                <input type="text" name="number" size="20"
                <%
                        if (update) {
                    %>
                       value="<%=plane.getNumber()%>"
                <%
                        }
                    %>></td>
        </tr>
        <tr>
            <td width="17%">Model</td>
            <td width="83%">
                <input type="text" name="model" size="20"
                <%
                        if (update) {
                    %>
                       value="<%=plane.getModel()%>"
                <%
                        }
                    %>
                        ></td>
        </tr>
        <tr>
            <td width="17%">Capacity</td>
            <td width="83%">
                <input type="text" name="capacity" size="20"
                <%
                        if (update) {
                    %>
                       value="<%=plane.getCapacity()%>"
                <%
                        }
                    %>
                        ></td>
        </tr>
        <tr>
            <td width="100%" colspan="2">
                <p align="center"><input type="submit" value="Save Changes to Flight Plane Info" name="updateFlightPlane"></p></td>
        </tr>
    </table>
</form>

</body>

</html>
