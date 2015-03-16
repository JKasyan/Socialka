<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Socialka</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/bootstrap.css" rel="stylesheet">

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
	<h2>Welcome to the Socialka</h2>
	<form action="sign_in" method="post">
					<input type="email" name="email" class="form-control" placeholder="Email"/><br/> 
				    <input type="password" name="password" class="form-control" placeholder="Password"/><br/> 
					<a href="login.do" class="btn btn-primary">Log in</a>
					<input type="submit" class="btn btn-primary" value="Sign in"/>
	</form>
	</div>
	
</body>
</html>