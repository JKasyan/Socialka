<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kasyan.Socialka.dto.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.getName()}${user.getLastName()}</title>
<c:url var="cssUrl" value="/resources/css/new_style.css" />
<link href="${cssUrl}" rel="stylesheet" type="text/css">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:url var="faviconUrl" value="/resources/images/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${faviconUrl}">
</head>
<body>
	<div id="head-bar">
		<div id="head_table">
			<div id="head_table_row">
				<div id="logo">
					<!-- 
			<img alt="group"
				src="<c:url value="/resources/images/socialka_logo.gif"/>">
				 -->
				</div>
				<div id="search">
					<input type="search" placeholder="Search">
				</div>
				<a href="${contextPath}/people.html">People</a> <a
					href="${contextPath}/groups.html">Groups</a> <a
					href="javascript:formSubmit()">Exit</a>
			</div>
		</div>
	</div>
	<div id="tape">
		<div id="main">
			<div id="main_right">
				<div id="avatar_and_edit">
					<div id="avatar">
						<c:choose>
							<c:when test="${image!=null}">
								<%--<img alt="avatar" src="data:image/jpeg;base64,${image}">--%>
								<img alt="avatar" src="images/${user.getAvatarId()}">
							</c:when>
							<c:when test="${image==null}">
								<img alt="avatar" style="width: 150px"
									src="<c:url value="/resources/images/default_avatar.jpg"/>">
							</c:when>
						</c:choose>
					</div>
					<div id="under_avatar">
						<c:if test="${isMyPage}">
							<a href="${contextPath}/edit.html">Edit</a>
						</c:if>
						<c:if test="${not isMyPage}">
							<c:choose>
								<c:when test="${friendsStatus==0}">
									<button class="socialka_buttons" id="be_friends_button"
										onclick="javascript:beFriends(${user.getId()})">Be
										friends</button>
								</c:when>
								<c:when test="${friendsStatus==1}">
									<h4>Request sent</h4>
								</c:when>
								<c:when test="${friendsStatus==2}">
									<h4>You are friends</h4>
								</c:when>
							</c:choose>
						</c:if>
					</div>
				</div>
				<div id="user_data">
					<div id="name">
						<h4>${user.getName()} ${user.getLastName()}</h4>
					</div>
				</div>
			</div>
			<div id="table">
				<div>
					<a href="${contextPath}/my_page.html">My space</a>
				</div>
				<div id="friends_row" >
					<a href="${contextPath}/my_friends.html">My friends</a>
					<div class="notification"></div>
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
	</div>
	<div id="foot-bar"></div>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script type="text/javascript"
		src="${contextPath}/resources/js/jquery-1.11.3.js"></script>
	<script type="text/javascript"
		src="${contextPath}/resources/js/socialka.js"></script>
	<script type="text/javascript">
	setInterval(upDateProposalsBeFriend, 60000);
	</script>
	<script type="text/javascript">
	$("#avatar img").hover(function(){
		console.log("On image");
	},function(){
		console.log("Out of image")
	})
	</script>
</body>
</html>