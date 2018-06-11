<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
<%@ include file="common/include.jsp"%>
</head>
<body class="text-center">
	<div class="row">
		<div class="col-12">
			<c:if test="${not empty sessionScope.message}">
				<div class="success alert-success" role="alert">${sessionScope.message}</div>
				<c:remove var="message" scope="session"/>
			</c:if>
			<p>現在ログインしているユーザー ${sessionScope.loginUser.name }</p>
		</div>
	</div>

	<div class="row">
		<div class="col-12">
			<a href="/auth_sample/logout">
				<button class="btn btn-lg btn-danger btn-block">ログアウト</button>
			</a>
		</div>
	</div>

</body>
</html>