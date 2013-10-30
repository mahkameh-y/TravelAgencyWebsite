<%@ page import="java.util.Vector"%>
<%@ page import="com.agency.domain.Passenger"%>
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
    <SCRIPT>

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

<%@ include file="../../header.jsp" %>
<%
    Vector<Passenger> passengers = new Vector<Passenger>();
    if (request.getAttribute("passengers") != null)
        passengers = (Vector<Passenger>)request.getAttribute("passengers");
%>

<div id="wrapper-content">
    <%@ include file="menu.jsp" %>
    <div id="content">


        <form method="POST" action="passenger.do">
            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
                   width="100%" id="AutoNumber1" height="91">
                <tr>
                    <td width="100%" height="72" colspan="2">
                        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse"
                               bordercolor="#111111" width="70%" id="AutoNumber2">
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
                                <td width="33%" align="center"><a href="<%="passenger.do?passengerID=" + passenger.getId()%>"><%=passenger.getName()%></a></td>
                                <td width="34%" align="center"><%=passenger.getLastName()%></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="50%" height="19">
                        <p align="center"><input type="submit" value="Delete" name="delete"></p></td>
                    <td width="50%" height="19"><input type="reset" value="Cancel" name="B2"></td>
                </tr>
            </table>
        </form>

    </div>
</div>

<%@ include file="../../footer.jsp" %>


</body>
</html>