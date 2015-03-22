<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.kasyan.Socialka.Dto.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My friends</title>
<link href="resources/css/socialka.css" rel="stylesheet">
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


	<%
List<User> friends = (List<User>)request.getAttribute("friends");
 if(friends!=null){
	for(User friend:friends){
		String name = friend.getName();
		String lastName = friend.getLastName();
	%>
	<div class="friend-bar">
		<div class="photo">
			<img alt="avatar" src="resources/images/default-avatar.png" width="100px"
				height="100px" border="1px">
		</div>
		<div class="info">
			<h3><%=name+" "+lastName %></h3>
		</div>
	</div>
	<%
	}
 }
 %>
</body>
</html>