<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	// 자바스크립트에서 EL 읽어오기
	const msg = '${msg}'; // msg 가 없으면 따옴표가 공백이 된다.
	if(msg!=='') {
		alert(msg);
	}
</script>
</head>
<body>
	<form action="/member/login" method="post">
		<input type="text" name="username" placeholder="아이디 입력"><br>
		<input type="password" name="password" placeholder="비밀번호 입력"><br>
		<button>로그인</button>
	</form>
</body>
</html>