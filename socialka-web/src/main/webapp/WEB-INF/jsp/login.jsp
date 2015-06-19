<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Login</title>
</head>
<body>
	<div id="head-bar">
		<div id="head_table">
			<div id="head_table_row">
				<div id="logo">
					<a href="${contextPath}/my_page.html"><img alt="group"
						src="<c:url value="/resources/images/socialka_logo.gif"/>">
					</a>
				</div>
			</div>
		</div>
		<div id="registration_link">
			<a href="${contextPath}/registration.html?new">Registration</a>
		</div>
	</div>
	<div id="tape">
		<div id="form_and_errors">
			<div id="login_form">
				<form id="" action="<c:url value='/j_spring_security_check' />"method="post" name="signInForm">
					<input class="input_text" style="margin-top: 10px" type="email" name="email" placeholder="Email" /> 
					<input class="input_text" type="password" name="password"placeholder="Password" /> 
					<input class="input_submit" type="submit" value="Log in" /> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
			<div id="errors">
				<c:if test="${not empty error}"><h3>${error}</h3></c:if>
				<c:if test="${not empty msg}"><h3>${msg}</h3></c:if>
			</div>
		</div>
	</div>
	<div id="foot-bar"></div>
</body>
</html>