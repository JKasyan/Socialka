<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.kasyan.Socialka.Dto.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<User> friends = (List<User>)request.getAttribute("friends"); 
if(friends!=null){
	for(User friend:friends){
		String name = friend.getName();
		String lastName = friend.getLastName();
%>
<h3><%=name+" "+lastName %></h3>
<% 
	}
}
%>
</body>
</html>