<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/bootstrap.css" rel="stylesheet">

<style>
.date {
	float: none;
	height: 30px;
	width: 90px;
	background: url(date.png) no-repeat;
	margin-right: 10px;
	padding-top: 0px;
	line-height: normal;
}

.file_upload {
	position: relative;
	overflow: hidden;
	margin-bottom: 10px;
}
</style>
<c:url var="cssUrl" value="/resources/css/socialka.css" />
<link href="${cssUrl}" rel="stylesheet" type="text/css">

</head>

<body>

	<div class="left-bar"></div>

	<div class="top-bar">
		<div class="label">
			<a href="/socialka-web/friend/my_page.do"><h1>Socialka</h1></a>
		</div>

		<div class="right">
			<a class="button black" href="/socialka-web/log_out.do">Log out</a>
		</div>
	</div>

	<div class="main-bar"></div>

	<div class="right-bar">
		<form method="post">
			<input type="email" name="email" class="form-control"
				placeholder="Email" /><br/>
				<input type="password" name="password"
				class="form-control" placeholder="Password" /><br/> 
				<input type="password" name="password_repeat" class="form-control"
				placeholder="Repeat password" /><br/>
				<input type="text"
				name="name" class="form-control" placeholder="Name" /><br/> 
				<input type="text" name="last_name" class="form-control"
				placeholder="Last name" /><br/> 
				<input type="date" name="date" class="date" /><br /> <input type="submit" class="btn btn-primary" />
		</form>

	</div>
</body>
</html>