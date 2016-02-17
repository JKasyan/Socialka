<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kasyan.Socialka.dto.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.getName()}${user.getLastName()}</title>
<c:url var="cssUrl" value="/resources/css/new_style.css" />
<link href="${cssUrl}" rel="stylesheet" type="text/css">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${contextPath}/resources/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/logOut.js"></script>
<c:url var="faviconUrl" value="/resources/images/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${faviconUrl}">
</head>
<body>
	<div id="head-bar">
		<div id="head_table">
			<div id="head_table_row">
				<div id="logo">
					<!-- 
			<img alt="group"
				src="<c:url value="/resources/images/socialka_logo.gif"/>">
				 -->
				</div>
				<div id="search">
					<input type="search" placeholder="Search">
				</div>
				<a href="${contextPath}/people.html">People</a> <a
					href="${contextPath}/groups.html">Groups</a> <a
					href="javascript:formSubmit()">Exit</a>
			</div>
		</div>
	</div>
	<div id="tape">
		<div id="main">
			<div id="main_right" class="not_found">
				<h1>Page not found</h1>
			</div>
		</div>
		<div id="table" style="border-bottom: 			thin dotted gray;">
			<div>
				<a href="${contextPath}/my_page.html">My space</a>
			</div>
			<div>
				<a href="${contextPath}/my_friends.html">My friends</a>
			</div>
			<div>
				<a href="${contextPath}/messages.html">My messages</a>
			</div>
			<div>
				<a href="${contextPath}/my_photos.html">My photos</a>
			</div>
			<div>
				<a href="${contextPath}/my_groups.html">My groups</a>
			</div>
			<div>
				<a href="${contextPath}/settings.html">My settings</a>
			</div>
		</div>
	</div>
	</div>
	<div id="foot-bar"></div>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>