<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Socialka</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/socialka.css" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="left-bar"></div>
	
	<div class="top-bar">
		<div class="label"><a href="/socialka-web/friend/my_page.do"><h1>Socialka</h1></a></div>

	</div>
	
		<div class="main-bar">
		<table>
			<tr>
				<td><a href="/socialka-web/friend/my_page.do">My page</a><br />
				</td>
			</tr>
			<tr>
				<td><a href="/socialka-web/my_friends.do">My friends</a><br />
				</td>
			</tr>
			<tr>
				<td><a href="/socialka-web/messages.do">My messages</a><br />
				</td>
			</tr>
			<tr>
				<td><a href="/socialka/properties.do">My properties</a><br />
				</td>
			</tr>
			<tr>
				<td><a href="/socialka-web/my_groups.do">My groups</a></td>
			</tr>
		</table>
	</div>

	<c:if test="${not empty error}">
			${error}
	</c:if>

	<c:if test="${not empty msg}">
			${msg}
	</c:if>

	<c:choose>
		<c:when test="${empty email}">
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${email} <br/>You do not have permission to access this page!</h2>
		</c:otherwise>
	</c:choose>
	
</body>
</html>