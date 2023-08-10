<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// focus <-> blur
		$('#username').on("blur", async function() {
			// 아이디는 알바벳과 숫자 8~10자리 => 문자 패턴을 확인하는 방법은
			// 정규식 (Regular Expression)
			const pattern = /^[A-Za-z0-9]{8,10}$/;
			const username = $('#username').val();
			if(username==='') {
				$('#username_msg').text('아이디를 입력하세요.').css('color', 'red');
				return;
			}
			if(pattern.test(username)===false) {
				$('#username_msg').text('아이디는 영/숫자 8~10자리입니다.').css('color', 'red');
				return;
			}
			try {
				await $.ajax(`/member/check/username/\${username}`);
				$('#username_msg').text('사용 가능합니다.').css('color', 'blue');
			}catch(err) {
				$('#username_msg').text('사용중입니다.').css('color', 'red');
			}
		});
	});
</script>
</head>
<body>
	<form action="/member/join" method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="username" id="username">
		<span id="username_msg"></span><br>
		비밀번호 : <input type="password" name="password" id="password">
		<span id="password_msg"></span><br>
		이메일 : <input type="email" name="email" id="email">
		<span id="email_msg"></span><br>
		생일 : <input type="date" name="birthday" id="birthday"><br>
		<button>가입</button>
	</form>
</body>
</html>