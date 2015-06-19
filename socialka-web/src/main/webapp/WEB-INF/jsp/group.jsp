<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var="cssUrl" value="/resources/css/new_style.css" />
<link href="${cssUrl}" rel="stylesheet" type="text/css">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/logOut.js"></script>
<c:url var="faviconUrl" value="/resources/images/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${faviconUrl}">
<title>${title}</title>
</head>
<body>
	<div id="head-bar">
		<div id="head_table">
			<div id="head_table_row">
				<div id="logo">
					<img alt="group"
						src="<c:url value="/resources/images/socialka_logo.gif"/>">
				</div>
				<div id="search">
					<input type="search" placeholder="Search">
				</div>
				<a href="${contextPath}/people.html">People</a> 
				<a href="${contextPath}/groups.html">Groups</a> 
				<a href="javascript:formSubmit()">Exit</a>
			</div>
		</div>
	</div>
	<div id="tape">
		<div id="main">
			<div id="main_right">
				<div id="group_right">
					<img alt="group"
						src="<c:url value="/resources/images/group128x128.png"/>">
					<button class="socialka_buttons">Join to group</button>
				</div>
				<div id="group_left">
					<div id="title"><h4>${title}</h4></div>
					<div id="description">
						<p>
							<strong>Description:</strong> ${description}
						</p>
					</div>
					<p>
						<strong id="location">Location:</strong> ${town}
					</p>
				</div>
			</div>
			<div id="table">
				<div>
					<a href="${contextPath}/my_page.html">My space</a>
				</div>
				<div>
					<a href="${contextPath}/my_friends.html">My friends</a>
				</div>
				<div>
					<a href="${contextPath}/messages.html">My messages</a>
				</div>
				<div>
					<a href="${contextPath}/my_photos.html">My photos</a>
				</div>
				<div>
					<a href="${contextPath}/my_groups.html">My groups</a>
				</div>
				<div>
					<a href="${contextPath}/settings.html">My settings</a>
				</div>
			</div>
		</div>
		<div id="members_of_group"></div>
	</div>
	<div id="foot-bar"></div>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>