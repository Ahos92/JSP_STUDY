CREATE TABLE logintest (
    user_id varchar2(10) CONSTRAINT lgt_id_pk PRIMARY KEY,
    user_password varchar2(20) CONSTRAINT lgt_pwd_nn NOT NULL,
    user_name VARCHAR2(20) CONSTRAINT lgt_name_nn NOT NULL,
    user_age number(3) constraint lgt_age_nn not null
);

select * from logintest where user_id = 'aaaa';
delete from logintest;
insert into logintest values('aaaa', 'agUbQcTV', 'ȫ�浿', '22');