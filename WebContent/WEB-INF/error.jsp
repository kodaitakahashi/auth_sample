<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>エラー</title>
<%@ include file="common/include.jsp"%>
</style>
</head>
<body class="text-center">

	<p>エラー発生</p>
	<p>${sessionScope.message}</p>
	<c:if test="${not empty sessionScope.message}">
			<div class="alert alert-danger" role="alert">${sessionScope.message}</div>
			<!--SessionScopeにあるmessageを削除する -->
			<c:remove var="message" scope="session"/>
	</c:if>
	<a href="/auth_sample/login">
			<button class="btn btn-lg btn-primary btn-block" type="button">ログイン画面に遷移</button>
	</a>

</body>
</html>