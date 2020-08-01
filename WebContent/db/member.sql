DROP TABLE member;
COMMIT;

CREATE TABLE member(
	id VARCHAR2(20) primary key,
	pwd VARCHAR2(20),
	name VARCHAR2(20),
	phone VARCHAR2(20),
	indate DATE DEFAULT SYSDATE,
	use CHAR(1) DEFAULT 'N', -- 사용가능한 사용자인지 판별, Y: 관리자가 승인한 회원, N: 미승인회원or탈퇴회원
    grade VARCHAR2(20) DEFAULT 'NORMAL'
);
COMMIT;

SELECT * FROM member;

INSERT INTO member VALUES('scott', 'tiger', '스캇', '01011112222', SYSDATE, 'Y', 'NORMAL'); 
COMMIT;

INSERT INTO member VALUES('scott2', 'tiger2', '스캇2', '01022223333', SYSDATE, 'N', 'NORMAL'); 
COMMIT;

INSERT INTO member VALUES('sanghoo', 'sanghoo', '관리자', '01039257715', SYSDATE, 'Y', 'ADMIN'); 
COMMIT;

SELECT * FROM member WHERE use='N';

UPDATE member set use='Y' WHERE id='scott2';
commit;






