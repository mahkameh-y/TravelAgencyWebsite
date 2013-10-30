<%@ page import="java.util.Vector"%>
<%@ page import="com.agency.domain.Menu"%>
<%
     Vector<Menu> upMenus = new Vector<Menu>();
    if (request.getSession().getAttribute("allowedMenus") != null) {
             upMenus = (Vector<Menu>) request.getSession().getAttribute("allowedMenus");
    }
%>
<div id="wrapper-menu-top">
<div id="menu-top">
	<ul>
        <%
            for (int i = 0; i < upMenus.size(); i++) {
                Menu upMenu = upMenus.elementAt(i);
                if (upMenu.getType() == 1) {
        %>
                    <li><a href="<%=upMenu.getUrl()%>">    <%="     " + upMenu.getName() + "       "%>   </a></li>
        <%
                }
            }
        %>
        <!--<li><a href="/plane/plane.do?view=" title="Planes"><span>Airplanes</span></a></li>
		<li><a href="/flight/flight.do?viewSearch=" title="Flights"><span>Flights</span></a></li>
		<li><a href="/passenger/passenger.do?viewSearch=" title="Passengers"><span>Travellers</span></a></li>-->
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