<%@ page import="com.agency.domain.Passenger" %>
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
    String buttonName = "";
    boolean save = false;

    if (request.getAttribute("save") != null) {
        buttonName = "save";
        save = true;
    }

    if (request.getAttribute("search") != null)
        buttonName = "search";


%>
<%@ include file="../../header.jsp" %>

<div id="wrapper-content">
    <%@ include file="menu.jsp" %>
    <div id="content">
        <form method="POST" action="passenger.do">
            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
                   width="100%" id="AutoNumber1" height="109">
                <tr>
                    <td width="35%" height="19">National Code</td>
                    <td width="14%" height="19">
                        <input type="text" name="nationalCode" size="20">

                    </td>
                    <td width="26%" height="19">Name</td>
                    <td width="25%" height="19">
                        <input type="text" name="name" size="20">

                    </td>
                </tr>
                <tr>
                    <td width="35%" height="19">Last Name</td>
                    <td width="14%" height="19">
                        <input type="text" name="lastName" size="20">

                    </td>
                    <td width="26%" height="19">Telephone</td>
                    <td width="25%" height="19">
                        <input type="text" name="telephone" size="20">

                    </td>
                </tr>
                <tr>
                    <td width="35%" height="52">Address</td>
                    <td width="53%" height="52">
                        <textarea rows="2" name="address" cols="38"></textarea></td>
                </tr>
                <tr>
                    <td width="35%" height="19">Flight</td>
                    <td width="14%" height="19">
                        <%@ include file="../../lib/flight-select.jsp" %>
                    </td>
                    <td width="26%" height="19">&nbsp;</td>
                    <td width="25%" height="19">&nbsp;</td>
                </tr>
                <%
                    if (save) {
                %>
                        <tr>
                            <td width="50%" height="17">Username</td>
                            <td width="50%" height="17">
                                <input type="text" name="username" size="14"></td>

                        </tr>
                        <tr>
                            <td width="50%" height="2">Password</td>
                            <td width="50%" height="2">
                                <input type="password" name="password" size="14"></td>

                        </tr>
                <%
                    }
                %>
                <tr>
                    <td width="35%" height="19">&nbsp;</td>
                    <td width="14%" height="19">
                        <p align="center"><input type="submit" value="<%=buttonName%>" name="<%=buttonName%>"></p></td>
                    <td width="26%" height="19"><input type="reset" value="Cancel" name="B2"></td>
                    <td width="25%" height="19">&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
</div>

<%@ include file="../../footer.jsp" %>


</body>
</html>