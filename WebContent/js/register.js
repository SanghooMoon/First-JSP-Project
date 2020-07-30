/*
전역변수 
idFlag : 중복확인시 아이디를 담는 변수 ( 다음 버튼 클릭(goLoginPage())시 입력되어있는 값과 비교 목적)
numFlag : 인증번호 전송(sendNumber()) 후 일치여부 확인(일치시 true), 기본값 false
*/
var idFlag = "";   
var numFlag = false;
var certifiNum;

/*
함수(메서드) 이름 : goLoginPage()
설명 : 항목 입력여부 확인 후 가입완료 절차를 진행 후 로그인페이지로 이동하는 함수(메서드)
전역변수
numFlag : 인증번호 인증이 이루어져있는지 확인하는 변수(기본값 false)
*/
function goLoginPage() {
    // 만약 id 유효성 검사 메서드를 호출하여 false(검증X) 라면
    if(!idCheck() || !pwdCheck() || !rePwdCheck() || !nameCheck() || !phoneCheck()) {
        return false;
    }
    if(!numFlag) {
        alert("인증번호를 확인해주세요.");
        return false;
    }
    alert("회원가입이 정상적으로 완료되었습니다.");
    var theForm = document.joinFrm;
    theForm.method = "post";
    theForm.action = "/Sanghoo/member/signUp";	// 최상위 경로 동적으로 수정해야함.
    theForm.submit();
}

/*
함수(메서드) 이름 : blankCheck()
설명 : 입력항목에 대해 공백이 있는지 검사하는 함수(메서드)
매개변수
input : 입력항목에 대한 요소를 가져옵니다.
msg : 에러메세지를 표시할 요소를 가져옵니다..
*/
function blankCheck(input, msg) {
    if(input.value == ""){
        msg.style = "color:red";
        msg.innerHTML = "필수항목입니다.";
        return false;
    } 
    return true;
}

function idCheck() {
    var id = document.getElementById("id");
    var msg = document.getElementById("idErrorMsg");
    if(!blankCheck(id, msg)){
        return false;
    }
    var idReg = /^[A-Za-z0-9]{3,15}$/; 
    if(!idReg.test(id.value)) {
        msg.style = "color:red";
        msg.innerHTML = "아이디 형식이 맞지않습니다. (영문자,숫자 3~15자리)";
        return false;
    // 중복확인했을때의 아이디와 현재 아이디가 같지 않다면
    } 
    else if (idFlag != id.value){
        msg.style = "color:red";
        msg.innerHTML = "중복확인을 하셔야합니다.";
        return false;
    } 
    return true;
}

function idDuplicateCheck() {
    var id = document.getElementById("id");
    var msg = document.getElementById("idErrorMsg");
    if(!blankCheck(id, msg)) {
        return false;
    } 
    var idReg = /^[A-Za-z0-9]{3,15}$/; //영문자와 숫자 3~15자리 형식
    // 만약 입력한 id의 값이 형식에 맞지 않다면
    if(!idReg.test(id.value)) {
        msg.style = "color:red";
        msg.innerHTML = "아이디 형식이 맞지않습니다. (영문자,숫자 3~15자리)";
        id.focus();
        return false;
    } 
    
	$.ajax({
		type: "post",
		async: false,
		url: "/Sanghoo/member/duplicateChk",
		datatype: "text",
		data: {id: id.value},
		success: function(data, textStatus) {
			if(data == "used"){
				msg.style = "color:red";
		        msg.innerHTML = "이미 사용중인 아이디입니다."; 
		        id.value = "";
		        id.focus();
			} else {
				msg.style = "color:green";
		        msg.innerHTML = id.value + "(은)는 사용 가능한 아이디입니다.";
		        // idFlag 변수에 현재 입력한 아이디 값 저장
		        idFlag = id.value;
		        console.log(idFlag);
			}
		}
	})
    
    /*
    // 만약 id가 'scott'이면
    if( id.value == "scott" ) {
        msg.style = "color:red";
        msg.innerHTML = "이미 사용중인 아이디입니다."; 
        id.value = "";
        id.focus();
    // id가 중복되지 않는다면(사용이 가능하다면)
    } else {    
        msg.style = "color:green";
        msg.innerHTML = id.value + "(은)는 사용 가능한 아이디입니다.";
        // idFlag 변수에 현재 입력한 아이디 값 저장
        idFlag = id.value;
        console.log(idFlag);
    }
    */
}

