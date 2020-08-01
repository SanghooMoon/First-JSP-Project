DROP TABLE member;
COMMIT;

CREATE TABLE member(
	id VARCHAR2(20) primary key,
	pwd VARCHAR2(20),
	name VARCHAR2(20),
	phone VARCHAR2(20),
	indate DATE DEFAULT SYSDATE,
	use CHAR(1) DEFAULT 'N', -- ��밡���� ��������� �Ǻ�, Y: �����ڰ� ������ ȸ��, N: �̽���ȸ��orŻ��ȸ��
    grade VARCHAR2(20) DEFAULT 'NORMAL'
);
COMMIT;

SELECT * FROM member;

INSERT INTO member VALUES('scott', 'tiger', '��ı', '01011112222', SYSDATE, 'Y', 'NORMAL'); 
COMMIT;

INSERT INTO member VALUES('scott2', 'tiger2', '��ı2', '01022223333', SYSDATE, 'N', 'NORMAL'); 
COMMIT;

INSERT INTO member VALUES('sanghoo', 'sanghoo', '������', '01039257715', SYSDATE, 'Y', 'ADMIN'); 
COMMIT;

SELECT * FROM member WHERE use='N';

UPDATE member set use='Y' WHERE id='scott2';
commit;






