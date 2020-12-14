# universityErp
# 

--------------------------------------------------------
--  파일이 생성됨 - 화요일-7월-21-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ATTEND
--------------------------------------------------------

  CREATE TABLE "EGOING"."ATTEND" 
   (   "STD_NO" NUMBER, 
   "SUB_NO" NUMBER, 
   "ATT_WEEK1" NUMBER, 
   "ATT_WEEK2" NUMBER, 
   "ATT_WEEK3" NUMBER, 
   "ATT_WEEK4" NUMBER, 
   "ATT_WEEK5" NUMBER, 
   "ATT_WEEK6" NUMBER, 
   "ATT_WEEK7" NUMBER, 
   "ATT_WEEK8" NUMBER, 
   "ATT_WEEK9" NUMBER, 
   "ATT_WEEK10" NUMBER, 
   "ATT_WEEK11" NUMBER, 
   "ATT_WEEK12" NUMBER, 
   "ATT_WEEK13" NUMBER, 
   "ATT_WEEK14" NUMBER, 
   "ATT_WEEK15" NUMBER, 
   "ATT_START" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table AUTHOR
--------------------------------------------------------

  CREATE TABLE "EGOING"."AUTHOR" 
   (   "ID" NUMBER, 
   "NAME" VARCHAR2(20 BYTE), 
   "PROFILE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CURRSUB
--------------------------------------------------------

  CREATE TABLE "EGOING"."CURRSUB" 
   (   "STD_NO" NUMBER, 
   "SUB_NO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HYUHAK
--------------------------------------------------------

  CREATE TABLE "EGOING"."HYUHAK" 
   (   "STD_NO" NUMBER, 
   "START_SEM" NUMBER, 
   "SEMS" NUMBER, 
   "REASON" VARCHAR2(1000 BYTE), 
   "CONFIRMED" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PROFESSOR
--------------------------------------------------------

  CREATE TABLE "EGOING"."PROFESSOR" 
   (   "PROF_NO" NUMBER, 
   "PROF_PW" VARCHAR2(50 BYTE), 
   "PROF_NAME" VARCHAR2(20 BYTE), 
   "PROF_BIRTH" DATE, 
   "PROF_MAJOR" VARCHAR2(50 BYTE), 
   "PROF_EMAIL" VARCHAR2(60 BYTE), 
   "PROF_GENDER" VARCHAR2(6 BYTE), 
   "PROF_JOB" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SCORE
--------------------------------------------------------

  CREATE TABLE "EGOING"."SCORE" 
   (   "STD_NO" NUMBER, 
   "SUB_NO" NUMBER, 
   "STD_SCORE" VARCHAR2(6 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "EGOING"."STUDENT" 
   (   "STD_NO" NUMBER, 
   "STD_PW" VARCHAR2(50 BYTE), 
   "STD_NAME" VARCHAR2(20 BYTE), 
   "STD_BIRTH" DATE, 
   "STD_MAJOR" VARCHAR2(50 BYTE), 
   "STD_EMAIL" VARCHAR2(60 BYTE), 
   "STD_GENDER" VARCHAR2(6 BYTE), 
   "STD_JOB" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STUDENTADD
--------------------------------------------------------

  CREATE TABLE "EGOING"."STUDENTADD" 
   (   "STD_NO" NUMBER, 
   "STD_GRADE" NUMBER, 
   "STD_STATUS" NUMBER, 
   "STD_TOTAL_CREDIT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SUBJECT
--------------------------------------------------------

  CREATE TABLE "EGOING"."SUBJECT" 
   (   "SUB_NO" NUMBER, 
   "SUB_NAME" VARCHAR2(30 BYTE), 
   "PROF_NO" NUMBER, 
   "SUB_TIME" NUMBER, 
   "SUB_DAY" VARCHAR2(10 BYTE), 
   "SUB_CREDIT" NUMBER, 
   "SUB_CAPACITY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TOPIC
--------------------------------------------------------

  CREATE TABLE "EGOING"."TOPIC" 
   (   "ID" NUMBER, 
   "TITLE" VARCHAR2(50 BYTE), 
   "DESCRIPTION" VARCHAR2(4000 BYTE), 
   "CREATED" DATE, 
   "AUTHOR_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence SEQ_AUTHOR
--------------------------------------------------------

   CREATE SEQUENCE  "EGOING"."SEQ_AUTHOR"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_TOPIC
--------------------------------------------------------

   CREATE SEQUENCE  "EGOING"."SEQ_TOPIC"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into EGOING.ATTEND
SET DEFINE OFF;
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (2,160111,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,to_date('20/07/20','RR/MM/DD'));
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (2,160112,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,to_date('20/07/20','RR/MM/DD'));
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (2,170211,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,to_date('20/07/20','RR/MM/DD'));
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (1,160111,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,to_date('20/07/09','RR/MM/DD'));
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (1,160112,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,to_date('20/07/09','RR/MM/DD'));
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (1,170211,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,to_date('20/07/09','RR/MM/DD'));
Insert into EGOING.ATTEND (STD_NO,SUB_NO,ATT_WEEK1,ATT_WEEK2,ATT_WEEK3,ATT_WEEK4,ATT_WEEK5,ATT_WEEK6,ATT_WEEK7,ATT_WEEK8,ATT_WEEK9,ATT_WEEK10,ATT_WEEK11,ATT_WEEK12,ATT_WEEK13,ATT_WEEK14,ATT_WEEK15,ATT_START) values (1,180112,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,to_date('20/07/09','RR/MM/DD'));
REM INSERTING into EGOING.AUTHOR
SET DEFINE OFF;
Insert into EGOING.AUTHOR (ID,NAME,PROFILE) values (1,'egoing','developer');
Insert into EGOING.AUTHOR (ID,NAME,PROFILE) values (2,'duru','DBA');
Insert into EGOING.AUTHOR (ID,NAME,PROFILE) values (3,'taeho','data scientist');
REM INSERTING into EGOING.CURRSUB
SET DEFINE OFF;
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (1,160111);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (1,160213);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (1,190122);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (2,160111);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (2,160112);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (2,170211);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (2,180217);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (101,160112);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (101,160213);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (101,180112);
Insert into EGOING.CURRSUB (STD_NO,SUB_NO) values (101,180217);
REM INSERTING into EGOING.HYUHAK
SET DEFINE OFF;
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (1,20202,1,'학교 가기 시르엉 ㅠㅠ',1);
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (1,20202,1,'1234',1);
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (2,20202,1,'adf',1);
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (2,20202,1,'adf',1);
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (1,20202,1,'adfadf',1);
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (1,20202,1,'1111',1);
Insert into EGOING.HYUHAK (STD_NO,START_SEM,SEMS,REASON,CONFIRMED) values (4,20202,1,'1111',1);
REM INSERTING into EGOING.PROFESSOR
SET DEFINE OFF;
Insert into EGOING.PROFESSOR (PROF_NO,PROF_PW,PROF_NAME,PROF_BIRTH,PROF_MAJOR,PROF_EMAIL,PROF_GENDER,PROF_JOB) values (101,'aaa','길동',to_date('75/01/01','RR/MM/DD'),'컴퓨터공학','bbb@naver.com','m',0);
Insert into EGOING.PROFESSOR (PROF_NO,PROF_PW,PROF_NAME,PROF_BIRTH,PROF_MAJOR,PROF_EMAIL,PROF_GENDER,PROF_JOB) values (102,'aaa','영희',to_date('66/01/01','RR/MM/DD'),'통계학','ddd@naver.com','f',0);
REM INSERTING into EGOING.SCORE
SET DEFINE OFF;
Insert into EGOING.SCORE (STD_NO,SUB_NO,STD_SCORE) values (1,160111,'A');
Insert into EGOING.SCORE (STD_NO,SUB_NO,STD_SCORE) values (1,160112,'C');
Insert into EGOING.SCORE (STD_NO,SUB_NO,STD_SCORE) values (1,170211,'A');
Insert into EGOING.SCORE (STD_NO,SUB_NO,STD_SCORE) values (1,180112,'A');
REM INSERTING into EGOING.STUDENT
SET DEFINE OFF;
Insert into EGOING.STUDENT (STD_NO,STD_PW,STD_NAME,STD_BIRTH,STD_MAJOR,STD_EMAIL,STD_GENDER,STD_JOB) values (1,'aaa','김민수',to_date('95/01/01','RR/MM/DD'),'컴퓨터공학','gg@nav.com','F',1);
Insert into EGOING.STUDENT (STD_NO,STD_PW,STD_NAME,STD_BIRTH,STD_MAJOR,STD_EMAIL,STD_GENDER,STD_JOB) values (2,'aaa','민수',to_date('96/01/01','RR/MM/DD'),'통계학','bbb@naver.com','m',1);
Insert into EGOING.STUDENT (STD_NO,STD_PW,STD_NAME,STD_BIRTH,STD_MAJOR,STD_EMAIL,STD_GENDER,STD_JOB) values (3,'aaa','철수',to_date('00/05/05','RR/MM/DD'),'행정학과','abc@naver.com','F',1);
Insert into EGOING.STUDENT (STD_NO,STD_PW,STD_NAME,STD_BIRTH,STD_MAJOR,STD_EMAIL,STD_GENDER,STD_JOB) values (4,'aaa','다운',to_date('00/01/01','RR/MM/DD'),'컴퓨터공학','aba@abac.com','F',1);
REM INSERTING into EGOING.STUDENTADD
SET DEFINE OFF;
Insert into EGOING.STUDENTADD (STD_NO,STD_GRADE,STD_STATUS,STD_TOTAL_CREDIT) values (1,3,1,180);
Insert into EGOING.STUDENTADD (STD_NO,STD_GRADE,STD_STATUS,STD_TOTAL_CREDIT) values (2,3,1,180);
Insert into EGOING.STUDENTADD (STD_NO,STD_GRADE,STD_STATUS,STD_TOTAL_CREDIT) values (3,2,4,100);
Insert into EGOING.STUDENTADD (STD_NO,STD_GRADE,STD_STATUS,STD_TOTAL_CREDIT) values (4,2,1,150);
REM INSERTING into EGOING.SUBJECT
SET DEFINE OFF;
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (160111,'하브쨩의 심쿵비트',101,9,'월',3,20);
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (160112,'하브하브러브러브',102,9,'월',3,20);
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (170211,'하브와 미츠코쨩',101,9,'월',3,20);
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (180112,'블랙윙의 자바',102,9,'월',3,20);
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (160213,'Java',102,13,'화',3,20);
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (180217,'JSP/Servlet',102,13,'수',3,20);
Insert into EGOING.SUBJECT (SUB_NO,SUB_NAME,PROF_NO,SUB_TIME,SUB_DAY,SUB_CREDIT,SUB_CAPACITY) values (190122,'Spring',101,13,'목',3,20);
REM INSERTING into EGOING.TOPIC
SET DEFINE OFF;
Insert into EGOING.TOPIC (ID,TITLE,DESCRIPTION,CREATED,AUTHOR_ID) values (1,'ORACLE','ORACLE is...',to_date('20/06/30','RR/MM/DD'),1);
Insert into EGOING.TOPIC (ID,TITLE,DESCRIPTION,CREATED,AUTHOR_ID) values (2,'MySQL','MySQL is...',to_date('20/06/30','RR/MM/DD'),1);
Insert into EGOING.TOPIC (ID,TITLE,DESCRIPTION,CREATED,AUTHOR_ID) values (3,'SQL Server','SQL Server is...',to_date('20/06/30','RR/MM/DD'),2);
Insert into EGOING.TOPIC (ID,TITLE,DESCRIPTION,CREATED,AUTHOR_ID) values (4,'MongoDB','MongoDB is...',to_date('20/06/30','RR/MM/DD'),3);
--------------------------------------------------------
--  DDL for Index PK_ATTEND
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."PK_ATTEND" ON "EGOING"."ATTEND" ("STD_NO", "SUB_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_AUTHOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."PK_AUTHOR" ON "EGOING"."AUTHOR" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CURRSUB
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."PK_CURRSUB" ON "EGOING"."CURRSUB" ("STD_NO", "SUB_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_SCORE
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."PK_SCORE" ON "EGOING"."SCORE" ("STD_NO", "SUB_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TOPIC
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."PK_TOPIC" ON "EGOING"."TOPIC" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012396
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."SYS_C0012396" ON "EGOING"."STUDENT" ("STD_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012402
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."SYS_C0012402" ON "EGOING"."PROFESSOR" ("PROF_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012419
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."SYS_C0012419" ON "EGOING"."STUDENTADD" ("STD_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012493
--------------------------------------------------------

  CREATE UNIQUE INDEX "EGOING"."SYS_C0012493" ON "EGOING"."SUBJECT" ("SUB_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ATTEND
--------------------------------------------------------

  ALTER TABLE "EGOING"."ATTEND" ADD CONSTRAINT "PK_ATTEND" PRIMARY KEY ("STD_NO", "SUB_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "EGOING"."ATTEND" MODIFY ("STD_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."ATTEND" MODIFY ("SUB_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."ATTEND" MODIFY ("ATT_START" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AUTHOR
--------------------------------------------------------

  ALTER TABLE "EGOING"."AUTHOR" ADD CONSTRAINT "PK_AUTHOR" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "EGOING"."AUTHOR" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."AUTHOR" MODIFY ("NAME" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."AUTHOR" MODIFY ("PROFILE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CURRSUB
--------------------------------------------------------

  ALTER TABLE "EGOING"."CURRSUB" ADD CONSTRAINT "PK_CURRSUB" PRIMARY KEY ("STD_NO", "SUB_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PROFESSOR
--------------------------------------------------------

  ALTER TABLE "EGOING"."PROFESSOR" MODIFY ("PROF_PW" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."PROFESSOR" MODIFY ("PROF_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."PROFESSOR" MODIFY ("PROF_MAJOR" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."PROFESSOR" MODIFY ("PROF_GENDER" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."PROFESSOR" MODIFY ("PROF_JOB" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."PROFESSOR" ADD PRIMARY KEY ("PROF_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SCORE
--------------------------------------------------------

  ALTER TABLE "EGOING"."SCORE" ADD CONSTRAINT "PK_SCORE" PRIMARY KEY ("STD_NO", "SUB_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "EGOING"."SCORE" MODIFY ("STD_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SCORE" MODIFY ("SUB_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SCORE" MODIFY ("STD_SCORE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "EGOING"."STUDENT" MODIFY ("STD_PW" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENT" MODIFY ("STD_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENT" MODIFY ("STD_MAJOR" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENT" MODIFY ("STD_GENDER" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENT" MODIFY ("STD_JOB" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENT" ADD PRIMARY KEY ("STD_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STUDENTADD
--------------------------------------------------------

  ALTER TABLE "EGOING"."STUDENTADD" ADD CONSTRAINT "PK_STUDENTADD" PRIMARY KEY ("STD_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "EGOING"."STUDENTADD" MODIFY ("STD_GRADE" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENTADD" MODIFY ("STD_STATUS" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."STUDENTADD" MODIFY ("STD_TOTAL_CREDIT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SUBJECT
--------------------------------------------------------

  ALTER TABLE "EGOING"."SUBJECT" MODIFY ("SUB_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SUBJECT" MODIFY ("PROF_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SUBJECT" MODIFY ("SUB_TIME" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SUBJECT" MODIFY ("SUB_DAY" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SUBJECT" MODIFY ("SUB_CREDIT" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SUBJECT" MODIFY ("SUB_CAPACITY" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."SUBJECT" ADD PRIMARY KEY ("SUB_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TOPIC
--------------------------------------------------------

  ALTER TABLE "EGOING"."TOPIC" ADD CONSTRAINT "PK_TOPIC" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "EGOING"."TOPIC" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "EGOING"."TOPIC" MODIFY ("TITLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SCORE
--------------------------------------------------------

  ALTER TABLE "EGOING"."SCORE" ADD CONSTRAINT "SCORE_FK1" FOREIGN KEY ("SUB_NO")
     REFERENCES "EGOING"."SUBJECT" ("SUB_NO") ENABLE;
 
  ALTER TABLE "EGOING"."SCORE" ADD CONSTRAINT "SCORE_FK2" FOREIGN KEY ("STD_NO")
     REFERENCES "EGOING"."STUDENT" ("STD_NO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STUDENTADD
--------------------------------------------------------

  ALTER TABLE "EGOING"."STUDENTADD" ADD CONSTRAINT "FK_STUDENTADD" FOREIGN KEY ("STD_NO")
     REFERENCES "EGOING"."STUDENT" ("STD_NO") ENABLE;
 
 insert into subject values(
200211,'20년 2학기 강의1',101,9,'월',3,20);
insert into subject values(
200212,'20년 2학기 강의2',101,9,'월',3,20);
insert into subject values(
200213,'20년 2학기 강의3',101,9,'월',3,20);
insert into subject values(
200214,'20년 2학기 강의4',102,9,'월',3,20);
insert into subject values(
200215,'20년 2학기 강의5',102,9,'월',3,20);
insert into subject values(
200216,'20년 2학기 강의6',102,9,'월',3,20);
 select * from subject;
     
commit;
