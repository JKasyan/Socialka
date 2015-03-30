<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	<div class="right-bar">
		<a href="/socialka-web/friend/my_page.do"><img alt="not_found" src="<c:url value="/resources/images/404.png"/>" 
		width="400px" height="467px"
		></a>
	</div>
</body>
</html>