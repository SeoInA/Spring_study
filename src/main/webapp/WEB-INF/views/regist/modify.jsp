<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
		<form method="post">
			<input type="text" name="email" value="${login.email}">
			<input type="text" name="name" value="${login.name}">
			<button type="submit">수정</button>
		</form>
	</body>
</html>