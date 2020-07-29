<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
   	<%@ include file="../common/head.jspf" %>
   	<link rel="stylesheet" href="../css/register.css">
	<script type="text/javascript" src="../js/register.js"></script>
	
	<title>회원가입 - 정보입력</title>
</head>
<body>

	<div id="wrap">
		<%@ include file="../common/header.jsp" %>
		
		<!-- subContainer -->
        <div class="subContainer">
            <div class="section">
                <div class="lnb">
                    <h2>
                        <b>회원가입</b>
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
                                <h3>회원가입 - 정보입력</h3>
                                <p>
                                    <img src="../images/incheon_sub_line.png" >
                                </p>
                            </div>
                        </div>
                        <div class="doc-body">
                            <div class="body">
                                <div class="txt-box">
                                    <ul>
                                        <li>● 아이디는 3~15자리의 영문자,숫자 사용가능합니다. 대소문자는 구별하고 한글 및 특수문자는 사용불가합니다.</li>
                                        <li>● 비밀번호는 8~32자리의 영문자, 숫자, 특수문자를 조합하여 사용해야합니다.</li>
                                        <li>● 이름은 2~5자리의 한글만 입력가능합니다.</li>
                                        <li>● 전화번호는 '-' 없이 입력합니다.</li>
                                    </ul>
                                </div>
                                <div class="join-box">
                                    <form id="join-form" name="joinFrm">
                                        <table>
                                            <tr>
                                                <th>
                                                    <label for="id">아이디</label>
                                                </th>
                                                <td>
                                                    <input type="text" id="id" name="id" onblur="idCheck();">
                                                    <button type="button" onclick="idDuplicateCheck();" >중복확인</button>
                                                    <p id="idErrorMsg" class="error_msg"></p>
                                                </td>
                                                
                                            </tr>
                                            <tr>
                                                <th>
                                                    <label for="pwd">비밀번호</label>
                                                </th>
                                                <td>
                                                    <input type="password" id="pwd" name="pwd" onblur="pwdCheck();">
                                                    <p id="pwdErrorMsg" class="error_msg"></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>
                                                    <label for="rePwd">비밀번호 재입력</label>
                                                </th>
                                                <td>
                                                    <input type="password" id="rePwd" name="rePwd" onblur="rePwdCheck();">
                                                    <p id="rePwdErrorMsg" class="error_msg"></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>
                                                    <label for="name">이름</label>
                                                </th>
                                                <td>
                                                    <input type="text" id="name" name="name" onblur="nameCheck();">
                                                    <p id="nameErrorMsg" class="error_msg"></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th><label for="phone">전화번호</label></th>
                                                <td>
                                                    <input type="text" id="phone" name="phone" placeholder="- 제외" onblur="phoneCheck();">
                                                    <button type="button" onclick="sendNumber();" id="sendButton">인증번호 전송</button>
                                                    <p id="phoneErrorMsg" class="error_msg"></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>
                                                    <label for="certifiNum">인증번호</label>
                                                </th>
                                                <td>
                                                    <input type="text" id="certifiNum" name="certifiNum">
                                                    <button id="btn_certifiNum" type="button"  onclick="certifiNumCheck();">인증번호 확인</button>
                                                    <p id="certifiErrorMsg" class="error_msg"></p>
                                                </td>
                                            </tr>
                                        </table>
                                        <button type="button" id="joinBtn" onclick="goLoginPage();">가입 완료</button>
                                    </form>
                                </div>
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