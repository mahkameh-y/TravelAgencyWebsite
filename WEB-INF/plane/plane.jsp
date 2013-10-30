<%@ page import="com.agency.domain.Flight" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.agency.domain.Plane" %>
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
    boolean search = false;
    boolean update = false;
    String buttonName = "save";
    Plane plane = null;

    if (request.getAttribute("search") != null) {
        search = true;
        buttonName = "search";
    }
    if (request.getAttribute("plane") != null) {
        update = true;
        buttonName = "update";
        plane = (Plane) request.getAttribute("plane");

    }
%>

<%@ include file="../../header.jsp" %>

<div id="wrapper-content">
    <%@ include file="menu.jsp" %>
    <div id="content">
        <form method="POST" action="plane.do">
            <%
                if (update) {
            %>
                    <input type="hidden" name="planeID" value="<%=plane.getId()%>">
            <%
                }
            %>
            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
                   width="100%" id="AutoNumber1">
                <tr>
                    <td width="10%">Number</td>
                    <td width="40%"><input type="text" name="number" size="20"
                    <%
                        if (update) {
                    %>
                                           value="<%=plane.getNumber()%>"
                    <%
                        }
                    %>></td>
                    <td width="12%">Model</td>
                    <td width="38%"><input type="text" name="model" size="20"
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
                    <td width="10%">Capacity</td>
                    <td width="40%"><input type="text" name="capacity" size="20"
                    <%
                        if (update) {
                    %>
                                           value="<%=plane.getCapacity()%>"
                    <%
                        }
                    %>
                            ></td>
                    <%
                        if (search) {
                    %>
                    <td width="12%">Flight</td>
                    <td width="38%">
                        <%@ include file="../../lib/flight-select.jsp" %>
                    </td>
                    <%
                        }
                    %>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td width="40%"><p align="center">
                        <input type="submit" value="<%= buttonName %>" name="<%=buttonName%>"></p></td>
                    <td width="12%">
                        <p align="center">
                            <input type="reset" value="Cancel" name="B2" style="float: right"></p></td>
                    <td width="38%">&nbsp;</td>
                </tr>
            </table>
        </form>

    </div>
</div>

<%@ include file="../../footer.jsp" %>


</body>
</html>