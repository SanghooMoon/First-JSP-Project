DROP TABLE member;
COMMIT;

CREATE TABLE member(
	id VARCHAR2(20) primary key,
	pwd VARCHAR2(20),
	name VARCHAR2(20),
	phone VARCHAR2(20),
	indate DATE DEFAULT SYSDATE,
	use CHAR(1) DEFAULT 'Y' -- ��밡���� ��������� �Ǻ�, Y: �����ڰ� ������ ȸ��, N: �̽���ȸ��orŻ��ȸ��
);
COMMIT;

