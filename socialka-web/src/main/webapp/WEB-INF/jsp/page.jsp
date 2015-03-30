<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.kasyan.Socialka.Dto.User"%>
<%@page import="com.kasyan.Socialka.Dto.Image"%>
<%@page import="java.sql.Blob"%>
<%@page import="org.springframework.security.crypto.codec.Base64"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.getName()} ${user.getLastName()}</title>
<c:url var="cssUrl" value="/resources/css/socialka.css" />
<link href="${cssUrl}" rel="stylesheet" type="text/css" >

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
				<td><a href="/socialka-web/my_page.do">My page</a><br /></td>
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
	User user = (User)request.getAttribute("user");
	Image image = user.getPhoto();
	String encodedString=null;
	if(image!=null){
		Blob blob = image.getPhoto();
		int length = (int)blob.length();
		byte[] bytes = blob.getBytes(1, length);
		byte[] encoded = Base64.encode(bytes);
		encodedString = new String(encoded);
	}
	%>
	<c:choose>
		<c:when test="<%=encodedString != null%>">
			<img alt="avatar" src="data:image/jpeg;base64,<%=encodedString%>"
				width="300px" border="1px"><br/>
		</c:when>
		<c:when test="<%=encodedString == null%>">
			<img alt="avatar" src="resources/images/default-avatar.png"
				width="300px" border="1px"><br/>
		</c:when>
	</c:choose>
	<%=user.getName() + " " + user.getLastName()%>
</body>
</html>