<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.kasyan.Socialka.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My friends</title>
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
		<div id="all_friends">
			<c:forEach var="i" begin="0" end="${friends.size()-1}">
				<div class="friend">
					<div class="av_fr">
						<c:choose>
							<c:when test="${avatars.get(i)!=null}">
								<img alt="avatar" src="data:image/jpeg;base64,${avatars.get(i)}">
							</c:when>
							<c:when test="${avatars.get(i)==null}"> 
								<img alt="avatar"
									src="<c:url value="/resources/images/default_avatar.jpg"/>">
							</c:when>
						</c:choose>
					</div>
					<div class="fr_info">
						<a style="font-weight: bold;"
							href="${contextPath}/friend/${friends.get(i).getId()}.html">${friends.get(i).getName()}
							${friends.get(i).getLastName()}</a>
					</div>
					<div class="tamp_fr">
						<div>
							<a href="javascript:sendMessage()">Message</a>
						</div>
						<div id="friend_${friends.get(i).getId()}">
							<a href="javascript:deleteOrAddFriend(${friends.get(i).getId()})" href="">Delete from friends</a>
						</div>
					</div>
				</div>
			</c:forEach>
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
</body>
</html>