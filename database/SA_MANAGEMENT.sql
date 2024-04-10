create database SA_MANAGEMENT;

use SA_MANAGEMENT;

show tables;

drop database SA_MANAGEMENT;

CREATE TABLE SA_MANAGEMENT.CUSTOMER_MST(   
    CUSTOMER_ID INTEGER PRIMARY KEY auto_increment,
    CUSTOMER_NAME VARCHAR(100) NOT NULL,
    ADDRESS VARCHAR(300),
	STATE VARCHAR(50),
    CITY VARCHAR(50),
    PINCODE INTEGER,
    PAN varchar(15),
    REGISTRATION_TYPE VARCHAR(50), 
    MOBILE_NO VARCHAR(15) NOT NULL,
    CUSTOMER_MAIL varchar(50), 
    GST_NO VARCHAR(20),
    NAME_ON_PASSBOOK VARCHAR(100),
    BANK_AC_NO VARCHAR(25),
    IFSC_CODE VARCHAR(20)
);
alter TABLE CUSTOMER_MST modify column PAN varchar(15);

insert into CUSTOMER_MST(CUSTOMER_NAME,ADDRESS,STATE,CITY,PINCODE,
PAN,REGISTRATION_TYPE,MOBILE_NO,CUSTOMER_MAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE) 
VALUE('RUTIK','VIJYA NAGAR','GUJARAT','UDHNA','394210','DFGR12345D','REGULAR','9054016603','RUTIK@GMAIL.COM','GST','BOB','38793874934','BOBC89734');

UPDATE CUSTOMER_MST SET CUSTOMER_NAME = ?,ADDRESS = ?,
STATE = ?,CITY = ?,PINCODE = ?,PAN = ?,REGISTRATION_TYPE = ?,
MOBILE_NO = ?,CUSTOMER_MAIL = ? ,GST_NO = ?
,NAME_ON_PASSBOOK = ?,BANK_AC_NO = ?,IFSC_CODE = ? WHERE CUSTOMER_ID = ?;

select * from CUSTOMER_MST;
SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,REGISTRATION_TYPE,MOBILE_NO,GST_NO FROM SA_MANAGEMENT.CUSTOMER_MST;

delete from CUSTOMER_MST where customer_id=7;
SELECT CUSTOMER_NAME,ADDRESS,STATE,CITY,PINCODE,PAN,REGISTRATION_TYPE,MOBILE_NO,CUSTOMER_MAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE FROM SA_MANAGEMENT.CUSTOMER_MST WHERE CUSTOMER_ID = 1;

update CUSTOMER_MST set STATE='Punjat',Customer_name='' where CUSTOMER_ID=13;
