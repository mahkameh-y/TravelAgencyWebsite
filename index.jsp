<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Nautica2.2 Liquid</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description"
          content="Studio7designs - Professional Photography and Graphic Designs, Victoria BC Canada"/>
    <meta name="keywords" content="Studio7designs"/>
    <meta name="author" content="Aran / Original design: Aran Down - http://www.studio7designs.com"/>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script>
        <!--
            function encode() {
                document.forms[0].submit();
            }
        //-->

    </script>
</head>

<body>

<div id="wrapper-menu-top">
<div id="menu-top">
	<ul>
		<li><%="    Airplanes |    "%></li>
		<li><%="    Flights |     "%></li>
		<li><%="    Travellers |  "%></li>
        <li><%="    Logoff        "%></li>
    </ul>
</div><!--menu-top-->
</div><!--wrapper-menu-top-->

<div id="wrapper-header">
<div id="header">
<div id="wrapper-header2">
<div id="wrapper-header3">
	<h1>Visionary Vacation Agency</h1>
</div>
</div>
</div>
</div>

<div id="wrapper-content">

    <div id="content">

        <form method="POST" action="login.do">
            <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
                   width="50%" align="center" id="AutoNumber1" height="60">
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
                <tr>
                    <td width="50%" height="19" align="center">
                        <input type="button" onclick="encode()" value="Sign in" name="signIn">
                    </td>
                    <td width="50%" height="19">
                        <!--<a href="login.do?signUp=">Sign Up</a>-->
                    </td>
                </tr>

            </table>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>


</body>
</html>