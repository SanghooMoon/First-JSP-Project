<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
   <%@ include file="../common/head.jspf" %>
    
</head>
<body>

	<div id="wrap">
		<%@ include file="../common/header.jsp" %>
	
		<h2>승인페이지</h2>
		<form action="${HOME}/admin/update/approval" method="get">
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>핸드폰번호</th>
					<th>가입일</th>
					<th>등급</th>
				</tr>
				<c:forEach items="${list}" var="member">
					<tr>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.phone }</td>
						<td>${member.indate }</td>
						<td>${member.grade }</td>
						<td><input type="checkbox" value="${member.id }" name="checked"></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="버튼">
			
		</form>
		
	
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>