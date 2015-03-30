<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.kasyan.Socialka.Dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.kasyan.Socialka.Dto.Image"%>
<%@page import="java.sql.Blob"%>
<%@page import="org.springframework.security.crypto.codec.Base64"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My friends</title>
<link href="resources/css/socialka.css" rel="stylesheet">
</head>

<body>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	
	<div class="left-bar"></div>

	<div class="top-bar">
		<div class="label">
			<a href="/socialka-web/my_page.do"><h1>Socialka</h1></a>
		</div>

		<div class="right">
			<a class="button black" href="javascript:formSubmit()"> Log out</a>
		</div>
	</div>

	<div class="main-bar">
		<table>
			<tr>
				<td><a href="/socialka-web/my_page.do">My page</a><br />
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


	<%
List<User> friends = (List<User>)request.getAttribute("friends");
 if(friends!=null){
	for(User friend:friends){
		String name = friend.getName();
		String lastName = friend.getLastName();
		Image image = friend.getPhoto();
		String encodedString=null;
		int id = friend.getId();
		if(image!=null){
			Blob blob = image.getPhoto();
			int length = (int)blob.length();
			byte[] bytes = blob.getBytes(1, length);
			byte[] encoded = Base64.encode(bytes);
			encodedString = new String(encoded);
		}
	%>
	<div class="friend-bar">
		<div class="photo">
			<c:choose>
				<c:when test="<%=encodedString != null%>">
					<img alt="avatar" src="data:image/jpeg;base64,<%=encodedString%>"
						width="100px" height="100px" border="1px">
				</c:when>
				<c:when test="<%=encodedString == null%>">
					<img alt="avatar" src="resources/images/default-avatar.png"
						width="100px" height="100px" border="1px">
				</c:when>
			</c:choose>
		</div>
		<div class="info">
			<h3><a href="/socialka-web/friend/<%=id%>.do"><%=name + " " + lastName%></a></h3>
		</div>
	</div>
	<%
	}
 }
 %>
</body>
</html>