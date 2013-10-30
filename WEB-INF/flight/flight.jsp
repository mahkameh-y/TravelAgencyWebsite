<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.Time"%>
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
    String buttonName = "";
    if (request.getAttribute("save") != null)
        buttonName = "save";
    if (request.getAttribute("search") != null)
        buttonName = "search";
%>

<%@ include file="../../header.jsp" %>

<div id="wrapper-content">
    <%@ include file="menu.jsp" %>
    <div id="content">

        <form method="POST" action="flight.do">
            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
                   width="100%" id="AutoNumber1">
                <tr>
                    <td width="2%">Number</td>
                    <td width="60%" colspan="2"><input type="text" name="number" size="20"></td>
                    <td width="11%">Plane</td>
                    <td width="27%">
                        <p align="left"><%@include file="../../lib/plane-select.jsp"%></p></td>
                </tr>
                <tr>
                    <td width="2%">Capacity</td>
                    <td width="60%" colspan="2"><input type="text" name="capacity" size="20"></td>
                    <td width="11%">Cost</td>
                    <td width="27%">
                        <p align="center"><input name="cost" size="20" style="float: left"></p></td>
                </tr>
                <tr>
                    <td width="2%">Source</td>
                    <td width="60%" colspan="2"><input type="text" name="source" size="20"></td>
                    <td width="11%">Destination</td>
                    <td width="27%">
                        <p align="center"><input name="destination" size="20" style="float: left"></p></td>
                </tr>
                <tr>
                    <td width="2%">Date </td>
                    <td width="16%">(YY-MM-DD)</td>
                    <td width="37%">
                        <%
                            //Date selectedDate = null;
                        %>
                        <%@include file="../../lib/date-select.jsp"%>
                    </td>
                    <td width="11%">&nbsp;</td>
                    <td width="41%">&nbsp;</td>
                </tr>
                <tr>
                    <td width="10%">Time</td>
                    <td width="14%">(HH : MM)</td>
                    <td width="29%">
                        <%
                            //Time selectedTime = null;
                        %>
                        <%@include file="../../lib/time-select.jsp"%>
                    </td>
                    <td width="6%">&nbsp;</td>
                    <td width="41%">&nbsp;</td>
                </tr>
                <tr>
                    <td width="38%" colspan="3">
                        <p align="center">
                            <input type="submit" value="<%=buttonName%>" name="<%=buttonName%>" style="float: right"></p></td>
                    <td width="62%" colspan="2">
                        <p align="center">
                            <input type="reset" value="Cancel" name="B2" style="float: left"></p></td>
                </tr>
            </table>
        </form>


    </div>
</div>

<%@ include file="../../footer.jsp" %>


</body>
</html>