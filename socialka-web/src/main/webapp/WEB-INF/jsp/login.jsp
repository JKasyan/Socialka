<%@page import="org.hibernate.type.YesNoType"%>
<%@page import="java.util.Calendar"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/bootstrap.css" rel="stylesheet">

<style>

.date
{
float: none;
height: 30px;
width: 90px;
background: url(date.png) no-repeat;
margin-right: 10px;
padding-top: 0px;
line-height: normal;
}

.file_upload{
    position: relative;
    overflow: hidden;
    margin-bottom: 10px;
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
			<div class="container">

			</div>
		</div>
	</div>
	
	<div class="hero-unit">
	<h3>Please enter your data</h3>
	<!-- 
	<form action="main.do" method="post">
					<input type="email" name="email" class="form-control" placeholder="Email"/>
				    <input type="password" name="password" class="form-control" placeholder="Password"/><br/>
				    <input type="password" name="password_repeat" class="form-control" placeholder="Repeat password"/><br/>
				    <input type="text" name="name" class="form-control" placeholder="Name"/><br/>
				    <input type="text" name="last_name" class="form-control" placeholder="Last name"/><br/>
				    <input type="date" name="date" class="date"/><br/>
					<input type="submit" class="btn btn-primary"/>
	</form>
	 -->
		<sf:form method="POST" modelAttribute="user">
			<fieldset>
				<table>
					<tr>
						<th><label for="email">Email: </label></th>
						<td><sf:input path="email" size="20" id="email" /><br/>
						<sf:errors path="email" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<th><label for="password">Password: </label></th>
						<td><sf:password path="password" size="20" id="password" showPassword="false"/><br/>
						<sf:errors path="password" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<th><label for="name">Name: </label></th>
						<td><sf:input path="name" size="20" id="name" /><br/>
						<sf:errors path="name" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<th><label for="lastName">Last name: </label></th>
						<td><sf:input path="lastName" size="20" id="lastName" /><br/>
						<sf:errors path="lastName" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<th><label for="dateOfBirth">Birthday: </label></th>
						<td><sf:input path="dateOfBirth" id="dateOfBirth" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input name="ok" type="submit" value="Create" /></td>
					</tr>
				</table>
			</fieldset>
		</sf:form>
	</div>
</body>
</html>