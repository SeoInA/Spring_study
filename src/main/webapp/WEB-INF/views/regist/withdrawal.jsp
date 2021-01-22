<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
		<form method="post">
			<input type="text" name="email" value="${login.email}">
			<input type="text" name="password" value="${login.password}">
			<button type="submit">탈퇴</button>
		</form>
	</body>
</html>