--���� ���̺� ����

--    task_item : score
    rename task_item to score;
    alter table score rename column task_item_idx to score_idx;
    alter table score rename column task_score to score;
    alter table score rename column task_item_info_idx to task_idx;

--   section_item : section_tasks
    rename section_item to section_tasks;
    alter table section_tasks rename column section_item_idx to section_tasks_idx;
    alter table section_tasks rename column task_item_info_idx to task_idx;

--    task_item_info : task
    rename task_item_info to task;
    alter table task rename column task_item_info_idx to task_idx;

--  class_default_task ����
    drop table CLASS_DEFAULT_TASK;

--    jpa ���� �����ϰ� �ٽ� �����ϴ� �۾�!
-- score : section, student, task
-- sectionTask : section, task
-- task : class


--������ ����� �̸��� ���̺� �����
--drop table section_tasks;
--drop table score;
--drop table Task;

--������
--�߰�
    CREATE SEQUENCE "AUTH_CLASS_SEQ_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    CREATE SEQUENCE  "AUTH_STUDENT_SEQ_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    CREATE SEQUENCE  "CLASS_MEMBERS_SEQ_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    CREATE SEQUENCE  "SCHOOL_SEQ_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    CREATE SEQUENCE  "SEASON_SEQ_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

--   drop sequence AUTH_CLASS_SEQ_NO;
-- ������ �ѹ�Ȯ�� ��ȣ ?��?
   SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'AUTH_CLASS_SEQ_NO';
--   ALTER SEQUENCE AUTH_CLASS_SEQ_NO INCREMENT BY +37;
   select AUTH_CLASS_SEQ_NO.nextval from dual;


--������ �̸� ����
   rename task_item_seq_no to score_seq_no;
   rename task_item_name_seq_no to task_seq_no;
   rename section_item_seq_no to section_tasks_seq_no;


--school
--�б��� �Է�
insert into school values(school_seq_no.nextval,null,'CSIS');

--season
--����� �Է� (idx,name,schoolidx)
insert into season values(season_seq_no.nextval,'2020 Fall Semester',1);
insert into season values(season_seq_no.nextval,'2021 Spring Semester',1);

--account
--��� ������ �б��� ���� ����
update account set school_idx = 1,authority = 0 ;
--������ 0�� ������ auto_save 0����
update account set auto_save = 0 where authority =0;

--class
--Ŭ���� ��ü�� ����1��
update class set season_idx = 1 ;
update student set season_idx = 1;
commit;
--update auth_class set season_idx = 1;
--update auth_student set season_idx = 1;

--auth_class
-- Ŭ���� �����͸� ���鼭 ����
-- Ŭ���� ���̵�� �������� �ϳ��� �츱 ����
-- delete�� ����� �ȵȴ�! Ŭ���� ���Ἲ �ذ��ϰ� �ͼ� ������
-- id, Ŭ����id (��ǥ �ϳ�), ����id, ����id (1)

    --CB
    insert into auth_class values(auth_class_seq_no.nextval,44,54,1);
    insert into auth_class values(auth_class_seq_no.nextval,44,55,1);
    insert into auth_class values(auth_class_seq_no.nextval,44,21,1);
    insert into auth_class values(auth_class_seq_no.nextval,44,58,1);
    insert into auth_class values(auth_class_seq_no.nextval,44,59,1);
    delete from class where class_idx in (65,56,61,72);
    --Character Building
    insert into auth_class values(auth_class_seq_no.nextval,46,62,1);
    insert into auth_class values(auth_class_seq_no.nextval,46,57,1);
    insert into auth_class values(auth_class_seq_no.nextval,46,53,1);
    insert into auth_class values(auth_class_seq_no.nextval,46,56,1);
          --insert into auth_class values(auth_class_seq_no.nextval,44,null,1); ????????????????
          delete from task where task_idx = 52;
          delete from class where class_idx = 55;
    delete from class where class_idx in (69,60,55,78);
    --Fine Arts
    insert into auth_class values(auth_class_seq_no.nextval,77,56,1);
    --History
    insert into auth_class values(auth_class_seq_no.nextval,76,56,1);
    --LA
    insert into auth_class values(auth_class_seq_no.nextval,66,55,1);
    insert into auth_class values(auth_class_seq_no.nextval,66,21,1);
    delete from class where class_idx in (85);
    --Language Arts
    insert into auth_class values(auth_class_seq_no.nextval,49,21,1);
    insert into auth_class values(auth_class_seq_no.nextval,49,62,1);
    insert into auth_class values(auth_class_seq_no.nextval,49,59,1);
    insert into auth_class values(auth_class_seq_no.nextval,49,57,1);
    insert into auth_class values(auth_class_seq_no.nextval,49,56,1);
    delete from class where class_idx in (73,70,79,59);
    --Math
    insert into auth_class values(auth_class_seq_no.nextval,57,54,1);
    insert into auth_class values(auth_class_seq_no.nextval,57,62,1);
    insert into auth_class values(auth_class_seq_no.nextval,57,55,1);
    insert into auth_class values(auth_class_seq_no.nextval,57,21,1);
    insert into auth_class values(auth_class_seq_no.nextval,57,57,1);
    insert into auth_class values(auth_class_seq_no.nextval,57,56,1);
    delete from class where class_idx in (83,71,80,62,75);
    --Math 2
    insert into auth_class values(auth_class_seq_no.nextval,51,59,1);
    --Math test
    insert into auth_class values(auth_class_seq_no.nextval,88,53,1);
    --Science
    insert into auth_class values(auth_class_seq_no.nextval,50,57,1);
    insert into auth_class values(auth_class_seq_no.nextval,50,56,1);
    insert into auth_class values(auth_class_seq_no.nextval,50,62,1);
    insert into auth_class values(auth_class_seq_no.nextval,50,59,1);
    insert into auth_class values(auth_class_seq_no.nextval,50,21,1);
    insert into auth_class values(auth_class_seq_no.nextval,50,55,1);
    delete from class where class_idx in (81,74,68,67,87);
    --Ŭ���� 1
    insert into auth_class values(auth_class_seq_no.nextval,41,22,1);
    --Ŭ���� 2
    insert into auth_class values(auth_class_seq_no.nextval,53,22,1);
    --Ŭ����3
    insert into auth_class values(auth_class_seq_no.nextval,63,22,1);


--student
--auth_student
--class_members

--attendance

-----------auth_Class�� ��������� �۾��� �� �ִ�.
--section
--select * from auth_class where class_idx = 41 and user_idx = (select user_idx from class where class_idx = (select class_idx from section where section_idx = 1));
--update section s set auth_class_idx = (select

--task : task_item_info

-----------�� �ǵ� ��
--section_tasks : section_item

-----------auth_Class, class_Members�� ��������� �۾��� �� �ִ�.
--score : task_item
