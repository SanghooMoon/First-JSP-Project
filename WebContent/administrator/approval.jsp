<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	
   	<%@ include file="../common/head.jspf" %>
    <link rel="stylesheet" href="${HOME}/css/approval.css">
	<title>가입 요청 목록</title>
	<script>
		function doApproval(){
			
			var theForm = document.approvalFrm;
			theForm.mothod = "post";
			theForm.action = "${HOME}/admin/update/approval";
			theForm.submit();
			
		};
		
		function doReject(){
			var theForm = document.approvalFrm;
			theForm.mothod = "post";
			theForm.action = "${HOME}/admin/update/reject";
			theForm.submit();
		}
	</script>
</head>
<body>

	<div id="wrap">
		<%@ include file="../common/header.jsp" %>
	
    	<h2>가입 요청 목록</h2>
		<form name="approvalFrm">
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>핸드폰번호</th>
					<th>가입일</th>
					<th>등급</th>
					<th>가입승인</th>
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
			<div class="buttons">
				<button type="button" onclick="doApproval();">가입 승인</button>
				<button type="button" onclick="doReject();">가입 취소</button>
			</div>
		</form>
		
		
	
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>