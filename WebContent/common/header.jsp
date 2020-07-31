<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="HOME" value="${pageContext.request.contextPath}" />
<c:set var="GRADE" value="${sessionScope.loginUserInfo.grade}"/>
<%-- 공통 헤더 마크업(디자인) 영역--%>
<!-- header -->
<header id="header">
	<div id="tnbWrap">
		<div class="section">
			<div class="util">
				<ul>
					<c:choose>
						<c:when test="${ GRADE eq 'ADMIN' }">
							<li><a href="${HOME}/admin/home" title="홈으로">홈으로</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${HOME}/index" title="홈으로">홈으로</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<%-- 비로그인 상태일때 --%>
						<c:when test="${ empty sessionScope.loginUserInfo }">
							<li><a href="${HOME}/member/login" title="로그인">로그인</a></li>
							<li><a href="${HOME}/member/agree" title="회원가입">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${HOME}/member/logout" title="로그아웃">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="#" title="사이트맵">사이트맵</a></li>
					<li><a href="#" title="통합공공도서관">통합공공도서관</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="gnbWrap">
		<div class="Gnb">
			<div class="section">
				<h1 class="logo">
					<a href="#"> <%--<img src="ddd" alt="안양시립도서관(석수도서관)"> --%>
					</a>
				</h1>
				<div class="g-menu">
					<ul class="gnbMenu">
						<li><a href="./search/search.html" title="자료검색"><span>자료검색</span></a>
						</li>
						<li><a href="./booking/booking.html" title="좌석예약"><span>좌석예약</span></a>
						</li>
						<li><a href="./calendar/calendar.html" title="도서관 일정"><span>도서관
									일정</span></a></li>
						<li><a href="./community/notice.html" title="커뮤니티"><span>커뮤니티</span></a>
						</li>
						<li><a href="#" title="평생·마을교육"><span>평생·마을교육</span></a></li>
						<li><a href="#" title="이용안내"><span>이용안내</span></a></li>
						<li><a href="#" title="도서관소개"><span>도서관소개</span></a></li>
						<li><a href="#" title="정보공개"><span>정보공개</span></a></li>
						<li><a href="#" title="청소년문화공간다누리"><span>청소년문화공간다누리</span></a>
						</li>
					</ul>
				</div>
				<!-- 모바일 메뉴 -->
				<div class="mmode m-menu">
					<a href="#menu"><i class="fa fa-navicon"></i><span
						class="blind">메뉴</span></a>
				</div>
			</div>
		</div>
	</div>
</header>
<!-- // header -->