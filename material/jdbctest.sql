CREATE TABLE logintest (
    user_id varchar2(10) CONSTRAINT lgt_id_pk PRIMARY KEY,
    user_password char(64) CONSTRAINT lgt_pwd_nn NOT NULL,
    user_name VARCHAR2(20) CONSTRAINT lgt_name_nn NOT NULL,
    user_age number(3) constraint lgt_age_nn not null,
    user_salt char(32) constraint lgt_salt_nn not null
);

desc logintest;

select * from logintest;
select * from logintest where user_id = 'aa';

delete from logintest;
delete from logintest where user_id = 'ahos';

drop table logintest;