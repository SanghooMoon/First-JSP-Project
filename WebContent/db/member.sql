DROP TABLE member;
COMMIT;

CREATE TABLE member(
	id VARCHAR2(20) primary key,
	pwd VARCHAR2(20),
	name VARCHAR2(20),
	phone VARCHAR2(20),
	indate DATE DEFAULT SYSDATE,
	use CHAR(1) DEFAULT 'Y' -- 사용가능한 사용자인지 판별, Y: 관리자가 승인한 회원, N: 미승인회원or탈퇴회원
);
COMMIT;

