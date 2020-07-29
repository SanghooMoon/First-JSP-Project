<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
   <%@ include file="../common/head.jspf" %>
    
    <!-- 로그인페이지 CSS 파일  -->
    <link rel="stylesheet" href="../css/login.css">
    <!-- login.js 로그인을 위한 자바스크립트 -->
    <!-- <script type="text/javascript" src="../js/login.js"></script> -->
   	<title>로그인</title>
    
</head>
<body>

	<div id="wrap">
		<%@ include file="../common/header.jsp" %>
		
		<!-- subContainer -->
        <div class="subContainer">
            <div class="section">
                <div class="lnb">
                    <h2>
                        <b>로그인</b>
                    </h2>
                    <ul class="subMenu">
                        <li><a href="${HOME}/member/login"><span>로그인</span></a></li>
                        <li><a href="${HOME}/member/agree"><span>회원가입</span></a></li>
                        <li><a href="../member/id_find.html"><span>아이디찾기</span></a></li>
                        <li><a href="../member/pwd_find.html"><span>비밀번호찾기</span></a></li>
                    </ul>
                </div>
                <div class="content">
                    <div class="doc">
                        <div class="doc-head">
                            <div class="doc-title">
                                <h3>로그인</h3>
                                <p>
                                    <img src="../images/incheon_sub_line.png" >
                                </p>
                            </div>
                        </div>
                        <div class="doc-body">
                            <div class="body">
                                <h3>도서관에 오신것을 환영합니다.</h3>
                                <p>- 통합회원 가입 후 2년이 경과한 경우, 개인정보 수집·이용에 대한 재동의가 필요하며, 재동의하지 않을 경우 회원 정보가 삭제될 수 있습니다.</p>
                                <!-- loginBox -->
                                <div id="loginBox">
                                <form action="#" id="loginForm">
                                    <input type="text" id="id" name="id" placeholder="아이디">              
                                    <input type="password" id="pwd" name="pwd" placeholder="비밀번호">
                                    <button type="button" onclick="goMainPage();" id="loginBtn">로그인</button>
                                    </form>
                                    <ul id="buttonGrp">
                                        <li><a href="./id_find.html">아이디 찾기</a></li>
                                        <li><a href="./pwd_find.html">비밀번호 찾기</a></li>
                                        <li><a href="./agree.html">회원가입</a></li>
                                    </ul>
                                    <div id="notice">
                                        <p>- 아이디가 없으신 분은 회원가입을 하시기 바랍니다.</p>
                                    </div>
                                </div>
                                <!-- // loginBox -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- // subContainer -->
		
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>