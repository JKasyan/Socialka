<%@page import="java.io.OutputStream"%>
<%@page import="com.kasyan.Socialka.Dto.Image"%>
<%@page import="java.sql.Blob"%>
<%@page import="org.hibernate.type.YesNoType"%>
<%@page import="com.kasyan.Socialka.Dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.getName()}${user.getLastName()}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/bootstrap.css" rel="stylesheet">

<style>
.block {
	padding-left: 100px;
	width: 200px;
	background: #ccc;
	float: left;
}

body {
	padding-top: 100px;
}
</style>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container"></div>
		</div>
	</div>

	<%
	User user = (User)request.getAttribute("user");
	int id = user.getId();
	
	String sessionId = null;
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("JSESSIONID")) sessionId=cookie.getValue();
		}
	}
	%>
	<div class="hero-unit">
		<p>
			<b>${user.getName()} ${user.getLastName()}</b><br/>
			<img src="/socialka-web/getImage/${user.getId()}.do" alt="avatar" width="200px"><br/>
			<a href="/socialka-web/friend/my_page.do">My page</a><br/>
			<a href="/socialka-web/my_friends.do">My friends</a><br/>
			<a href="socialka/messages">My messages</a><br/>
			<a href="socialka/properties">My properties</a><br/>
			<a href="/socialka-web/log_out.do">Log out</a>
			<%=sessionId %>
		</p>
	</div>
</body>
</html>