function pwdCheck() {
    var pwd = document.getElementById("pwd");     
    var msg = document.getElementById("pwdErrorMsg");
    if(!blankCheck(pwd, msg)){
        return false;
    }
    var pwdReg = /^.*(?=^.{8,32}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    // 만약 비밀번호 형식이 일치하지 않는다면
    if(!pwdReg.test(pwd.value)) {
        msg.style = "color:red";
        msg.innerHTML = "비밀번호 형식이 일치하지 않습니다.(대소문자, 숫자, 특수문자 포함 8~32자리)";
        return false;
    }
    msg.style = "color:green";
    msg.innerHTML = "유효한 비밀번호입니다";
    return true;
}

function rePwdCheck() {
    var pwd = document.getElementById("pwd");
    var rePwd = document.getElementById("rePwd");
    var msg = document.getElementById("rePwdErrorMsg");
    if(!blankCheck(rePwd, msg)){
        return false;
    }
    if( pwd.value != rePwd.value ) {
        msg.style = "color:red";
        msg.innerHTML = "비밀번호가 일치하지 않습니다.";
        return false;
    }
    msg.style = "color:green";
    msg.innerHTML = "비밀번호가 일치합니다.";
    return true;
    
}

function nameCheck() {
    var name = document.getElementById("name");
    var msg = document.getElementById("nameErrorMsg");
    // 만약 공백검사가 false(공백) 이라면
    if(!blankCheck(name, msg)) {
        return false;
    }
    // 이름 유효패턴 한글로 2~5자리
    var nameReg = /^[가-힣]{2,5}$/;
    // 만약 이름 형식이 일치하지 않는다면
    if(!nameReg.test(name.value)){
        msg.style = "color:red";
        msg.innerHTML = "이름 형식이 일치하지 않습니다.(한글 2~5자리)";
        // name.focus()
        return false;
    }
    msg.style = "color:green";
    msg.innerHTML = "이름 형식이 일치합니다.";
    return true;
}

function phoneCheck() {
    var phone = document.getElementById("phone");
    var msg = document.getElementById("phoneErrorMsg");
    if(!blankCheck(phone, msg)) {
        return false;
    }
    var phoneReg = /^\d{3}\d{4}\d{4}$/; 
    // 만약 핸드폰번호 형식이 일치하지 않는다면
    if(!phoneReg.test(phone.value)){
        msg.style = "color:red";
        msg.innerHTML = "전화번호 형식이 일치하지 않습니다. (숫자 11자리 '-' 제외)";
        // phone.focus();
        return false;
    }
    msg.style = "color:green";
    msg.innerHTML = "전화번호 형식이 일치합니다.";
    return true;
}

/*
함수(메서드) 이름 : sendNumber()
설명 : 인증번호를 전송하는 함수(메서드) + 전화번호 유효성 검사
지역변수
certifiNum : 인증번호, 랜덤6자리의 수를 저장합니다.
*/
function sendNumber() {
    if( !phoneCheck() ){
        return false;
    }
    // 인증번호 랜덤 6자리 수 생성 후 certifiNum 변수에 저장
    certifiNum =  Math.floor(Math.random() * 1000000)+100000; 
    if(certifiNum>1000000){
        certifiNum -= 100000;
    }
    // 임의의 수(인증번호)를 console창에 띄웁니다.
    alert("인증번호가 전송되었습니다.\n콘솔창을 확인해주세요.")
    console.log("[인증번호] : " + certifiNum);
}

/*
함수(메서드) 이름 : certifiNumCheck()
설명 : 전송된 인증번호와 입력한 인증번호를 확인하는 함수(메서드) 
지역변수
inputCertifiNum : 요소의 아이디의 값이 "inputCertifiNum"인 요소를 가져옵니다.
전역변수
certifiNum : 인증번호, 랜덤6자리의 수를 저장하고있습니다.
*/
function certifiNumCheck() {
    var inputCertifiNum = document.getElementById("certifiNum");
    var msg = document.getElementById("certifiErrorMsg");
    var btnCertifiNum = document.getElementById("btn_certifiNum");

    if(certifiNum != inputCertifiNum.value) {
        alert("인증번호가 일치하지 않습니다.");
        msg.style = "color:red";
        msg.innerHTML = "인증번호 인증 X";
        inputCertifiNum.focus();
        numFlag = false;
        return false;
    }
    msg.style = "color:green";
    msg.innerHTML = "인증번호 인증 확인되었습니다.";
    alert("인증번호가 확인되었습니다.");
    numFlag = true;
    btnCertifiNum.style = "background-color:gray"
    btnCertifiNum.disabled = true;
}