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

	<div class="left-bar"></div>

	<div class="top-bar">
		<div class="label"><a href="/socialka-web/friend/my_page.do"><h1>Socialka</h1></a></div>

		<div class="right">
			<a class="button black" href="/socialka-web/log_out.do">Log out</a>
		</div>
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

	<div class="right-bar">
		<a href="/socialka-web/friend/my_page.do"><img alt="not_found" src="<c:url value="/resources/images/404.png"/>" 
		width="400px" height="467px"
		></a>
	</div>
</body>
</html>