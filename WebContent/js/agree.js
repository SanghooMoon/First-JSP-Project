/*
전역변수
checkFlag : 체크박스의 상태를 지정하는 변수( 기본값 : false )
*/
var checkFlag = false;


/*
함수(메서드)이름 : goNextPage()
설명 : 필수 약관동의 내용이 체크되어있으면 정보입력 페이지로 이동, 아니면 알림창 출력 
지역변수 
chkAgree : class의 값이 "essential_agree"인 요소(필수약관만 따로 class 이름을 지정)를 가져와서 chkAgree 변수에 저장
반환값 : "./register.html" 필수항목이 모두 체크되어있지 않다면 "#" 리턴
*/
function goNextPage(){
    var chkAgree = document.getElementsByClassName("essential_agree");

    //필수 항목이 하나라도 체크되지 않았다(false)면 페이지 이동X 
    if( !chkAgree[0].checked || !chkAgree[1].checked ) {
        // jQuery로 처리 가능
        alert("이용약관을 모두 동의하셔야합니다.");
        return "#";
    }
    // alert("정보입력으로 이동합니다.");
    return "/Sanghoo/member/register?continue=true";
}

/*
함수(메서드)이름 : agreeMore()
설명 : 약관 더보기(>) 버튼 클릭시 약관전문을 보여주는 기능을 하는 함수
지역변수
morePage : 약관더보기 레이아웃이 지정된 요소를 저장
매개변수 
num : n번째 요소임을 전달받아 num 변수로 사용
*/
function agreeMore(num){
    var morePage = document.getElementsByClassName("layer_more")[num];
    // console.log(morePage);
    morePage.style.display = "block"; // 화면에 표시
}

/*
함수(메서드)이름 : moreClose()
설명 : 약관전문을 보여주는 화면에서 닫기 버튼을 클릭하면 창이 사라지는 기능을 하는 함수
지역변수
morePage : 약관더보기 레이아웃이 지정된 요소를 저장
매개변수
num : n번째 요소임을 전달받아 num 변수로 사용
*/
function moreClose(num){
    var morePage = document.getElementsByClassName("layer_more")[num];
    morePage.style.display = "none"; // 화면에서 감춤
}