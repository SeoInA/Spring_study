<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<li><a href="<%=request.getContextPath()%>/main">메인 페이지</a></li>
	
	<li><a href="<%=request.getContextPath()%>/register" class="btn btn-primary">회원가입</a></li>
	<li><a href="<%=request.getContextPath()%>/login" class="btn btn-primary">로그인</a></li>
	<li><a href="<%=request.getContextPath()%>/modify">회원정보 수정</a></li>
	<li><a href="<%=request.getContextPath()%>/withdrawal">회원탈퇴</a></li>

</body>
</html>
