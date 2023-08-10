<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	루트 페이지입니다.
	<c:if test="${username==null}">
		<br>
		<a href="/member/login">로그인</a>
	</c:if>
	<c:if test="${username!=null}">
		<form action="/member/logout" method="post">
			<button>로그아웃</button>
		</form>
	</c:if>
</body>
</html>