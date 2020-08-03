<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../common/head.jspf"%>
	<link rel="stylesheet" href="${HOME}/css/approval.css">		<!-- 수정예정 -->
	<title>회원 목록</title>
	
	<script>
		
	
		function modify(){
			var theForm = document.listFrm;
			theForm.method = "post";
			theForm.action = "${HOME}/admin/update/modify";
			theForm.submit();
			
			alert("수정이 완료되었습니다.");
		}
	
	</script>
</head>
<body>

	<div id="wrap">
		<%@ include file="../common/header.jsp"%>

		<h2>회원 목록</h2>
		<form name="listFrm">
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
						<td>
							<select name="grade">
								<option>${member.grade }</option>
								<option>ADMIN</option>
								<option>NORMAL</option>
							</select>
						</td>
					</tr>
					<input type="hidden" name="id" value=${member.id }>
				</c:forEach>
			</table>
			<div class="buttons">
				<button type="button" onclick="modify();">수정</button>
				<button type="button" onclick="delete();">삭제</button>
			</div>
		</form>

		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>