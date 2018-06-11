<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
<%@ include file="common/include.jsp"%>
<style>
.form-signin {
	width: 100%;
	max-width: 500px;
	padding: 15px;
	margin: 0 auto;
}
</style>
</head>
<body class="text-center">

	<form class="form-signin" action="login" method="POST">
		<h1 class="h3 mb-3 font-weight-normal">ログイン</h1>
		<c:if test="${not empty message}">
			<div class="alert alert-danger" role="alert">${message}</div>
		</c:if>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" id="inputEmail" class="form-control"
			placeholder="Email address" name="email" required="" autofocus="">
		<label for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" class="form-control"
			name="password" placeholder="Password" required="">
		<button class="btn btn-lg btn-primary btn-block" type="submit">ログイン</button>
	</form>

</body>
</html>