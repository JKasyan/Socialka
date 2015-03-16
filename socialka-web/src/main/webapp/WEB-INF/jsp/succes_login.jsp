<%@page import="com.kasyan.Socialka.Dto.User"%>
<%@page import="org.hibernate.type.YesNoType"%>
<%@page import="java.util.Calendar"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/bootstrap.css" rel="stylesheet">

<style>

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
			<div class="container">
			</div>
		</div>
	</div>
	<%User user = (User)request.getAttribute("new_user"); %>
	<h1>You succes to login</h1>
	<h1><%=user.toString() %></h1>
	
</body>
</html>