/*
전역변수
count : 로그인 실패 시 누적횟수를 저장하는 함수. (초기값 : 0)
*/
var count = 0;


/*
함수(메서드) 이름 : goMainPage()
설명 : 항목 입력여부 확인 후 로그인 절차를 진행 후 메인페이지로 이동하는 함수(메서드)
*/
function goMainPage() {
    var id = document.getElementById("id");
    var pwd = document.getElementById("pwd");
    var loginBtn = document.getElementById("loginBtn");
    // 만약 아이디와 비밀번호가 공백이라면 
    if(!blankCheck(id, "아이디") || !blankCheck(pwd, "비밀번호")) {
        return false;
    }
    
    var theForm = document.loginFrm;
    theForm.method = "post";
    theForm.action = "/Sanghoo/member/signIn"; // 로그인(서비스)
    theForm.submit();
    
    /*
    //만약 id와 password가 모두 일치하면
    if(id.value == USER_ID && pwd.value == USER_PWD) {
        alert(id.value + "님께서 로그인 하셨습니다.");
        // 누적횟수 0으로 초기화
        count = 0;
        location.href = "../index.html";
        theForm.submit();
    } else if (id.value != USER_ID || pwd.value != USER_PWD) {
        count++;
        if(count>=5) {
            alert("아이디 또는 비밀번호가"+count+"회 틀렸습니다,\n아이디 혹은 비밀번호 찾기를 이용해주세요.");
            loginBtn.style = "background-color:gray"
            loginBtn.disabled = true;
        } else {
            alert("아이디 또는 비밀번호가 " + count + "회 틀렸습니다.\n5회 틀리면 로그인을 진행할 수 없습니다.");
            id.focus();   
        }
    }
    */
}

/*
함수(메서드) 이름 : blankCheck()
설명 : 입력항목에 대해 공백이 있는지 검사하는 함수(메서드)
매개변수
input : 입력항목에 대한 요소를 가져옵니다.
txt : 입력항목에 대한 타이틀을 가져옵니다.
*/
function blankCheck(input, txt) {
    // 만약 입력한 값이 공백이라면
    if(input.value == ""){
        alert(txt + "(을)를 입력해주세요.");
        input.focus();
        return false;
    }
    return true;
}