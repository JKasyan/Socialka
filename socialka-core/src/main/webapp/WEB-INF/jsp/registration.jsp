<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var="cssUrl" value="/resources/css/new_style.css" />
<link href="${cssUrl}" rel="stylesheet" type="text/css">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.3.js"></script>
<c:url var="faviconUrl" value="/resources/images/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${faviconUrl}">
<title>Registration</title>
</head>
<body>
	<div id="head-bar">
		<div id="head_table">
			<div id="head_table_row">
				<div id="logo">
					<img alt="group"
						src="<c:url value="/resources/images/socialka_logo.gif"/>">
				</div>
			</div>
		</div>
		<div id="registration_link">
			<a href="${contextPath}/login.html">Log in</a>
			<a href="${contextPath}/registration.html?new">Registration</a>
		</div>
	</div>
	<div id="tape">
	<div id="registration_form">
		<form method="post">
			<input type="email" name="email" class="input_text" placeholder="Email" /> 
			<input type="password" name="password" id="password" class="input_text" placeholder="Password" required="required" />
			<input type="text" name="name" class="input_text" placeholder="Name" /> 
			<input type="text" name="lastName" class="input_text" placeholder="Last name" /> 
			<select class="input_text" name="gender">
				<option disabled>Select gender</option>
				<option selected value="M">Men</option>
				<option value="W">Women</option>
			</select>
			<input type="date" name="date" class="input_text" /> 
			<input type="submit" class="input_submit" value="Send"/>
		</form>
	</div>
	</div>
	<div id="foot-bar"></div>
</body>
</html>