<%@ page import="java.util.Vector"%>
<%@ page import="com.agency.domain.Menu"%>
<%
    Vector<Menu> menus = new Vector<Menu>();
    if (request.getSession().getAttribute("allowedMenus") != null) {
             menus = (Vector<Menu>) request.getSession().getAttribute("allowedMenus");
    }
%>
<div id="wrapper-menu-page">
	<div id="menu-page">
	<ul>
        <%
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.elementAt(i);
                if (menu.getPage().equalsIgnoreCase("/plane/plane.jsp") && menu.getType() == 2) {
        %>
                    <li><a href="<%=menu.getUrl()%>">   <%="    " + menu.getName() + "  "%>   </a></li>
        <%
                }
            }
        %>
        <!--<li><a href="/plane/plane.do?viewSearch=">Search</a></li>
		<li><a href="/plane/planedo?viewSave=">Register</a></li>-->
	</ul>
</div>
</div>