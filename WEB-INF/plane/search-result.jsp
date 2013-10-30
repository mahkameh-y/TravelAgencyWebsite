<%@ page import="com.agency.domain.Plane" %>
<%@ page import="java.util.Vector" %>
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
    Vector<Plane> planes = new Vector<Plane>();
    if (request.getAttribute("planes") != null)
        planes = (Vector<Plane>) request.getAttribute("planes");
%>

<%@ include file="../../header.jsp" %>

<div id="wrapper-content">

    <%@ include file="menu.jsp" %>
    <div id="content">
        <form method="POST" action="plane.do">
            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
                   width="100%" id="AutoNumber1" height="181">
                <tr>
                    <td width="100%" height="162" colspan="2">
                        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse"
                               bordercolor="#111111" width="50%" id="AutoNumber2">
                            <tr>
                                <td width="11%" align="center">&nbsp;</td>
                                <td width="49%" align="center">Number</td>
                                <td width="40%" align="center">Model</td>
                            </tr>
                            <%
                                for (int i = 0; i < planes.size(); i++) {
                                    Plane plane = planes.elementAt(i);
                            %>
                                    <tr>
                                        <td width="11%" align="center">
                                            <input type="checkbox" name="selectedPlanes" value="<%=plane.getId()%>"></td>
                                        <td width="49%" align="center"><a href=<%="plane.do?planeID="+plane.getId()%>><%=plane.getNumber()%></a></td>
                                        <td width="40%" align="center"><%=plane.getModel()%></td>
                                    </tr>
                            <%
                                }
                            %>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="50%" height="19">
                        <p align="center"><input type="submit" value="Delete" name="B1"></p></td>
                    <td width="50%" height="19">
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