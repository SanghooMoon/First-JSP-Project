<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
   <%@ include file="./common/head.jspf" %>
    
</head>
<body>

	<div id="wrap">
		<%@ include file="./common/header.jsp" %>
		
		<!-- 임시 마크업 -->
		<h2>관리자 페이지입니다.</h2>
		<br>
		<a href="${HOME}/admin/management">회원 관리</a>
		<br>
		<a href="${HOME}/admin/approval">가입 요청 목록</a>
		
		
		<%@ include file="./common/footer.jsp" %>
	</div>
</body>
</html>